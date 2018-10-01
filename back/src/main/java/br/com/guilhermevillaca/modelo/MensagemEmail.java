package br.com.guilhermevillaca.modelo;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author guilherme.villaca
 */
public class MensagemEmail implements Serializable {

    private Integer msgEmlCodigo;
    private String mgsEmlRemetente;
    private String msgEmlDestinatario;
    private String msgEmlAssunto;
    private String msgEmlCorpo;
    private Date msgEmlDtEnvio;

    public Integer getMsgEmlCodigo() {
        return msgEmlCodigo;
    }

    public void setMsgEmlCodigo(Integer msgEmlCodigo) {
        this.msgEmlCodigo = msgEmlCodigo;
    }

    public String getMgsEmlRemetente() {
        return mgsEmlRemetente;
    }

    public void setMgsEmlRemetente(String mgsEmlRemetente) {
        this.mgsEmlRemetente = mgsEmlRemetente;
    }

    public String getMsgEmlDestinatario() {
        return msgEmlDestinatario;
    }

    public void setMsgEmlDestinatario(String msgEmlDestinatario) {
        this.msgEmlDestinatario = msgEmlDestinatario;
    }

    public String getMsgEmlAssunto() {
        return msgEmlAssunto;
    }

    public void setMsgEmlAssunto(String msgEmlAssunto) {
        this.msgEmlAssunto = msgEmlAssunto;
    }

    public String getMsgEmlCorpo() {
        return msgEmlCorpo;
    }

    public void setMsgEmlCorpo(String msgEmlCorpo) {
        this.msgEmlCorpo = msgEmlCorpo;
    }

    public Date getMsgEmlDtEnvio() {
        return msgEmlDtEnvio;
    }

    public void setMsgEmlDtEnvio(Date msgEmlDtEnvio) {
        this.msgEmlDtEnvio = msgEmlDtEnvio;
    }

}
