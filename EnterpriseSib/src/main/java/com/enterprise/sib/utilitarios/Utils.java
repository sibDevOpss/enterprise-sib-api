package com.enterprise.sib.utilitarios;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.enterprise.sib.api.models.DadosLogMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;

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

	public DadosLogMdl defineDataHoraLocal (LocalDateTime dataHoraConsulta, DateTimeFormatter formataDataHora) {

		DadosLogMdl dadosLog = new DadosLogMdl();

		String horaDataLocal = dataHoraConsulta.format(formataDataHora); 

		String campos[] = horaDataLocal.split(" ");

		dadosLog.getDataHora().setData(campos[0]);
		dadosLog.getDataHora().setHora(campos[1]);

		return dadosLog;
	}

	public DadosLogMdl defineNomeOperadoraCpfEUsuarioOperadora (DadosLogMdl dadosLog, ParamsConsultaCpfMdl params) {

		dadosLog.getParamsConsulta().setCpf(params.getCpf());
		dadosLog.getParamsConsulta().setNomeOperadora(params.getNomeOperadora());
		dadosLog.getParamsConsulta().setNomeUsuario(params.getNomeUsuario());

		return dadosLog;

	}

	public String obtemNomeArqSaidaLog (DadosLogMdl dadosLog, String extensaoArqLog) {
		return dadosLog.getParamsConsulta().getNomeOperadora() + extensaoArqLog;

	}

	public String criaDadosLog (DadosLogMdl dadosLog) {

		return "Usuario : " + dadosLog.getParamsConsulta().getNomeUsuario() + " | Operadora : " + dadosLog.getParamsConsulta().getNomeOperadora() + " | CPF Buscado : " + dadosLog.getParamsConsulta().getCpf() + " | Data : " + dadosLog.getDataHora().getData() + " | Horario : " + dadosLog.getDataHora().getHora();

	}

}
