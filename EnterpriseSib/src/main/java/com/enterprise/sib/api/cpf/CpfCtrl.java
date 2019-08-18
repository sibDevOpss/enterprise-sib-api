package com.enterprise.sib.api.cpf;

import com.enterprise.sib.utilitarios.Connection;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CpfCtrl {
	
	
	@Autowired
	private CpfDAO cpfDAO;
	
	
    private CpfRespMdl getResponse(String url) {

        Connection<CpfRespMdl> connection = new Connection<>();
        String response = connection.getResponse(url);
        return connection.setResponse(obterJsonApi(response), CpfRespMdl.class);
    }
    
    public CpfDadosJPAMdl converteJsonStringParaClasseCpfDados (String resultadoBuscaBanco) {
    	
    	Gson g = new Gson();
		
		CpfDadosJPAMdl cpfDados = g.fromJson(resultadoBuscaBanco, CpfDadosJPAMdl.class);
		
		return cpfDados;
    }
    
    
    public String consultaCpfBaseAntes (String cpf) {
    	
    	CpfDadosJPAMdl dadosCpf = cpfDAO.findCpf(cpf);
    	
    	if (dadosCpf == null) {
			return "false";
			
		} else {	
			
			Gson g = new Gson();
			String busca = g.toJson(dadosCpf);
			return busca;
			
		}
    	
    }

    public CpfRespMdl consultarCpf(CpfReqMdl request) {

        String dataNasc = request.getDataNascimento() != null ? "&dt_Nascimento=" + request.getDataNascimento() : "";

        String url = "https://dataintelligence.newdbase.com.br:443/api/5c45a388?" +
                "nr_CPF=" + request.getCpf() + dataNasc +
                "&vl_Timeout=30";

        return getResponse(url);
    }

    public List<CpfRespMdl> obtemConsultaVariosCpfs(List<String> listaCpfConsultaParams) {

        CpfRespMdl[] listaCpfMock = obtemListaCpfMock();
        ArrayList<CpfRespMdl> listaAchados = new ArrayList<>();

        for (String cpfConsulta : listaCpfConsultaParams) {

            for (CpfRespMdl cpfMock : listaCpfMock) {                        // Quando for pra valer
                // Apagar tudo da linha 52 a 57 e
                if (cpfConsulta.equalsIgnoreCase(cpfMock.getCPF())) {        // Substituir pela chamada da api da NewdBase
                    listaAchados.add(cpfMock);                                // Passando como parametro a variável "cpfConsulta"
                }                                                            // Em cada chamada
            }                                                                // E salvar a resposta INTEIRA de cada CPF no
        }                                                                    // Array "listaAchados"

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

    public CpfRespMdl criarCpfTeste() {
        CpfRespMdl pessoa = new CpfRespMdl();
        pessoa.setCPF("01895845130");
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

    public String obterJsonApi(String responseUrl) {

        JSONObject json = new JSONObject(responseUrl);
        JSONObject response = json.getJSONObject("Response");
        JSONArray arrayOutput = response.getJSONArray("Output");

        JSONObject output = new JSONObject();
        for (int i = 0; i < arrayOutput.length(); i++) {
            output = arrayOutput.getJSONObject(i).getJSONObject("Output");
        }

        return output.toString();
    }

}