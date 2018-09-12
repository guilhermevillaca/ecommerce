import { PssFisica } from './pssFisica.models';
import { InterfaceModel } from './../interface/interface.model';
export class Usuario implements InterfaceModel<Usuario> {

    usrCodigo: number;
    usrSenha: String;
    usrLogin: String;
    pssFisica: PssFisica;

    initJSON(json: any): Usuario {
        this.usrCodigo = json.usrCodigo;
        this.usrSenha = json.usrSenha;
        this.usrLogin = json.usrLogin;
        this.pssFisica = json.pssFisica;
        return this;
    }

    toJSON() {
        return {
            'usuario.usrCodigo': this.usrCodigo,
            'usuario.usrSenha': this.usrSenha,
            'usuario.usrLogin': this.usrLogin,
            'usuario.pssFisica.pssFscCodigo': this.pssFisica.pssFscCodigo
        }
    }

    toJSONLogin(){
        return {
            'usuario.usrSenha': this.usrSenha,
            'usuario.usrLogin': this.usrLogin            
        }
    }


}