package com.plnb.clan.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.plnb.clan.model.ClanApiResponse;
import com.plnb.clan.model.ClanData;

@Service
public class BigGamesService {

    private final String API_URL =
            "https://ps99.biggamesapi.io/api/clan/PlnB";

    public String getClanData() {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(API_URL, String.class);
    }

    public ClanData getClanDataObject() {

        RestTemplate restTemplate = new RestTemplate();

        ClanApiResponse response = restTemplate.getForObject(API_URL, ClanApiResponse.class);

        return response != null ? response.getData() : null;
    }
}