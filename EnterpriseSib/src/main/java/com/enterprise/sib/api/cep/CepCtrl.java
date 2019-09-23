package com.enterprise.sib.api.cep;

import com.enterprise.sib.utils.Connection;
import com.enterprise.sib.utils.JsonConverter;
import org.springframework.stereotype.Controller;

@Controller
class CepCtrl {

    private CepMdlResp getResponse(String url) {

        JsonConverter<CepMdlResp> jsonConverter = new JsonConverter<>();
        String json = Connection.getResponse(url);

        return jsonConverter.fromJson(json, CepMdlResp.class);
    }

    CepMdlResp consultarCep(CepMdlReq cepMdlReq) {
        String url = "https://viacep.com.br/ws/" + cepMdlReq.getCep() + "/json/";
        return getResponse(url);
    }
}
