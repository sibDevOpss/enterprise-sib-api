package com.enterprise.sib.api.log;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "logs")
public class DadosLogCpfJPAMdl {
	
	private int id;
	private int codigoOperadora;
	private String nomeOperadora;
	private String nomeUsuario;
	private String cpf;
	private Date data;
	private Date hora;
	
	
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
	
	
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	@Temporal(TemporalType.TIME)
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}


}
