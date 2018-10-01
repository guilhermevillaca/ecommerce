import { AppConstants } from './../app.constants';
import { HttpClient } from '@angular/common/http';
import { Venda } from './../models/venda.models';
import { InterfaceService } from './../interface/interface.service';
import { Injectable } from '@angular/core';
import * as $ from 'jquery/dist/jquery.min.js';

@Injectable({
  providedIn: 'root'
})
export class VendaService implements InterfaceService<Venda>{
  private urlAdiciona;
  constructor(private _httpClient: HttpClient) { 
    this.urlAdiciona = AppConstants.SERVERPATH + "venda/adiciona";
  }

  adiciona(venda: Venda) {
    return this._httpClient.post(this.urlAdiciona, $.param(venda.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  atualiza(item: Venda) {
    throw new Error("Method not implemented.");
  }
  remove(id: any) {
    throw new Error("Method not implemented.");
  }
  pesquisa() {
    throw new Error("Method not implemented.");
  }

}
