package com.enterprise.sib.utils;

import com.google.gson.Gson;

public class JsonConverter<T> {

    public T fromJson(String responseApi, Class<T> responseClass) {
        Gson gson = new Gson();
        return gson.fromJson(responseApi, responseClass);
    }

    public String toJson(Object responseClass) {
        Gson gson = new Gson();
        return gson.toJson(responseClass);
    }
}
