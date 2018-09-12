import { HttpClient } from '@angular/common/http';
import { AppConstants } from './../app.constants';
import { InterfaceService } from './../interface/interface.service';
import { ItensVenda } from './../models/itens-venda.models';
import { Injectable } from '@angular/core';
import * as $ from 'jquery/dist/jquery.min.js';

@Injectable({
  providedIn: 'root'
})
export class ItensVendaService implements InterfaceService<ItensVenda>{
  private urlAdiciona;

  constructor(private _httpClient: HttpClient) {
    this.urlAdiciona = AppConstants.SERVERPATH + "itensvenda/adiciona";
  }

  adiciona(item: ItensVenda) {
    return this._httpClient.post(this.urlAdiciona, $.param(item.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  atualiza(item: ItensVenda) {
    throw new Error("Method not implemented.");
  }
  remove(id: any) {
    throw new Error("Method not implemented.");
  }
  pesquisa() {
    throw new Error("Method not implemented.");
  }

}
