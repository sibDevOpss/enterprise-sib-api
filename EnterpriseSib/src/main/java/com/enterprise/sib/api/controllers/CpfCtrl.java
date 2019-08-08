package com.enterprise.sib.api.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.enterprise.sib.api.models.CpfRespMdl;
import com.enterprise.sib.api.models.DadosLogMdl;
import com.enterprise.sib.api.models.ParamsConsultaCpfMdl;
import com.enterprise.sib.utilitarios.Utils;
import com.google.gson.Gson;

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
	
	public List<CpfRespMdl> obtemConsultaVariosCpfs(List<String> listaCpfConsultaParams) {
		
		CpfRespMdl[] listaCpfMock = obtemListaCpfMock();
		ArrayList<CpfRespMdl> listaAchados = new ArrayList<CpfRespMdl>();
		
		for (String cpfConsulta : listaCpfConsultaParams) {
			
			for (CpfRespMdl cpfMock : listaCpfMock) {						// Quando for pra valer
																			// Apagar tudo da linha 52 a 57 e 
				if (cpfConsulta.equalsIgnoreCase( cpfMock.getCpf() )) {		// Substituir pela chamada da api da NewdBase
					listaAchados.add(cpfMock);								// Passando como parametro a variável "cpfConsulta"
				}															// Em cada chamada
			}																// E salvar a resposta INTEIRA de cada CPF no
		}																	// Array "listaAchados"
		
		return listaAchados;
	}
	

	public CpfRespMdl[] obtemListaCpfMock () {

		BufferedReader reader;
		CpfRespMdl[] listaCpfMock = {};
		try {

			reader = new BufferedReader(new FileReader("C:\\Users\\Godzilla\\Desktop\\Freelancer\\enterprise-sib-api\\EnterpriseSib\\CPFs Mock.json"));
			Gson gs = new Gson();
			listaCpfMock = gs.fromJson(reader, CpfRespMdl[].class);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCpfMock;
	}

	public CpfRespMdl criarCpfTeste() {
		CpfRespMdl pessoa = new CpfRespMdl();
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