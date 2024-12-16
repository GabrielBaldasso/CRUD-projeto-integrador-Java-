package model;

import javax.persistence.*;

@Entity
@Table (name = "formaspagamentos")
public class FormasPagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;
    private String descricaoPagamento;

    public FormasPagamentos() {
    }

    public FormasPagamentos(String descricaoPagamento) {
        this.descricaoPagamento = descricaoPagamento;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescricaoPagamento() {
        return descricaoPagamento;
    }

    public void setDescricaoPagamento(String descricaoPagamento) {
        this.descricaoPagamento = descricaoPagamento;
    }


}
