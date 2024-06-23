package main.Java.domain;

public class NotaFiscalDet implements Persistente{
    private Long sequencialINF;
    private Long numeroNF;
    private Integer codigoProdutoINF;
    private Integer quantidadeINF;
    private Double valorINF;
    public Long getSequencialINF() {
        return sequencialINF;
    }
    public void setSequencialINF(Long sequencialINF) {
        this.sequencialINF = sequencialINF;
    }
    public Long getNumeroNF() {
        return numeroNF;
    }
    public void setNumeroNF(Long numeroNF) {
        this.numeroNF = numeroNF;
    }
    public Integer getCodigoProdutoINF() {
        return codigoProdutoINF;
    }
    public void setCodigoProdutoINF(Integer codigoProdutoINF) {
        this.codigoProdutoINF = codigoProdutoINF;
    }
    public Integer getQuantidadeINF() {
        return quantidadeINF;
    }
    public void setQuantidadeINF(Integer quantidadeINF) {
        this.quantidadeINF = quantidadeINF;
    }
    public Double getValorINF() {
        return valorINF;
    }
    public void setValorINF(Double valorINF) {
        this.valorINF = valorINF;
    }
}
