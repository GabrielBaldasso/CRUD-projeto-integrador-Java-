package model;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nomeCliente, email, senha;
    private long contatoCliente, cpf;

    public Clientes() {
    }

    public Clientes(String nomeCliente, String email, String senha, long contatoCliente, long cpf) {
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.senha = senha;
        this.contatoCliente = contatoCliente;
        this.cpf = cpf;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(long contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
