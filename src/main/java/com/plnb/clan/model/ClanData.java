package com.plnb.clan.model;

import java.util.List;

public class ClanData {

    private String Name;
    private List<ClanMember> Members;
    private Long DepositedDiamonds;
    private DiamondContributionData DiamondContributions;

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

    public Object getDiamondContributionsData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}