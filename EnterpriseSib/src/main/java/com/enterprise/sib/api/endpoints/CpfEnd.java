package com.enterprise.sib.api.endpoints;

import com.enterprise.sib.api.controllers.CpfCtrl;
import com.enterprise.sib.api.models.CpfMdlResp;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api()
@RestController
@RequestMapping("/enterprise")
public class CpfEnd {


    @ApiOperation(value = "Consulta de cpf", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CpfMdlResp> obtemCpf(@RequestBody ParamsConsultaCpfMdl params) {

        CpfCtrl cpfController = new CpfCtrl();
//        cpfController.gravaLog(params);

        return new ResponseEntity<>(cpfController.criarCpfTeste(), HttpStatus.BAD_REQUEST);

    }

    @ApiOperation(value = "Consulta de cpf em massa", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf_em_massa", produces = "application/json", consumes = "application/json")
    public String obtemCpfEmLotes(@RequestBody ParamsConsultaCpfMdl params) {
//
//		CpfCtrl cpfController = new CpfCtrl();
//
//		cpfController.gravaLog(params);

        return "{\"Descricao pt 1\":\"Mandar uma lista de cpf como parametro\", \"Descricao pt 2\":\"Amanha eu faço\", \"Descricao pt 3\":\"Ainda em desenvolvimento\"}";

    }
}
