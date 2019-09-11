package com.enterprise.sib.api.log;

import com.enterprise.sib.api.cpf.CpfMdlReq;

class LogMdlCpf {

    private CpfMdlReq paramsConsulta = new CpfMdlReq();
    private DataHoraMdl dataHora = new DataHoraMdl();

    public LogMdlCpf(CpfMdlReq params, DataHoraMdl dataHora) {

        this.paramsConsulta.setCpf(params.getCpf());
        this.paramsConsulta.setDataNascimento(params.getDataNascimento());
        this.paramsConsulta.setOperadoraCnpj(params.getOperadoraCnpj());
        this.paramsConsulta.setOperadoraId(params.getOperadoraId());
        this.paramsConsulta.setOperadoraNome(params.getOperadoraNome());
        this.paramsConsulta.setUsuarioId(params.getUsuarioId());
        this.paramsConsulta.setUsuarioNome(params.getUsuarioNome());

        this.dataHora.setData(dataHora.getData());
        this.dataHora.setHora(dataHora.getHora());
    }

    public CpfMdlReq getParamsConsulta() {
        return paramsConsulta;
    }

    public void setParamsConsulta(CpfMdlReq paramsConsulta) {
        this.paramsConsulta = paramsConsulta;
    }

    public DataHoraMdl getDataHora() {
        return dataHora;
    }

    public void setDataHora(DataHoraMdl dataHora) {
        this.dataHora = dataHora;
    }

}