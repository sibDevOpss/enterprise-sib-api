package com.enterprise.sib.api.cpf;

public class CpfReqMdl {

    private String usuarioId;
    private String usuarioNome;
    private String operadoraId;
    private String operadoraNome;
    private String operadoraCnpj;
    private String cpf;
    private String dataNascimento;
    
    
	public CpfReqMdl() {
		
	}


	public String getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}


	public String getUsuarioNome() {
		return usuarioNome;
	}


	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}


	public String getOperadoraId() {
		return operadoraId;
	}


	public void setOperadoraId(String operadoraId) {
		this.operadoraId = operadoraId;
	}


	public String getOperadoraNome() {
		return operadoraNome;
	}


	public void setOperadoraNome(String operadoraNome) {
		this.operadoraNome = operadoraNome;
	}


	public String getOperadoraCnpj() {
		return operadoraCnpj;
	}


	public void setOperadoraCnpj(String operadoraCnpj) {
		this.operadoraCnpj = operadoraCnpj;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

    
    
	
}
