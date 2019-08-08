package com.enterprise.sib.api.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.enterprise.sib.api.models.DadosLogMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;
import com.enterprise.sib.utilitarios.Utils;

public class CpfCtrl {

	public void gravaLog (ParamsConsultaCpfMdl params) {

		Utils utilitarios = new Utils();
		
		String mascaraDataHora = "dd-MM-yyyy HH:mm:ss";
		
		String pathSaidaDadosLog = "C:\\Users\\Godzilla\\Desktop\\saidas\\";
		
		String extensaoArqLog = ".txt";
		
		LocalDateTime dataHoraConsulta = utilitarios.obtemDataHoraAtual();
		
		DateTimeFormatter formataDataHora = utilitarios.obtemTipoDataHoraFormatado(mascaraDataHora);

		DadosLogMdl dadosLog = utilitarios.defineDataHoraLocal(dataHoraConsulta, formataDataHora);

		dadosLog = utilitarios.defineNomeOperadoraCpfEUsuarioOperadora(dadosLog, params);

		String infoLog = utilitarios.criaDadosLog(dadosLog);

		String nomeArqLog = utilitarios.obtemNomeArqSaidaLog(dadosLog,extensaoArqLog);
		
		utilitarios.gravarArquivoLog(pathSaidaDadosLog ,nomeArqLog, infoLog);
		

	}
	
	
	


}
