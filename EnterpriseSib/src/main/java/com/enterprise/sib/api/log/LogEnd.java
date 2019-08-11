package com.enterprise.sib.api.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.sib.utilitarios.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Service
@RestController
@RequestMapping(Constant.URL_MAIN_PATH + Constant.URL_LOGS_PATH)
public class LogEnd {
	
	@Autowired
	private LogCtrl logController;
	
	
	@ApiOperation(value = "Obter todos os logs da base", tags = Constant.LOGS_TAG)
	@GetMapping(path = "/obter_todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogCpfJPAMdl>> obtemListaDadosLogBase () {
        
		List<DadosLogCpfJPAMdl> listaLogsBase = logController.obtemTodosLogBase();
   
        return new ResponseEntity<List<DadosLogCpfJPAMdl>>(listaLogsBase,HttpStatus.ACCEPTED);
    }
	
	@ApiOperation(value = "Obter Logs de uma operadora", tags = Constant.LOGS_TAG)
	@PostMapping(path = "/consulta_por_nome_operadora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogCpfJPAMdl>> obtemLogsNomeOperadora (@RequestBody String nomeOperadora) {
        
		List<DadosLogCpfJPAMdl> listaLogsEncontrados = logController.obtemLogsDeUmaOperadora(nomeOperadora);
		
        return new ResponseEntity<List<DadosLogCpfJPAMdl>>(listaLogsEncontrados,HttpStatus.ACCEPTED);
    }
	
	
	@ApiOperation(value = "Obter Logs de um usuario", tags = Constant.LOGS_TAG)
	@PostMapping(path = "/consulta_por_nome_usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogCpfJPAMdl>> obtemLogsNomeUsuario (@RequestBody String nomeUsuario) {
        
		List<DadosLogCpfJPAMdl> listaLogsEncontrados = logController.obtemLogsPorNomeUsuario(nomeUsuario);
		
        return new ResponseEntity<List<DadosLogCpfJPAMdl>>(listaLogsEncontrados,HttpStatus.ACCEPTED);
    }
	
	
	@ApiOperation(value = "Obter Logs de uma operadora por seu código", tags = Constant.LOGS_TAG)
	@PostMapping(path = "/consulta_por_codigo_operadora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogCpfJPAMdl>> obtemLogsCodigoOperadora (@RequestBody int codigoOperadora) {
        
		List<DadosLogCpfJPAMdl> listaLogsEncontrados = logController.obtemLogsPorCodigoOperadora(codigoOperadora);
		
        return new ResponseEntity<List<DadosLogCpfJPAMdl>>(listaLogsEncontrados,HttpStatus.ACCEPTED);
    }
	
	
	@ApiOperation(value = "Obter quantidade total de logs na base", tags = Constant.LOGS_TAG)
	@GetMapping(path = "/consulta_quantidade_total", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtemQuantidadeTotalLogsNoBanco () {
        
        return new ResponseEntity<String>("{\"Quantidade\" : \""+logController.obtemQuantidadeRegistrosLogNoBanco()+"\"}",HttpStatus.ACCEPTED);
    }
	

}
