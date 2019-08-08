package com.enterprise.sib.api.controllers;

import com.enterprise.sib.api.models.CpfMdlResp;
import com.enterprise.sib.api.models.DadosLogMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;
import com.enterprise.sib.utilitarios.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CpfCtrl {

    public void gravaLog(ParamsConsultaCpfMdl params) {

        Utils utilitarios = new Utils();

        String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";

        String pathSaidaDadosLog = "C:\\Users\\Godzilla\\Desktop\\saidas\\";

        String extensaoArqLog = ".txt";

        LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();

        DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);

        DadosLogMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);

        dadosLog = utilitarios.defineNomeOperadoraCpfEUsuarioOperadora(dadosLog, params);

        String infoLog = utilitarios.criaDadosLog(dadosLog);

        String nomeArqLog = utilitarios.obtemNomeArqSaidaLog(dadosLog, extensaoArqLog);

        utilitarios.gravarArquivoLog(pathSaidaDadosLog, nomeArqLog, infoLog);

    }

    public CpfMdlResp criarCpfTeste() {
        CpfMdlResp pessoa = new CpfMdlResp();
        pessoa.setCpf("01895845130");
        pessoa.setNome("RENATO SOUZA DE ALMEIDA");
        pessoa.setSituacao("REGULAR");
        pessoa.setDigito("00");
        pessoa.setDataNascimento("26/04/1988");
        pessoa.setAnoObito("0000");
        pessoa.setDataInscricao("31/03/2004");
        pessoa.setDataHora("07/08/2019 21:02:10");
        pessoa.setComprovante("8DF2.0582.757F.7C74");

        return pessoa;
    }

}