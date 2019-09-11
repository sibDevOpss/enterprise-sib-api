package com.enterprise.sib.api.log;

import com.enterprise.sib.utils.Constant;
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
@RequestMapping(
        path = Constant.URL_MAIN + Constant.URL_LOGS,
        produces = MediaType.APPLICATION_JSON_VALUE)
class LogEnd {

    @Autowired
    private LogCtrl logController;

    @ApiOperation(value = "Obter Logs por CNPJ da Operadora", tags = Constant.TAG_LOGS)
    @PostMapping(path = "/consultar_por_cnpj_operadora")
    public ResponseEntity<List<LogMdlBaseDados>> consultarCnpjOperadora(String operadoraCNPJ) {
        return new ResponseEntity<>(logController.obtemLogsPorOperadoraCnpj(operadoraCNPJ), HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Logs por Código da Operadora", tags = Constant.TAG_LOGS)
    @PostMapping(path = "/consultar_por_id_operadora")
    public ResponseEntity<List<LogMdlBaseDados>> consultarCodigoOperadora(@RequestBody int operadoraId) {
        return new ResponseEntity<>(logController.obtemLogsPorCodigoOperadora(operadoraId), HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Logs por ID de Usuário", tags = Constant.TAG_LOGS)
    @PostMapping(path = "/consultar_por_id_usuario")
    public ResponseEntity<List<LogMdlBaseDados>> consultarIdUsuario(String usuarioId) {
        return new ResponseEntity<>(logController.obtemLogsUsuarioId(usuarioId), HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Logs por Operadora", tags = Constant.TAG_LOGS)
    @PostMapping(path = "/consultar_por_nome_operadora")
    public ResponseEntity<List<LogMdlBaseDados>> consultarNomeOperadora(@RequestBody String nomeOperadora) {
        return new ResponseEntity<>(logController.obtemLogsDeUmaOperadora(nomeOperadora), HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Logs por Usuario", tags = Constant.TAG_LOGS)
    @PostMapping(path = "/consultar_por_nome_usuario")
    public ResponseEntity<List<LogMdlBaseDados>> consultarNomeUsuario(@RequestBody String nomeUsuario) {
        return new ResponseEntity<>(logController.obtemLogsPorNomeUsuario(nomeUsuario), HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Quantidade Total de Logs", tags = Constant.TAG_LOGS)
    @GetMapping(path = "/consultar_quantidade_total_logs")
    public ResponseEntity<String> consultarQuantidadeTotalLogs() {
        return new ResponseEntity<>(
                "{\"Quantidade\" : \"" + logController.obtemQuantidadeRegistrosLogNoBanco() + "\"}",
                HttpStatus.OK);
    }

    @ApiOperation(value = "Obter Todos os Logs da Base de Dados", tags = Constant.TAG_LOGS)
    @GetMapping(path = "/obter_todos")
    public ResponseEntity<List<LogMdlBaseDados>> obterTodos() {
        return new ResponseEntity<>(logController.obtemTodosLogBase(), HttpStatus.OK);
    }

}