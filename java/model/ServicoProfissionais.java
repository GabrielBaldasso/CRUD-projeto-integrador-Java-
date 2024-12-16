package model;

import javax.persistence.*;

@Entity
@Table(name = "servicoprofissionais")
public class ServicoProfissionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicoProfissionais;
    private int idProfissional, idServico;
    private float precoProfissional;

    public ServicoProfissionais() {
    }

    public ServicoProfissionais(int idProfissional, int idServico, float precoProfissional) {
        this.idProfissional = idProfissional;
        this.idServico = idServico;
        this.precoProfissional = precoProfissional;
    }

    public int getIdServicoProfissionais() {
        return idServicoProfissionais;
    }

    public void setIdServicoProfissionais(int idServicoProfissionais) {
        this.idServicoProfissionais = idServicoProfissionais;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public float getPrecoProfissional() {
        return precoProfissional;
    }

    public void setPrecoProfissional(float precoProfissional) {
        this.precoProfissional = precoProfissional;
    }
}
