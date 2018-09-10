package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class Venda implements Serializable {

    private Integer vndCodigo;
    private Double vndValorTotal;
    private Usuario usuario;
    private FormaPagamento formaPagamento;
    private String vndPgtoConfirmado;

    public Integer getVndCodigo() {
        return vndCodigo;
    }

    public void setVndCodigo(Integer vndCodigo) {
        this.vndCodigo = vndCodigo;
    }

    public Double getVndValorTotal() {
        return vndValorTotal;
    }

    public void setVndValorTotal(Double vndValorTotal) {
        this.vndValorTotal = vndValorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getVndPgtoConfirmado() {
        return vndPgtoConfirmado;
    }

    public void setVndPgtoConfirmado(String vndPgtoConfirmado) {
        this.vndPgtoConfirmado = vndPgtoConfirmado;
    }

}
