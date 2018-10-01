package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class Carrinho implements Serializable {

    private Integer crrCodigo;
    private Usuario usuario;
    private Double crrValorTotal;

    public Integer getCrrCodigo() {
        return crrCodigo;
    }

    public void setCrrCodigo(Integer crrCodigo) {
        this.crrCodigo = crrCodigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getCrrValorTotal() {
        return crrValorTotal;
    }

    public void setCrrValorTotal(Double crrValorTotal) {
        this.crrValorTotal = crrValorTotal;
    }

}
