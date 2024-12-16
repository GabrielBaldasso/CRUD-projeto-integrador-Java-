package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "atendimentos")
public class Atendimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtendimento;
    private int idFormaPagamento, idCliente;
    private LocalDate data;
    private LocalTime horarioInicio, horarioFinaliza;
    private String comentario, status;
    private Float precoTotal;

    public Atendimentos() {
    }

    public Atendimentos(int idFormaPagamento, int idCliente, LocalDate data, LocalTime horarioInicio, LocalTime horarioFinaliza, String comentario, String status, float precoTotal) {
        this.idFormaPagamento = idFormaPagamento;
        this.idCliente = idCliente;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFinaliza = horarioFinaliza;
        this.comentario = comentario;
        this.status = status;
        this.precoTotal = precoTotal;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFinaliza() {
        return horarioFinaliza;
    }

    public void setHorarioFinaliza(LocalTime horarioFinaliza) {
        this.horarioFinaliza = horarioFinaliza;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrecoTotal() {
        return precoTotal != null ? precoTotal : 0.0f;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}
