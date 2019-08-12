package com.enterprise.sib.api.log;

import javax.persistence.*;


@Entity
@Table(name = "logs")
public class DadosLogCpfJPAMdl {
	
	private int id;
	private int codigoOperadora;
	private String nomeOperadora;
	private String nomeUsuario;
	private String cpf;
	private String data;
	private String hora;
	
	
	public DadosLogCpfJPAMdl() {
	
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "cd_operadora")
	public int getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(int codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	
	
	@Column(name = "nm_operadora")
	public String getNomeOperadora() {
		return nomeOperadora;
	}
	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}
	
	
	@Column(name = "nm_usuario")
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Column(name = "data")
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	@Column(name = "hora")
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	

}
