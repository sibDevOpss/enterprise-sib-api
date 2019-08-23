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

    String consultarCpfBaseDados(String cpf) {

        CpfDadosJPAMdl dadosCpf = cpfDAO.findCpf(cpf);

        if (dadosCpf == null) {
            return "false";
        } else {
            Gson g = new Gson();
            return g.toJson(dadosCpf);
        }

    }

    CpfRespMdl consultarCpfApi(CpfReqMdl request) {

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

    private String obterJsonApi(String responseUrl) {

        JSONObject json = new JSONObject(responseUrl);
        JSONObject response = json.getJSONObject("Response");
        JSONArray arrayOutput = response.getJSONArray("Output");

        JSONObject output = new JSONObject();
        for (int i = 0; i < arrayOutput.length(); i++) {
            output = arrayOutput.getJSONObject(i).getJSONObject("Output");
        }

        return output.toString();
    }

    CpfDadosJPAMdl salvarBaseDados(CpfRespMdl cpfRespMdl) {

        CpfDadosJPAMdl cpfBaseDados = new CpfDadosJPAMdl();
        Gson gson = new Gson();

        cpfBaseDados.setCpf(cpfRespMdl.getCPF());
        cpfBaseDados.setBody(gson.toJson(cpfRespMdl));

        cpfDAO.save(cpfBaseDados);

        return cpfBaseDados;
    }

}