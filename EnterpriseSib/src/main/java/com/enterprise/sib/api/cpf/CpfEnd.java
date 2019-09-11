package com.enterprise.sib.api.cpf;

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

import javax.servlet.http.HttpServletRequest;

@Api
@Service
@RestController
@RequestMapping(
        path = Constant.URL_MAIN,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
class CpfEnd {

    @Autowired
    private CpfCtrl cpfController;

    @ApiOperation(value = "Consulta de cpf", tags = Constant.TAG_DEFAULT, response = CpfMdlResp.class)
    @PostMapping(path = "/consultar_cpf")
    public ResponseEntity<String> consultarCpf(@RequestBody CpfMdlReq params, HttpServletRequest request) {
        return new ResponseEntity<>(cpfController.efetuarConsultaCpf(params, request), HttpStatus.OK);
    }
}
