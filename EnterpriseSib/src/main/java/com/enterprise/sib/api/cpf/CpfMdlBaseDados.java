package com.enterprise.sib.api.cpf;

import com.enterprise.sib.utils.Constant;

import javax.persistence.*;

@Entity
@Table(name = Constant.TABLE_CPF)
public class CpfMdlBaseDados {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cpf;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
