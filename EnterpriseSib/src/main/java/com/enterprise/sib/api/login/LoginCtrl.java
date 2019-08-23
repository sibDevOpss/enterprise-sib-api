package com.enterprise.sib.api.login;

import com.enterprise.sib.utilitarios.Connection;
import org.springframework.stereotype.Controller;

@Controller
public class LoginCtrl {

    private LoginRespMdl getResponse(String url) {

        Connection<LoginRespMdl> connection = new Connection<>();
        String response = connection.getResponse(url);
        return connection.setResponse(response, LoginRespMdl.class);
    }

    LoginRespMdl efetuarLogin() {

        LoginReqMdl loginRequest = new LoginReqMdl();
        loginRequest.setUsuario("ENTERPRISE");
        loginRequest.setSenha("ENTERPRISE2019@)!(");

        String url = "https://dataintelligence.newdbase.com.br/auth/credentials" +
                "?username=" + loginRequest.getUsuario() +
                "&password=" + loginRequest.getSenha() +
                "&format=json";

        return getResponse(url);
    }
}
