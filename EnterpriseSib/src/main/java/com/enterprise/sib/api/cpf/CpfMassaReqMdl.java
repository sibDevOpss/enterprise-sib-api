package com.enterprise.sib.api.cpf;

import java.util.ArrayList;
import java.util.List;

public class CpfMassaReqMdl {

	private String nomeOperadora;
	private int codigoOperadora;
	private String dataNascimento;
	private String nomeUsuario;
	private List<String> listaCpfs = new ArrayList<>();
	
	
	public String getNomeOperadora() {
		return nomeOperadora;
	}
	public void setNomeOperadora(String nomeOperadora) {
		this.nomeOperadora = nomeOperadora;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public int getCodigoOperadora() {
		return codigoOperadora;
	}
	public void setCodigoOperadora(int codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	public List<String> getListaCpfs() {
		return listaCpfs;
	}
	public void setListaCpfs(List<String> listaCpfs) {
		this.listaCpfs = listaCpfs;
	}
	
	
	
}
