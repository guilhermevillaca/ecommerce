package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class PssFisica implements Serializable {

    private Integer pssFscCodigo;
    private String pssFscNome;
    private String pssFscCPF;
    private String pssFscEmail;

    public Integer getPssFscCodigo() {
        return pssFscCodigo;
    }

    public void setPssFscCodigo(Integer pssFscCodigo) {
        this.pssFscCodigo = pssFscCodigo;
    }

    public String getPssFscNome() {
        return pssFscNome;
    }

    public void setPssFscNome(String pssFscNome) {
        this.pssFscNome = pssFscNome;
    }

    public String getPssFscCPF() {
        return pssFscCPF;
    }

    public void setPssFscCPF(String pssFscCPF) {
        this.pssFscCPF = pssFscCPF;
    }

    public String getPssFscEmail() {
        return pssFscEmail;
    }

    public void setPssFscEmail(String pssFscEmail) {
        this.pssFscEmail = pssFscEmail;
    }

}
