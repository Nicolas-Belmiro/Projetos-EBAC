package main.Java.domain;

import java.util.Date;

public class NotaFiscalCab implements Persistente{

    private Long numeroNF;
    private String descricaoNF;
    private Date dataNF;
    private Double valorNF;
    private String clienteNF;
    public Long getNumeroNF() {
        return numeroNF;
    }
    public void setNumeroNF(Long numeroNF) {
        this.numeroNF = numeroNF;
    }
    public String getDescricaoNF() {
        return descricaoNF;
    }
    public void setDescricaoNF(String descricaoNF) {
        this.descricaoNF = descricaoNF;
    }
    public Date getDataNF() {
        return dataNF;
    }
    public void setDataNF(Date dataNF) {
        this.dataNF = dataNF;
    }
    public Double getValorNF() {
        return valorNF;
    }
    public void setValorNF(Double valorNF) {
        this.valorNF = valorNF;
    }
    public String getClienteNF() {
        return clienteNF;
    }
    public void setClienteNF(String clienteNF) {
        this.clienteNF = clienteNF;
    }
}
