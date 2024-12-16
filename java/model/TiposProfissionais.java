package model;

import javax.persistence.*;

@Entity
@Table(name = "tiposprofissionais")
public class TiposProfissionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoProfissional;
    private String nomeTipo, descricao;

    public TiposProfissionais() {
    }

    public TiposProfissionais(String nomeTipo, String descricao) {
        this.nomeTipo = nomeTipo;
        this.descricao = descricao;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public int getIdTipoProfissional() {
        return idTipoProfissional;
    }

    public void setIdTipoProfissional(int idTipoProfissional) {
        this.idTipoProfissional = idTipoProfissional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
