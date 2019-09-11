package com.enterprise.sib.api.log;

import com.enterprise.sib.utils.Constant;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(name = Constant.TABLE_LOG)
class LogMdlBaseDados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean sucesso;
    private String cpf;
    private String data;
    private String dataNascimento;
    private String hora;
    private String host;
    private String ip;
    private String operadoraCnpj;
    private String operadoraId;
    private String operadoraNome;
    private String retorno;
    private String usuarioId;
    private String usuarioNome;

    public LogMdlBaseDados() {
    }

    public LogMdlBaseDados(LogMdlCpf dadosLog, String retorno, boolean indicadorSucessoBusca, HttpServletRequest request) {

        this.sucesso = indicadorSucessoBusca;
        this.cpf = dadosLog.getParamsConsulta().getCpf();
        this.data = dadosLog.getDataHora().getData();
        this.dataNascimento = dadosLog.getParamsConsulta().getDataNascimento();
        this.hora = dadosLog.getDataHora().getHora();
        this.host = request.getRemoteHost();
        this.ip = request.getRemoteAddr();
        this.operadoraCnpj = dadosLog.getParamsConsulta().getOperadoraCnpj();
        this.operadoraId = dadosLog.getParamsConsulta().getOperadoraId();
        this.operadoraNome = dadosLog.getParamsConsulta().getOperadoraNome();
        this.retorno = retorno;
        this.usuarioId = dadosLog.getParamsConsulta().getUsuarioId();
        this.usuarioNome = dadosLog.getParamsConsulta().getUsuarioNome();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperadoraCnpj() {
        return operadoraCnpj;
    }

    public void setOperadoraCnpj(String operadoraCnpj) {
        this.operadoraCnpj = operadoraCnpj;
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

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
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
}