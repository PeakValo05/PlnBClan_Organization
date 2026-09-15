package com.plnb.clan.model;

import java.util.List;

public class ClanData {

    private String Name;
    private List<ClanMember> Members;
    private Long DepositedDiamonds;
    private DiamondContributionData DiamondContributions;
    private Integer MemberCapacity;
    private Integer OfficerCapacity;
    private Integer GuildLevel;


    public Integer getMemberCapacity() {
        return MemberCapacity;
    }

    public void setMemberCapacity(Integer MemberCapacity) {
        this.MemberCapacity = MemberCapacity;
    }

    public Integer getOfficerCapacity() {
        return OfficerCapacity;
    }

    public void setOfficerCapacity(Integer OfficerCapacity) {
        this.OfficerCapacity = OfficerCapacity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<ClanMember> getMembers() {
        return Members;
    }

    public void setMembers(List<ClanMember> members) {
        Members = members;
    }

    public Long getDepositedDiamonds() {
        return DepositedDiamonds;
    }

    public void setDepositedDiamonds(Long depositedDiamonds) {
        DepositedDiamonds = depositedDiamonds;
    }

    public DiamondContributionData getDiamondContributions() {
        return DiamondContributions;
    }

    public void setDiamondContributions(
            DiamondContributionData diamondContributions) {
        DiamondContributions = diamondContributions;
    }

    public Integer getGuildLevel() {
        return GuildLevel;
    }

    public void setGuildLevel(Integer GuildLevel) {
        this.GuildLevel = GuildLevel;
    }
    public Object getDiamondContributionsData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}