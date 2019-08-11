package com.enterprise.sib.api.models;

public class DadosLogCpfMdl {


	ParamsConsultaCpfMdl paramsConsulta = new ParamsConsultaCpfMdl();
	DataHoraMdl dataHora = new DataHoraMdl();
	
	public DadosLogCpfMdl() {
		
	}
	

	public ParamsConsultaCpfMdl getParamsConsulta() {
		return paramsConsulta;
	}
	public void setParamsConsulta(ParamsConsultaCpfMdl paramsConsulta) {
		this.paramsConsulta = paramsConsulta;
	}
	public DataHoraMdl getDataHora() {
		return dataHora;
	}
	public void setDataHora(DataHoraMdl dataHora) {
		this.dataHora = dataHora;
	}
		

}
