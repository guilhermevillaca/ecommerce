import { Produto } from './produto.model';
import { Venda } from './venda.models';
import { InterfaceModel } from './../interface/interface.model';
export class ItensVenda implements InterfaceModel<ItensVenda> {

    itnVndCodigo: number;
    venda: Venda;
    produto: Produto;
    itnVndQuantidade: number;
    itnVndTotal: number;

    initJSON(json: any): ItensVenda {
        this.itnVndCodigo = json.itnVndCodigo;
        this.produto = json.produto;
        this.venda = json.venda;
        this.itnVndQuantidade = json.itnVndQuantidade;
        this.itnVndTotal = json.itnVndTotal;
        return this;
    }

    toJSON() {
        return {
            'itensVenda.itnVndCodigo': this.itnVndCodigo,
            'itensVenda.itnVndQuantidade': this.itnVndQuantidade,
            'itensVenda.itnVndTotal': this.itnVndTotal,
            'itensVenda.produto.prdCodigo': this.produto.prdCodigo,
            'itensVenda.venda.vndCodigo': this.venda.vndCodigo
        }
    }


}