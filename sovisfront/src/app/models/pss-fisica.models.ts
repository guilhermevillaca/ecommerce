import { InterfaceModel } from '../interface/interface.model';
export class PssFisica implements InterfaceModel<PssFisica> {

    pssFscCodigo: number;
    pssFscNome: String;
    pssFscCPF: String;
    pssFscEmail: String;

    initJSON(json: any): PssFisica {
        this.pssFscCodigo = json.pssFscCodigo;
        this.pssFscNome = json.pssFscNome;
        this.pssFscCPF = json.pssFscCPF;
        this.pssFscEmail = json.pssFscEmail;
        return this;
    }
    toJSON() {
        return {
            'pssFisica.pssFscCodigo': this.pssFscCodigo,
            'pssFisica.pssFscNome': this.pssFscNome,
            'pssFisica.pssFscCPF': this.pssFscCPF,
            'pssFisica.pssFscEmail': this.pssFscEmail
        } 
    }


}