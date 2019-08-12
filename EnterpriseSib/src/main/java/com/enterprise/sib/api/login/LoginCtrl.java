package com.enterprise.sib.api.login;

import com.enterprise.sib.utilitarios.Connection;

public class LoginCtrl {

    private static LoginRespMdl getResponse(String url) {

        Connection<LoginRespMdl> connection = new Connection<>();
        String response = connection.getResponse(url);
        return connection.setResponse(response, LoginRespMdl.class);
    }

    public static LoginRespMdl efetuarLogin(LoginReqMdl request) {

        String url = "https://dataintelligence.newdbase.com.br/auth/credentials" +
                "?username=" + request.getUsuario() +
                "&password=" + request.getSenha() +
                "&format=json";

        return getResponse(url);
    }
}