package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.LogCtrl;
import com.enterprise.sib.utilitarios.Constant;
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

import java.util.List;

@Api
@Service
@RestController
@RequestMapping(Constant.URL_MAIN_PATH)
public class CpfEnd {

	
	@Autowired
	private CpfCtrl cpfController;
	
	@Autowired
	private LogCtrl logController;


	@ApiOperation(value = "Consulta de cpf", tags = Constant.DEFAULT_TAG)
	@PostMapping(path = "/consultar_cpf", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CpfRespMdl> obtemCpf(@RequestBody CpfReqMdl params) {
        
		logController.gravaLog(params);
		
		//Deixar a chamada de um metodo aqui para consulta unica de 1 CPF, o metodo ficará na cpfCtrl 

		return new ResponseEntity<>(cpfController.criarCpfTeste(), HttpStatus.ACCEPTED);
    }

	@ApiOperation(value = "Consulta de cpf em massa", tags = Constant.DEFAULT_TAG)
	@PostMapping(path = "/consultar_cpf_em_massa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody CpfMassaReqMdl params) {

		logController.gravaLogCpfEmMassa(params);
    	
		List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params.getListaCpfs());

		return new ResponseEntity<>(listaCpfsEncontrados, HttpStatus.ACCEPTED);
		
    }
	
	
	
}
