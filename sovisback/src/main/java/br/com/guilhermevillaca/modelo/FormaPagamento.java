package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class FormaPagamento implements Serializable {

    private Integer frmPgtCodigo;
    private String frmPgtDescricao;

    public Integer getFrmPgtCodigo() {
        return frmPgtCodigo;
    }

    public void setFrmPgtCodigo(Integer frmPgtCodigo) {
        this.frmPgtCodigo = frmPgtCodigo;
    }

    public String getFrmPgtDescricao() {
        return frmPgtDescricao;
    }

    public void setFrmPgtDescricao(String frmPgtDescricao) {
        this.frmPgtDescricao = frmPgtDescricao;
    }

}
