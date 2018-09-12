import { InterfaceModel } from './../interface/interface.model';
export class MensagemEmail implements InterfaceModel<MensagemEmail> {

    msgEmlCodigo: number;
    mgsEmlRemetente: String;
    msgEmlDestinatario: String;
    msgEmlAssunto: String;
    msgEmlCorpo: String;
    msgEmlDtEnvio: Date;

    initJSON(json: any): MensagemEmail {
        this.msgEmlCodigo = json.msgEmlCodigo;
        this.mgsEmlRemetente = json.msgEmlRemetente;
        this.msgEmlDestinatario = json.msgEmlDestinatario;
        this.msgEmlAssunto = json.msgEmlAssunto;
        this.msgEmlCorpo = json.msgEmlCorpo;
        this.msgEmlDtEnvio = json.msgEmlDtEnvio;
        return this;
    }

    toJSON() {
        return {
            'mensagemEmail.msgEmlCodigo': this.msgEmlCodigo,
            'mensagemEmail.mgsEmlRemetente': this.mgsEmlRemetente,
            'mensagemEmail.msgEmlDestinatario': this.msgEmlDestinatario,
            'mensagemEmail.msgEmlAssunto': this.msgEmlAssunto,
            'mensagemEmail.msgEmlCorpo': this.msgEmlCorpo,
            'mensagemEmail.msgEmlDtEnvio': this.msgEmlDtEnvio
        }
    }


}