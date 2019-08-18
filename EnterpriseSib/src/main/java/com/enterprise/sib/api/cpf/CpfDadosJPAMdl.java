package com.enterprise.sib.api.cpf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;


@Entity
@Table(name = "cpfs")
public class CpfDadosJPAMdl {
	

	private int id;
	private String cpf;
	private String body;
	
	
	public CpfDadosJPAMdl() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name = "cpf", length = 80)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@Column(name = "body", length = 600)
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
