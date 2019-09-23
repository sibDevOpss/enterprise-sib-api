package com.enterprise.sib.api.cep;

import com.enterprise.sib.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Api
@Service
@RestController
@RequestMapping(
        path = Constant.URL_MAIN,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CepEnd {

    @Autowired
    private CepCtrl cepController;

    @ApiOperation(value = "Consultar CEP", tags = Constant.TAG_DEFAULT)
    @PostMapping(path = "/consultar_cep")
    public ResponseEntity<CepMdlResp> consultarCep(@RequestBody CepMdlReq params) {
        try {
            return new ResponseEntity<>(cepController.consultarCep(params), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP Inválido!", e);
        }
    }

}
