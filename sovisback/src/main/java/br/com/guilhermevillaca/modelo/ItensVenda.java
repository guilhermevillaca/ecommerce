package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class ItensVenda implements Serializable {

    private Integer itnVndCodigo;
    private Venda venda;
    private Produto produto;
    private Integer itnVndQuantidade;
    private Double itnVndTotal;

    public Integer getItnVndCodigo() {
        return itnVndCodigo;
    }

    public void setItnVndCodigo(Integer itnVndCodigo) {
        this.itnVndCodigo = itnVndCodigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getItnVndQuantidade() {
        return itnVndQuantidade;
    }

    public void setItnVndQuantidade(Integer itnVndQuantidade) {
        this.itnVndQuantidade = itnVndQuantidade;
    }

    public Double getItnVndTotal() {
        return itnVndTotal;
    }

    public void setItnVndTotal(Double itnVndTotal) {
        this.itnVndTotal = itnVndTotal;
    }

}
