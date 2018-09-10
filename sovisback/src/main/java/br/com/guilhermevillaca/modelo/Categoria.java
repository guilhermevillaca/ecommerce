package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class Categoria implements Serializable{

    private Integer ctgCodigo;
    private String ctgDescricao;

    public Integer getCtgCodigo() {
        return ctgCodigo;
    }

    public void setCtgCodigo(Integer ctgCodigo) {
        this.ctgCodigo = ctgCodigo;
    }

    public String getCtgDescricao() {
        return ctgDescricao;
    }

    public void setCtgDescricao(String ctgDescricao) {
        this.ctgDescricao = ctgDescricao;
    }

}
