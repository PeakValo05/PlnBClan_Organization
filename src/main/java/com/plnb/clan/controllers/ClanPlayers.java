package com.plnb.clan.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.plnb.clan.model.ClanData;
import com.plnb.clan.model.ClanMember;
import com.plnb.clan.model.ClanPlayerView;
import com.plnb.clan.model.DiamondContribution;
import com.plnb.clan.model.RobloxUser;
import com.plnb.clan.service.BigGamesService;
import com.plnb.clan.service.RobloxService;

@Controller
public class ClanPlayers {

    private final BigGamesService bigGamesService;
    private final RobloxService robloxService;

    public ClanPlayers(BigGamesService bigGamesService,
                       RobloxService robloxService) {

        this.bigGamesService = bigGamesService;
        this.robloxService = robloxService;
    }

    @GetMapping("/clan-players")
    public String getClanPlayersPage(Model model) {

        ClanData clanData = bigGamesService.getClanDataObject();

        List<Long> userIds = clanData.getMembers()
                .stream()
                .map(ClanMember::getUserID)
                .toList();

        List<RobloxUser> robloxUsers =
                robloxService.getUsers(userIds);

        List<ClanPlayerView> players = new ArrayList<>();

        for (ClanMember member : clanData.getMembers()) {

            RobloxUser matchingUser = null;

            for (RobloxUser user : robloxUsers) {

                if (user.getId().equals(member.getUserID())) {
                    matchingUser = user;
                    break;
                }
            }

            if (matchingUser != null) {

                ClanPlayerView player = new ClanPlayerView();

                player.setUserId(member.getUserID());
                player.setUsername(matchingUser.getName());
                player.setDisplayName(matchingUser.getDisplayName());
                player.setPermissionLevel(member.getPermissionLevel());
                player.setJoinTime(member.getJoinTime());

                long diamonds = 0;

                for (DiamondContribution contribution :

                        clanData.getDiamondContributions().getAllTime().getData()) {

                    if (contribution.getUserID()
                            .equals(member.getUserID())) {

                        diamonds = contribution.getDiamonds();
                        break;
                    }
                }

                player.setDiamonds(diamonds);

                players.add(player);
            }
        }

        // AFTER all players have been processed
        model.addAttribute("players", players);

        return "clan-players";
    }
}