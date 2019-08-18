package com.enterprise.sib.api.login;

import com.enterprise.sib.utilitarios.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@Service
@RestController
@RequestMapping(Constant.URL_MAIN_PATH)
public class LoginEnd {

    @Autowired
    private LoginCtrl loginController;

    @ApiOperation(value = "Login", tags = Constant.DEFAULT_TAG)
    @PostMapping(path = "/login")
    public ResponseEntity<LoginRespMdl> login(@RequestBody LoginReqMdl request) {
        return new ResponseEntity<>(loginController.efetuarLogin(request), HttpStatus.OK);
    }
}
