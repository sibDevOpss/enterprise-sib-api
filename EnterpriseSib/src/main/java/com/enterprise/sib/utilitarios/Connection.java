package com.enterprise.sib.utilitarios;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

public class Connection<T> {

    /**
     * Obtém a resposta da API no formato String
     *
     * @param url URL da API
     * @return Resposta no formato String
     */
    public String getResponse(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * Converte a resposta da API String para classe Java
     *
     * @param responseApi   Resposta Json da API
     * @param responseClass Classe para qual será convertida (Nome.class)
     * @return Classe Java Convertida
     */
    @SuppressWarnings("unchecked")
    public T setResponse(String responseApi, Class<?> responseClass) {
        Gson gson = new Gson();
        return (T) gson.fromJson(responseApi, responseClass);
    }
}
