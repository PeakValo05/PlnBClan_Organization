package com.plnb.clan.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

        long currentDiamonds = clanData.getDepositedDiamonds();
        long currentGuildLevel = clanData.getGuildLevel();
        


        // Calculate the maximum number of players and the current number of players in the clan
        int maxPlayers = clanData.getMemberCapacity();
        int currentPlayers = clanData.getMembers().size() + 1; // Including the owner

        // Add the calculated player counts to the model for the view to use
        model.addAttribute("maxPlayers", maxPlayers);
        model.addAttribute("currentPlayers", currentPlayers);
        model.addAttribute("currentDiamonds", currentDiamonds);
        model.addAttribute("guildLevel", currentGuildLevel);


        System.out.println(bigGamesService.getClanData());

        List<Long> userIds = clanData.getMembers()
                .stream()
                .map(ClanMember::getUserID)
                .toList();

        List<RobloxUser> robloxUsers =
                robloxService.getUsers(userIds);

        List<ClanPlayerView> members = new ArrayList<>();
        List<ClanPlayerView> leaders = new ArrayList<>();
        List<ClanPlayerView> officers = new ArrayList<>();

        ClanPlayerView owner = new ClanPlayerView();


        // Manually add the owner to the leaders list
        owner.setUserId(3481727973L);
        owner.setUsername("BadJeepingB");
        owner.setDisplayName("👑 BadJeepingB");

        leaders.add(owner);
        officers.add(owner);
        members.add(owner);

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



                // Calculate diamonds for the member and the owner
long diamonds = 0;
long ownerDiamonds = 0;

for (DiamondContribution contribution :
        clanData.getDiamondContributions().getAllTime().getData()) {

    // MEMBER
    if (contribution.getUserID().equals(member.getUserID())) {
        diamonds = contribution.getDiamonds();
    }

    // OWNER
    if (contribution.getUserID().equals(owner.getUserId())) {
        ownerDiamonds = contribution.getDiamonds();
    }


player.setDiamonds(diamonds);
owner.setDiamonds(ownerDiamonds);
        }
    

        

                if (player.getPermissionLevel() == 90){
                    leaders.add(player);
                } else if (player.getPermissionLevel() == 2){
                    officers.add(player);
                } else {
                    members.add(player);
                }
            }
        }

        // AFTER all players have been processed
        model.addAttribute("members", members);
        model.addAttribute("leaders", leaders);
        model.addAttribute("officers", officers);

        return "clan-players";
    }


    @GetMapping("/test-clan")
@ResponseBody
public ClanData testClan() {
    return bigGamesService.getClanDataObject();
}


}