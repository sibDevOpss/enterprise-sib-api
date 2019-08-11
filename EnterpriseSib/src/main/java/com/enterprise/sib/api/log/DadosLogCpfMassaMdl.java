package com.enterprise.sib.api.log;

import com.enterprise.sib.api.cpf.CpfMassaReqMdl;

public class DadosLogCpfMassaMdl {

	private CpfMassaReqMdl paramsConsultaMassa = new CpfMassaReqMdl();
	private DataHoraMdl dataHora = new DataHoraMdl();


	public CpfMassaReqMdl getParamsConsultaMassa() {
		return paramsConsultaMassa;
	}

	public void setParamsConsultaMassa(CpfMassaReqMdl paramsConsultaMassa) {
		this.paramsConsultaMassa = paramsConsultaMassa;
	}
	public DataHoraMdl getDataHora() {
		return dataHora;
	}
	public void setDataHora(DataHoraMdl dataHora) {
		this.dataHora = dataHora;
	}
	
	
	

}
