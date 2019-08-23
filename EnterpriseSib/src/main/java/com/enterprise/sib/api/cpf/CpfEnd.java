package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.LogCtrl;
import com.enterprise.sib.api.login.LoginCtrl;
import com.enterprise.sib.utilitarios.Connection;
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
@RequestMapping(
        path = Constant.URL_MAIN,
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class CpfEnd {

    @Autowired
    private LoginCtrl loginController;

    @Autowired
    private LogCtrl logController;

    @Autowired
    private CpfCtrl cpfController;

    @ApiOperation(value = "Consulta de cpf", tags = Constant.TAG_DEFAULT)
    @PostMapping(path = "/consultar_cpf")
    public ResponseEntity<String> obtemCpf(@RequestBody CpfReqMdl params) {

        CpfDadosJPAMdl cpfDados;
        boolean indicadorSucessoBusca = false;

        String resultadoBuscaBanco = cpfController.consultarCpfBaseDados(params.getCpf());

        if (resultadoBuscaBanco.equalsIgnoreCase("false")) {
            // Consulta CPF Api
            CpfRespMdl cpfRespMdl = cpfController.consultarCpfApi(params);
            cpfDados = cpfController.salvarBaseDados(cpfRespMdl);
        } else {
            // Consulta CPF Base de Dados
            Connection<CpfDadosJPAMdl> connection = new Connection<>();
            cpfDados = connection.setResponse(resultadoBuscaBanco, CpfDadosJPAMdl.class);
            indicadorSucessoBusca = true;
        }

        logController.gravaLog(params, cpfDados.getBody(), indicadorSucessoBusca);

        return new ResponseEntity<>(cpfDados.getBody(), HttpStatus.OK);
    }

    @ApiOperation(value = "Consulta de cpf em massa", tags = Constant.TAG_DEFAULT)
    @PostMapping(path = "/consultar_cpf_em_massa")
    public ResponseEntity<List<CpfRespMdl>> obtemCpfEmLotes(@RequestBody CpfMassaReqMdl params) {

        //logController.gravaLogCpfEmMassa(params);
        List<CpfRespMdl> listaCpfsEncontrados = cpfController.obtemConsultaVariosCpfs(params.getListaCpfs());
        //logController.gravaLogCpfEmMassa(params);

        return new ResponseEntity<>(listaCpfsEncontrados, HttpStatus.ACCEPTED);

    }
}
