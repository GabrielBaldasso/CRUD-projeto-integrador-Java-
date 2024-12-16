package model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "atendimentosservicos")
public class AtendimentosServicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtendimentoServico;
    int idAtendimento, idServicoProfissionais;
    float precoServico;
    LocalTime inicio, fim;

    public AtendimentosServicos() {
    }

    public AtendimentosServicos(int idAtendimento, int idServicoProfissionais, float precoServico, LocalTime inicio, LocalTime fim) {
        this.idAtendimento = idAtendimento;
        this.idServicoProfissionais = idServicoProfissionais;
        this.precoServico = precoServico;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getIdAtendimentoServico() {
        return idAtendimentoServico;
    }

    public void setIdAtendimentoServico(int idAtendimentoServico) {
        this.idAtendimentoServico = idAtendimentoServico;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdServicoProfissionais() {
        return idServicoProfissionais;
    }

    public void setIdServicoProfissionais(int idServicoProfissionais) {
        this.idServicoProfissionais = idServicoProfissionais;
    }

    public float getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(float precoServico) {
        this.precoServico = precoServico;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }
}
