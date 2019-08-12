package com.enterprise.sib.api.cpf;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CpfCtrl {

//	@Autowired
//	private CpfDAO cpfDAO;


	public List<CpfRespMdl> obtemConsultaVariosCpfs (List<String> listaCpfConsultaParams) {

		CpfRespMdl[] listaCpfMock = obtemListaCpfMock();
        ArrayList<CpfRespMdl> listaAchados = new ArrayList<>();

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


	private CpfRespMdl[] obtemListaCpfMock() {

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

	public CpfRespMdl criarCpfTeste () {
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