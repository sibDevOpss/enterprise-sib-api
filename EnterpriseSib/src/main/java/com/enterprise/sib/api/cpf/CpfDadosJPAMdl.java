package com.enterprise.sib.api.cpf;

import javax.persistence.*;

@Entity
@Table(name = "cpfs")
public class CpfDadosJPAMdl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cpf", length = 80)
    private String cpf;

    @Column(name = "body", length = 600)
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
