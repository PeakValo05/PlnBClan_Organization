package com.plnb.clan.model;

import java.util.List;

public class RobloxUsersRequest {

    private List<Long> userIds;
    private boolean excludeBannedUsers = false;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public boolean isExcludeBannedUsers() {
        return excludeBannedUsers;
    }

    public void setExcludeBannedUsers(boolean excludeBannedUsers) {
        this.excludeBannedUsers = excludeBannedUsers;
    }
}