package com.plnb.clan.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.plnb.clan.model.RobloxUser;
import com.plnb.clan.model.RobloxUsersRequest;
import com.plnb.clan.model.RobloxUsersResponse;

@Service
public class RobloxService {

private final String BULK_API_URL =
        "https://users.roblox.com/v1/users";


public List<RobloxUser> getUsers(List<Long> userIds) {

    RestTemplate restTemplate = new RestTemplate();

    RobloxUsersRequest request = new RobloxUsersRequest();
    request.setUserIds(userIds);
    request.setExcludeBannedUsers(false);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<RobloxUsersRequest> entity =
            new HttpEntity<>(request, headers);

    RobloxUsersResponse response =
            restTemplate.postForObject(
                    BULK_API_URL,
                    entity,
                    RobloxUsersResponse.class
            );

    return response != null ? response.getData() : List.of();
}

    }



