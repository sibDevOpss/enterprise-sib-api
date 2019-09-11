package com.enterprise.sib.api.login;

class LoginMdlReq {

    private String usuario;
    private String senha;

    String getUsuario() {
        return usuario;
    }

    void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    String getSenha() {
        return senha;
    }

    void setSenha(String senha) {
        this.senha = senha;
    }

}
