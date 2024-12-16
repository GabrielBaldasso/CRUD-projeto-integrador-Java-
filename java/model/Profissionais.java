package model;

import javax.persistence.*;

@Entity
@Table(name = "profissionais")
public class Profissionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfissional;
    private String nomeProfissionais, email, senha;
    private long contato;
    private int idTipoProfissional;

    public Profissionais() {
    }

    public Profissionais(String nomeProfissionais, String email, String senha, long contato, int idTipoProfissional) {
        this.nomeProfissionais = nomeProfissionais;
        this.email = email;
        this.senha = senha;
        this.contato = contato;
        this.idTipoProfissional = idTipoProfissional;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getNomeProfissionais() {
        return nomeProfissionais;
    }

    public void setNomeProfissionais(String nomeProfissionais) {
        this.nomeProfissionais = nomeProfissionais;
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

    public long getContato() {
        return contato;
    }

    public void setContato(long contato) {
        this.contato = contato;
    }

    public int getIdTipoProfissional() {
        return idTipoProfissional;
    }

    public void setIdTipoProfissional(int idTipoProfissional) {
        this.idTipoProfissional = idTipoProfissional;
    }
}
