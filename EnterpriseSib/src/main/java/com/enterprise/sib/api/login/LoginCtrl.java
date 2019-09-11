package com.enterprise.sib.api.login;

import com.enterprise.sib.utils.Connection;
import com.enterprise.sib.utils.JsonConverter;
import org.springframework.stereotype.Controller;

@Controller
class LoginCtrl {

    private LoginMdlResp getResponse(String url) {

        JsonConverter<LoginMdlResp> jsonConverter = new JsonConverter<>();
        String json = Connection.getResponse(url);

        return jsonConverter.fromJson(json, LoginMdlResp.class);
    }

    LoginMdlResp efetuarLogin() {

        LoginMdlReq loginRequest = new LoginMdlReq();
        loginRequest.setUsuario("ENTERPRISE");
        loginRequest.setSenha("ENTERPRISE2019@)!(");

        String url = "https://dataintelligence.newdbase.com.br/auth/credentials" +
                "?username=" + loginRequest.getUsuario() +
                "&password=" + loginRequest.getSenha() +
                "&format=json";

        return getResponse(url);
    }
}
