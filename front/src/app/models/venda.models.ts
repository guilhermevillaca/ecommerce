import { FormaPagamento } from './forma-pagamento.models';
import { Usuario } from './usuario.models';
import { InterfaceModel } from './../interface/interface.model';

export class Venda implements InterfaceModel<Venda> {

    vndCodigo: number;
    vndValorTotal: number;
    usuario: Usuario;
    formaPagamento: FormaPagamento;
    vndPgtoConfirmado: String;

    initJSON(json: any): Venda {
        this.vndCodigo = json.vndCodigo;
        this.vndValorTotal = json.vndValorTotal;
        this.usuario = json.usuario;
        this.formaPagamento = json.formaPagamento;
        this.vndPgtoConfirmado = json.vndPgtoConfirmado;
        return this;
    }

    toJSON() {
        return {
            'venda.vndCodigo': this.vndCodigo,
            'venda.vndValorTotal': this.vndValorTotal,
            'venda.usuario.usrCodigo': this.usuario.usrCodigo,
            'venda.formaPagamento.frmPgtCodigo': this.formaPagamento.frmPgtCodigo,
            'venda.vndPgtoConfirmado': this.vndPgtoConfirmado
        }
    }


}