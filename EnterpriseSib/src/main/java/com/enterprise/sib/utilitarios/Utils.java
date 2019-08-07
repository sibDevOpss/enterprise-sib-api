package com.enterprise.sib.utilitarios;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.enterprise.sib.api.models.DadosLogMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;

public class Utils {

	public void gravarArquivoLog (String basePath, String nomeArq, String conteudo) {

		try{    
			FileWriter fw = new FileWriter(basePath+nomeArq);
			System.out.println(basePath+nomeArq);
			System.out.println(conteudo);
			fw.write(conteudo);    
			fw.close();    
			System.out.println("[Succeso] arquivo " + nomeArq + " criado...");    
		}catch(Exception e){
			System.out.println(e);
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

	public DadosLogMdl defineNomeOperadoraECpf (DadosLogMdl dadosLog, ParamsConsultaCpfMdl params) {

		dadosLog.getParamsConsulta().setCpf(params.getCpf());
		dadosLog.getParamsConsulta().setNomeOperadora(params.getNomeOperadora());

		return dadosLog;

	}

	public String obtemCaminhoCompletoDadosSaidaLog (DadosLogMdl dadosLog, String extensaoArqLog) {
		return dadosLog.getParamsConsulta().getNomeOperadora() + extensaoArqLog;

	}

	public String criaDadosLog (DadosLogMdl dadosLog) {

		return "Operadora : " + dadosLog.getParamsConsulta().getNomeOperadora() + " | " + "CPF Buscado : " + dadosLog.getParamsConsulta().getCpf() + " | " + "Data : " + dadosLog.getDataHora().getData() + " | " + "Horario : " + dadosLog.getDataHora().getHora();

	}

}
