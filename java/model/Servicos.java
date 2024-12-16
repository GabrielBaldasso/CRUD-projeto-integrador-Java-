package model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "servicos")
public class Servicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServico;
    private String descricaoServicos, nomeServco;
    private LocalTime tempo;

    public Servicos() {
    }

    public Servicos(String descricaoServicos, String nomeServco, LocalTime tempo) {
        this.descricaoServicos = descricaoServicos;
        this.nomeServco = nomeServco;
        this.tempo = tempo;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDescricaoServicos() {
        return descricaoServicos;
    }

    public void setDescricaoServicos(String descricaoServicos) {
        this.descricaoServicos = descricaoServicos;
    }

    public String getNomeServco() {
        return nomeServco;
    }

    public void setNomeServco(String nomeServco) {
        this.nomeServco = nomeServco;
    }

    public LocalTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalTime tempo) {
        this.tempo = tempo;
    }
}
