package com.enterprise.sib.api.log;

import com.enterprise.sib.api.cpf.CpfMdlReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LogCtrl {

    @Autowired
    private LogDAO logDAO;

    public void salvarLogBaseDados(CpfMdlReq params, String retorno, boolean indicadorSucessoBusca, HttpServletRequest request) {

        DataHoraMdl dataHoraLocal = defineDataHoraLocal();
        LogMdlCpf log = new LogMdlCpf(params, dataHoraLocal);
        LogMdlBaseDados dados = new LogMdlBaseDados(log, retorno, indicadorSucessoBusca, request);

        logDAO.save(dados);
    }

    private DataHoraMdl defineDataHoraLocal() {

        LocalDateTime dataHoraConsulta = LocalDateTime.now();
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String horaDataLocal = dataHoraConsulta.format(formatoDataHora);
        List<String> dataHora = Arrays.asList(horaDataLocal.split(" "));

        DataHoraMdl dataHoraMdl = new DataHoraMdl();
        dataHoraMdl.setData(dataHora.get(0));
        dataHoraMdl.setHora(dataHora.get(1));

        return dataHoraMdl;
    }

    /* ==============================================================
                        CONSULTAS NA BASE DE DADOS
    ==============================================================*/

    List<LogMdlBaseDados> obtemTodosLogBase() {

        List<LogMdlBaseDados> listaLogsBase = new ArrayList<>();

        for (LogMdlBaseDados log : logDAO.findAll()) {
            listaLogsBase.add(log);
        }

        return listaLogsBase;
    }

    List<LogMdlBaseDados> obtemLogsDeUmaOperadora(String nomeOperadora) {
        return new ArrayList<>(logDAO.findLogsByNomeOperadora(nomeOperadora));
    }

    List<LogMdlBaseDados> obtemLogsPorNomeUsuario(String nomeUsuario) {
        return new ArrayList<>(logDAO.findLogsByNomeUsuario(nomeUsuario));
    }

    List<LogMdlBaseDados> obtemLogsPorCodigoOperadora(int codigoOperadora) {
        return new ArrayList<>(logDAO.findLogsByOperadoraId(codigoOperadora));
    }

    List<LogMdlBaseDados> obtemLogsPorOperadoraCnpj(String operadoraCNPJ) {
        return new ArrayList<>(logDAO.findLogsByOperadoraCnpj(operadoraCNPJ));
    }

    List<LogMdlBaseDados> obtemLogsUsuarioId(String usuarioId) {
        return new ArrayList<>(logDAO.findLogsByUsuarioId(usuarioId));
    }

    int obtemQuantidadeRegistrosLogNoBanco() {
        return obtemTodosLogBase().size();
    }

}
