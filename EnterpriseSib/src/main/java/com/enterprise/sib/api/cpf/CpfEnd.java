package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.LogCtrl;
import com.enterprise.sib.api.login.LoginCtrl;
import com.enterprise.sib.api.login.LoginReqMdl;
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
    private LoginCtrl loginController;

    @Autowired
    private LogCtrl logController;

    @Autowired
    private CpfCtrl cpfController;
    

    @ApiOperation(value = "Consulta de cpf", tags = Constant.DEFAULT_TAG)
    @PostMapping(path = "/consultar_cpf", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> obtemCpf(@RequestBody CpfReqMdl params) {

    	
//    	Login fixo temporário
        LoginReqMdl loginRequest = new LoginReqMdl();
        loginRequest.setUsuario("ENTERPRISE");
        loginRequest.setSenha("ENTERPRISE2019@)!(");

        //LoginRespMdl loginResposta = loginController.efetuarLogin(loginRequest);
        
        boolean indicadorSucessoBusca = false;
        CpfDadosJPAMdl cpfDados = new CpfDadosJPAMdl();
        
        String resultadoBuscaBanco = cpfController.consultaCpfBaseAntes(params.getCpf()); 
                
        if (resultadoBuscaBanco.equalsIgnoreCase("false")) {
			
        	// Colocar aqui sua busca no serviço da newdbase
        	// e tbm colocar um metodo para gravar os dados do CPF no 
        	// nosso banco na tabela CPFS, pois se entrou nesse IF, é pq nao temos o CPF em nossa base ainda
        	
        	indicadorSucessoBusca = false;		// Se der merda lá no newdbase , dependendo do q rolar no newdbase, setar para TRUE se der certo ou FALSE se der merda
        	cpfDados.setBody("Por enquanto, não encontramos o CPF : " + params.getCpf() + ", esperando Italo resolver a conexao com a newdbase");  // Setar esse campo com o retorno obtido da API dos caras
        	
		} else {
	
			 cpfDados = cpfController.converteJsonStringParaClasseCpfDados(resultadoBuscaBanco);
			 indicadorSucessoBusca = true;
			
		}
        
        //Gravar log no banco do que rolou no endpoint
        logController.gravaLog(params,cpfDados.getBody(),indicadorSucessoBusca); // Esse segundo parametro é refente ao retorno obtido da pesquisa de cpf, seja no nosso banco ou no serviço newdbase

        if (cpfDados.getBody().contains("não encontramos")) {
        	 return new ResponseEntity<String>("{\"CPF\" : \""+params.getCpf()+"\", \"Situacao\" : \"Não encontrado\"}", HttpStatus.OK);
        	 
		} else {
       
			return new ResponseEntity<String>(cpfDados.getBody(), HttpStatus.OK);
			//return new ResponseEntity<>(cpfController.consultarCpf(params), HttpStatus.OK);
		}

    }

    @ApiOperation(value = "Consulta de cpf em massa", tags = Constant.DEFAULT_TAG)
    @PostMapping(path = "/consultar_cpf_em_massa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody CpfMassaReqMdl params) {

        //logController.gravaLogCpfEmMassa(params);

        List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params.getListaCpfs());

        return new ResponseEntity<>(listaCpfsEncontrados, HttpStatus.ACCEPTED);

    }
}
