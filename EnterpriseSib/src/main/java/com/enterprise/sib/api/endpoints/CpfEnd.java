package com.enterprise.sib.api.endpoints;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.sib.api.DAO.CpfDAO;
import com.enterprise.sib.api.controllers.CpfCtrl;
import com.enterprise.sib.api.models.CpfRespMdl;
import com.enterprise.sib.api.models.DadosLogCpfJPAMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMassaMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api()
@Service
@RestController
@RequestMapping("/enterprise")
public class CpfEnd {


	@Autowired
	private CpfDAO cpfDAO;
	
	
    @ApiOperation(value = "Consulta de cpf", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CpfRespMdl> obtemCpf(@RequestBody ParamsConsultaCpfMdl params) {

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

    @ApiOperation(value = "Consulta de cpf em massa", tags = "Enterprise SIB Endpoints")
    @PostMapping(path = "/consultar_cpf_em_massa", produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody ParamsConsultaCpfMassaMdl params) {

		CpfCtrl cpfController = new CpfCtrl();
		cpfController.gravaLogCpfEmMassa(params);
    	
		List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params.getListaCpfs());
		
		return new ResponseEntity<List<CpfRespMdl>> (listaCpfsEncontrados,HttpStatus.ACCEPTED);
		

    }
}
