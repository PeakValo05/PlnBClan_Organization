package com.plnb.clan.model;

public class ClanMember {

    private Long UserID;
    private Integer PermissionLevel;
    private Long JoinTime;

    public Long getUserID() {
        return UserID;
    }

    public void setUserID(Long userID) {
        UserID = userID;
    }

    public Integer getPermissionLevel() {
        return PermissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        PermissionLevel = permissionLevel;
    }

    public Long getJoinTime() {
        return JoinTime;
    }

    public void setJoinTime(Long joinTime) {
        JoinTime = joinTime;
    }
}