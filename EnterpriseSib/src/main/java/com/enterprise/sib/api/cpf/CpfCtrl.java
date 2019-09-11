package com.enterprise.sib.api.cpf;

import com.enterprise.sib.api.log.LogCtrl;
import com.enterprise.sib.utils.Connection;
import com.enterprise.sib.utils.JsonConverter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
class CpfCtrl {

    @Autowired
    private CpfCtrl cpfController;

    @Autowired
    private CpfDAO cpfDAO;

    @Autowired
    private LogCtrl logController;

    private CpfMdlResp consultarCpfApi(CpfMdlReq request) {

        String dataNasc = request.getDataNascimento() != null ? "&dt_Nascimento=" + request.getDataNascimento() : "";

        String url = "https://dataintelligence.newdbase.com.br:443/api/5c45a388?" +
                "nr_CPF=" + request.getCpf() + dataNasc +
                "&vl_Timeout=30";

        return getResponse(url);
    }

    private String consultarCpfBaseDados(String cpf) {

        CpfMdlBaseDados dadosCpf = cpfDAO.findCpf(cpf);

        if (dadosCpf == null) {
            return "false";
        } else {
            JsonConverter<CpfMdlBaseDados> jsonConverter = new JsonConverter<>();
            return jsonConverter.toJson(dadosCpf);
        }

    }

    String efetuarConsultaCpf(CpfMdlReq params, HttpServletRequest request) {

        CpfMdlBaseDados cpfDados;
        boolean indicadorSucessoBusca = false;

        String resultadoBuscaBanco = cpfController.consultarCpfBaseDados(params.getCpf());

        if (resultadoBuscaBanco.equalsIgnoreCase("false")) {
            // Consulta CPF Api
            CpfMdlResp cpfMdlResp = cpfController.consultarCpfApi(params);
            cpfDados = cpfController.salvarBaseDados(cpfMdlResp);
        } else {
            // Consulta CPF Base de Dados
            JsonConverter<CpfMdlBaseDados> jsonConverter = new JsonConverter<>();
            cpfDados = jsonConverter.fromJson(resultadoBuscaBanco, CpfMdlBaseDados.class);
            indicadorSucessoBusca = true;
        }

        logController.salvarLogBaseDados(params, cpfDados.getBody(), indicadorSucessoBusca, request);
        return cpfDados.getBody();
    }

    private CpfMdlResp getResponse(String url) {

        JsonConverter<CpfMdlResp> jsonConverter = new JsonConverter<>();

        String json = Connection.getResponse(url);
        return jsonConverter.fromJson(obterJsonApi(json), CpfMdlResp.class);
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

    private CpfMdlBaseDados salvarBaseDados(CpfMdlResp cpfMdlResp) {

        JsonConverter<CpfMdlBaseDados> jsonConverter = new JsonConverter<>();

        CpfMdlBaseDados cpfBaseDados = new CpfMdlBaseDados();
        cpfBaseDados.setCpf(cpfMdlResp.getCPF());
        cpfBaseDados.setBody(jsonConverter.toJson(cpfMdlResp));

        cpfDAO.save(cpfBaseDados);
        return cpfBaseDados;
    }
}