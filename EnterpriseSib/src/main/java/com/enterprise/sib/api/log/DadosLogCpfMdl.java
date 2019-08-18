package com.enterprise.sib.api.log;

import com.enterprise.sib.api.cpf.CpfReqMdl;

public class DadosLogCpfMdl {

    private String jsonEntradaEndpoint;
	private CpfReqMdl paramsConsulta = new CpfReqMdl();
	private DataHoraMdl dataHora = new DataHoraMdl();
	
	public DadosLogCpfMdl() {
		
	}


	public String getJsonEntradaEndpoint() {
		return jsonEntradaEndpoint;
	}
	public void setJsonEntradaEndpoint(String jsonEntradaEndpoint) {
		this.jsonEntradaEndpoint = jsonEntradaEndpoint;
	}
	public CpfReqMdl getParamsConsulta() {
		return paramsConsulta;
	}
	public void setParamsConsulta(CpfReqMdl paramsConsulta) {
		this.paramsConsulta = paramsConsulta;
	}
	public DataHoraMdl getDataHora() {
		return dataHora;
	}
	public void setDataHora(DataHoraMdl dataHora) {
		this.dataHora = dataHora;
	}
		

}
