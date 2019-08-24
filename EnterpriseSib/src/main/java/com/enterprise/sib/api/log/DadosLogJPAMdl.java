package com.enterprise.sib.api.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "logsss")
public class DadosLogJPAMdl {
	
	private int id;
    private String usuarioId;
    private String usuarioNome;
    private String operadoraId;
    private String operadoraNome;
    private String operadoraCnpj;
    private String body;
    private String retorno;
    private boolean sucesso;
    private String cpf;
    private String dataNascimento;
    private String ip;
    private String host;
    private String data;
    private String hora;
    
    
	public DadosLogJPAMdl() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "UsuarioId", length = 80)
	public String getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	@Column(name = "UsuarioNome", length = 200)
	public String getUsuarioNome() {
		return usuarioNome;
	}
	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}
	
	
	@Column(name = "OperadoraId", length = 80)
	public String getOperadoraId() {
		return operadoraId;
	}
	public void setOperadoraId(String operadoraId) {
		this.operadoraId = operadoraId;
	}
	
	
	@Column(name = "OperadoraNome", length = 200)
	public String getOperadoraNome() {
		return operadoraNome;
	}
	public void setOperadoraNome(String operadoraNome) {
		this.operadoraNome = operadoraNome;
	}
	
	
	@Column(name = "OperadoraCNPJ", length = 20)
	public String getOperadoraCnpj() {
		return operadoraCnpj;
	}
	public void setOperadoraCnpj(String operadoraCnpj) {
		this.operadoraCnpj = operadoraCnpj;
	}

	
	@Column(name = "Body", length = 600)
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	@Column(name = "Retorno", length = 600)
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	
	@Column(name = "Sucesso", length = 1)
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	
	
	@Column(name = "Cpf", length = 20)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Column(name = "DataNascimento")
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	@Column(name = "IP", length = 100)
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Column(name = "Host", length = 100)
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
    
	
	@Column(name = "Data", length = 15)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	@Column(name = "Hora", length = 15)
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
    
    
	
	
	

}
