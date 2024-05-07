package com.bingogame.endpoint.Service;

import com.bingogame.endpoint.Model.BingoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BingoService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public BingoService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private final String GET_CARD_URL = "http://www.hyeumine.com/getcard.php?bcode=";
    private final String CHECK_WIN_URL = "http://www.hyeumine.com/checkwin.php?playcard_token=";

    public BingoResponse getCard(String bcode) throws JsonProcessingException {
        String url = GET_CARD_URL + bcode;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        return objectMapper.readValue(responseEntity.getBody(), BingoResponse.class);
    }

    public ResponseEntity<String> checkWin(String playcard_token) {
        String url = CHECK_WIN_URL + playcard_token;
        return restTemplate.getForEntity(url, String.class);
    }
}
