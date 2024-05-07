package com.bingogame.endpoint.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class BingoResponse {
    @JsonProperty("playcard_token")
    private String playcardToken;

    @JsonProperty("card")
    private Map<String, List<Integer>> card;

}