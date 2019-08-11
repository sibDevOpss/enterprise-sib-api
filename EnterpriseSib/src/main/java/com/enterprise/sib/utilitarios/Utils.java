package com.enterprise.sib.utilitarios;

import com.enterprise.sib.api.cpf.CpfMassaReqMdl;
import com.enterprise.sib.api.cpf.CpfReqMdl;
import com.enterprise.sib.api.log.DadosLogCpfMdl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

	public void gravarArquivoLog (String basePath, String nomeArq, String infoLog) {

		gravar(basePath, "Logs.txt", infoLog);
		gravar(basePath, nomeArq, infoLog);

	}

	public void gravar (String basePath, String nomeArq, String infoLog) {
		
		try {
			PrintWriter output = new PrintWriter(new FileWriter(basePath+nomeArq,true));
			output.printf("%s\r\n", infoLog);
			output.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public LocalDateTime obtemDataHoraAtual () {
		return LocalDateTime.now();
	}

	public DateTimeFormatter obtemTipoDataHoraFormatado (String mascara) {
		return DateTimeFormatter.ofPattern(mascara);
	}

	public DadosLogCpfMdl defineDataHoraLocal (LocalDateTime dataHoraConsulta, DateTimeFormatter formataDataHora) {

		DadosLogCpfMdl dadosLog = new DadosLogCpfMdl();

		String horaDataLocal = dataHoraConsulta.format(formataDataHora);

		String[] campos = horaDataLocal.split(" ");

		dadosLog.getDataHora().setData(campos[0]);
		dadosLog.getDataHora().setHora(campos[1]);

		return dadosLog;
	}

	public DadosLogCpfMdl defineDadosLogCpf(DadosLogCpfMdl dadosLog, CpfReqMdl params) {

		dadosLog.getParamsConsulta().setCpf(params.getCpf());
		dadosLog.getParamsConsulta().setNomeOperadora(params.getNomeOperadora());
		dadosLog.getParamsConsulta().setNomeUsuario(params.getNomeUsuario());
		dadosLog.getParamsConsulta().setCodigoOperadora(params.getCodigoOperadora());

		return dadosLog;

	}

	public DadosLogCpfMdl defineDadosLogCpfMassa(DadosLogCpfMdl dadosLog, CpfMassaReqMdl params, String cpfsConcatenados) {

		dadosLog.getParamsConsulta().setNomeOperadora(params.getNomeOperadora());
		dadosLog.getParamsConsulta().setCodigoOperadora(params.getCodigoOperadora());
		dadosLog.getParamsConsulta().setNomeUsuario(params.getNomeUsuario());
		dadosLog.getParamsConsulta().setCpf(cpfsConcatenados);

		return dadosLog;

	}

	public String obtemNomeArqSaidaLog (DadosLogCpfMdl dadosLog, String extensaoArqLog) {
		return dadosLog.getParamsConsulta().getNomeOperadora() + extensaoArqLog;

	}

	public String criaDadosLog (DadosLogCpfMdl dadosLog) {

		return "Usuario : " + dadosLog.getParamsConsulta().getNomeUsuario() + " | Operadora : " + dadosLog.getParamsConsulta().getNomeOperadora() + " | Codigo Operadora : " + dadosLog.getParamsConsulta().getCodigoOperadora() + " | CPFs Buscados : " + dadosLog.getParamsConsulta().getCpf() + " | Data : " + dadosLog.getDataHora().getData() + " | Horario : " + dadosLog.getDataHora().getHora();

	}

}
