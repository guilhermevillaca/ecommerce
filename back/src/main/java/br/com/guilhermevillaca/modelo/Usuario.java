package br.com.guilhermevillaca.modelo;

import java.io.Serializable;

/**
 *
 * @author guilherme.villaca
 */
public class Usuario implements Serializable {

    private Integer usrCodigo;
    private String usrSenha;
    private String usrLogin;
    private PssFisica pssFisica;

    public Integer getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(Integer usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrSenha() {
        return usrSenha;
    }

    public void setUsrSenha(String usrSenha) {
        this.usrSenha = usrSenha;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public PssFisica getPssFisica() {
        return pssFisica;
    }

    public void setPssFisica(PssFisica pssFisica) {
        this.pssFisica = pssFisica;
    }

}
