package com.enterprise.sib.api.endpoints;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.sib.api.controllers.CpfCtrl;
import com.enterprise.sib.api.models.CpfRespMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api()
@RestController
@RequestMapping("/enterprise")
public class CpfEnd {


    @ApiOperation(value = "Consulta de cpf", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CpfRespMdl> obtemCpf(@RequestBody ParamsConsultaCpfMdl params) {

        CpfCtrl cpfController = new CpfCtrl();
//        cpfController.gravaLog(params);

        return new ResponseEntity<CpfRespMdl>(cpfController.criarCpfTeste(), HttpStatus.BAD_REQUEST);

    }

    @ApiOperation(value = "Consulta de cpf em massa", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf_em_massa", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody List<String> params) {

		CpfCtrl cpfController = new CpfCtrl();
//		cpfController.gravaLog(params);
    	
		List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params);
		
		return new ResponseEntity<List<CpfRespMdl>> (listaCpfsEncontrados,HttpStatus.ACCEPTED);

    }
}
