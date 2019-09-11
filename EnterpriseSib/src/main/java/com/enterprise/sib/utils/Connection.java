package com.enterprise.sib.utils;

import org.springframework.web.client.RestTemplate;

public class Connection {

    /**
     * Obtém a resposta da API no formato String
     *
     * @param url URL da API
     * @return Resposta no formato String
     */
    public static String getResponse(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

}