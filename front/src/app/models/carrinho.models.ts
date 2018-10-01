import { InterfaceModel } from './../interface/interface.model';
export class Carrinho implements InterfaceModel<Carrinho> {

    crrCodigo: number;

    initJSON(json: any): Carrinho {
        return this;
    }    
    
    toJSON() {
        throw new Error("Method not implemented.");
    }


}