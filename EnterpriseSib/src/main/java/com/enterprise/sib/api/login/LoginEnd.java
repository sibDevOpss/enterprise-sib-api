package com.enterprise.sib.api.login;

import com.enterprise.sib.utilitarios.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api
@Service
@RestController
@RequestMapping(Constant.URL_MAIN_PATH)
public class LoginEnd {

    @ApiOperation(value = "Login", tags = Constant.DEFAULT_TAG)
    @GetMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login() {

        String url = "https://dataintelligence.newdbase.com.br/auth/credentials?username=ENTERPRISE&password=ENTERPRISE2019@)!(";

        RestTemplate restTemplate = new RestTemplate();
        LoginRespMdl loginResp = restTemplate.getForObject(url, LoginRespMdl.class);

        // Erro ao executar qualquer operação com o resultado do Login.
        System.out.println(loginResp.toString());
        return null;
    }
}
