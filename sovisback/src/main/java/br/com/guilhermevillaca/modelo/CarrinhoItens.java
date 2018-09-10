package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class CarrinhoItens implements Serializable {

    private Integer crrItnCodigo;
    private Carrinho carrinho;
    private Produto produto;

    public Integer getCrrItnCodigo() {
        return crrItnCodigo;
    }

    public void setCrrItnCodigo(Integer crrItnCodigo) {
        this.crrItnCodigo = crrItnCodigo;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
