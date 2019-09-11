package com.enterprise.sib.api.cpf;

class CpfMdlResp {

    private String CPF;
    private String Nome;
    private String Situacao;
    private String Digito;
    private String DataNascimento;
    private String AnoObito;
    private String DataInscricao;
    private String DataHora;
    private String Comprovante;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String situacao) {
        Situacao = situacao;
    }

    public String getDigito() {
        return Digito;
    }

    public void setDigito(String digito) {
        Digito = digito;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getAnoObito() {
        return AnoObito;
    }

    public void setAnoObito(String anoObito) {
        AnoObito = anoObito;
    }

    public String getDataInscricao() {
        return DataInscricao;
    }

    public void setDataInscricao(String dataInscricao) {
        DataInscricao = dataInscricao;
    }

    public String getDataHora() {
        return DataHora;
    }

    public void setDataHora(String dataHora) {
        DataHora = dataHora;
    }

    public String getComprovante() {
        return Comprovante;
    }

    public void setComprovante(String comprovante) {
        Comprovante = comprovante;
    }

}