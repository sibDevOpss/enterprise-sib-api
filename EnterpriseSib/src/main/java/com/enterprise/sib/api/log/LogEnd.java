package com.enterprise.sib.api.log;

import com.enterprise.sib.utilitarios.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@Service
@RestController
@RequestMapping(Constant.URL_MAIN + Constant.URL_LOGS)
public class LogEnd {
	
	@Autowired
	private LogCtrl logController;


	@ApiOperation(value = "Obter todos os logs da base", tags = Constant.TAG_LOGS)
	@GetMapping(path = "/obter_todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemListaDadosLogBase () {
        
		List<DadosLogJPAMdl> listaLogsBase = logController.obtemTodosLogBase();

		return new ResponseEntity<>(listaLogsBase, HttpStatus.ACCEPTED);
    }

	@ApiOperation(value = "Obter Logs de uma operadora", tags = Constant.TAG_LOGS)
	@PostMapping(path = "/consulta_por_nome_operadora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemLogsNomeOperadora (@RequestBody String nomeOperadora) {
        
		List<DadosLogJPAMdl> listaLogsEncontrados = logController.obtemLogsDeUmaOperadora(nomeOperadora);

		return new ResponseEntity<>(listaLogsEncontrados, HttpStatus.ACCEPTED);
    }


	@ApiOperation(value = "Obter Logs de um usuario", tags = Constant.TAG_LOGS)
	@PostMapping(path = "/consulta_por_nome_usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemLogsNomeUsuario (@RequestBody String nomeUsuario) {
        
		List<DadosLogJPAMdl> listaLogsEncontrados = logController.obtemLogsPorNomeUsuario(nomeUsuario);

		return new ResponseEntity<>(listaLogsEncontrados, HttpStatus.ACCEPTED);
    }


	@ApiOperation(value = "Obter Logs de uma operadora por seu código", tags = Constant.TAG_LOGS)
	@PostMapping(path = "/consulta_por_codigo_operadora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemLogsCodigoOperadora (@RequestBody int codigoOperadora) {
        
		List<DadosLogJPAMdl> listaLogsEncontrados = logController.obtemLogsPorCodigoOperadora(codigoOperadora);

		return new ResponseEntity<>(listaLogsEncontrados, HttpStatus.ACCEPTED);
    }


	@ApiOperation(value = "Obter Logs de uma operadora por seu CNPJ", tags = Constant.TAG_LOGS)
	@PostMapping(path = "/consulta_por_operadora_cnpj", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemLogsOperadoraCnpj (String operadoraCNPJ) {
		
		List<DadosLogJPAMdl> listaLogsEncontrados = logController.obtemLogsPorOperadoraCnpj(operadoraCNPJ);
		
		return new ResponseEntity<>(listaLogsEncontrados, HttpStatus.ACCEPTED);
    }


	@ApiOperation(value = "Obter Logs de um usuario pelo seu ID", tags = Constant.TAG_LOGS)
	@PostMapping(path = "/consulta_por_usuario_id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DadosLogJPAMdl>> obtemLogsUsuarioId (String usuarioId) {
		
		List<DadosLogJPAMdl> listaLogsEncontrados = logController.obtemLogsUsuarioId(usuarioId);
		
		return new ResponseEntity<>(listaLogsEncontrados, HttpStatus.ACCEPTED);
    }


	@ApiOperation(value = "Obter quantidade total de logs na base", tags = Constant.TAG_LOGS)
	@GetMapping(path = "/consulta_quantidade_total", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtemQuantidadeTotalLogsNoBanco () {

		return new ResponseEntity<>("{\"Quantidade\" : \"" + logController.obtemQuantidadeRegistrosLogNoBanco() + "\"}", HttpStatus.ACCEPTED);
    }
	
	

}
