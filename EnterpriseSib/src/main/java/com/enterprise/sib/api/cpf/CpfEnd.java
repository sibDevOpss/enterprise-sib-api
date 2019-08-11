package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.DadosLogCpfJPAMdl;
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

@Api()
@Service
@RestController
@RequestMapping(Constant.URL_MAIN_PATH)
public class CpfEnd {


	@Autowired
	private CpfDAO cpfDAO;


	@ApiOperation(value = "Consulta de cpf", tags = Constant.DEFAULT_TAG)
	@PostMapping(path = "/consultar_cpf", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CpfRespMdl> obtemCpf(@RequestBody CpfReqMdl params) {

        CpfCtrl cpfController = new CpfCtrl();
        
        cpfController.gravaLog(params);
        
        if (cpfDAO != null) {	// Apenas um teste, funcionando perfeitamente
        	
        	DadosLogCpfJPAMdl banco = new DadosLogCpfJPAMdl();
        	banco.setCodigoOperadora(2);
        	banco.setCpf("123123123");
        	banco.setNomeOperadora("HAKAI");
        	banco.setNomeUsuario("Bills");
        	
        	cpfDAO.save(banco);
        	
        	
		}else {
			
		}
        

        return null;

    }

	@ApiOperation(value = "Consulta de cpf em massa", tags = Constant.DEFAULT_TAG)
	@PostMapping(path = "/consultar_cpf_em_massa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody CpfMassaReqMdl params) {

		CpfCtrl cpfController = new CpfCtrl();
		cpfController.gravaLogCpfEmMassa(params);
    	
		List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params.getListaCpfs());

		return new ResponseEntity<>(listaCpfsEncontrados, HttpStatus.ACCEPTED);
		

    }
}
