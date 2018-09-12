import { InterfaceModel } from './../interface/interface.model';
export class FormaPagamento implements InterfaceModel<FormaPagamento> {

    frmPgtCodigo: number;
    frmPgtDescricao: String;

    initJSON(json: any): FormaPagamento {
        this.frmPgtCodigo = json.frmPgtCodigo;
        this.frmPgtDescricao = json.frmPgtDescricao;
        return this;
    }
 
    toJSON() {
        return {
            'formaPagamento.frmPgtCodigo': this.frmPgtCodigo,
            'formaPagamento.frmPgtDescricao': this.frmPgtDescricao
        }
    }


}