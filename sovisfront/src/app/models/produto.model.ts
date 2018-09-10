import { Categoria } from './categoria.model';
export class Produto implements IntefaceModel<Produto>{

    prdCodigo: number;
    prdDescricao: String;
    prdTitulo: String;
    categoria: Categoria;
    prdValor: number;

    initJSON(json: any): Produto {
        this.prdCodigo = json.prdCodigo;
        this.prdDescricao = json.prdDescricao;
        this.prdTitulo = json.prdTitulo;
        this.categoria = json.categoria;
        this.prdValor = json.prdValor;
        return this;
    }

    toJSON() {
        return {
            'produto.prdCodigo': this.prdCodigo,
            'produto.prdDescricao': this.prdDescricao,
            'produto.prdTitulo': this.prdTitulo,
            'produto.categoria.ctgCodigo': this.categoria.ctgCodigo,
            'produto.prdValor': this.prdValor
        }
    }

}