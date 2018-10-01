import { InterfaceService } from './../interface/interface.service';
import { AppConstants } from './../app.constants';
import { Categoria } from './../models/categoria.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import * as $ from "jquery/dist/jquery.min.js";

@Injectable({
  providedIn: 'root'
})
export class CategoriaService implements InterfaceService<Categoria>{
  private urlPesquisa;
  private urlAdiciona;
  private urlAtualiza;
  private urlRemove;
  private urlPesquisaId;

  constructor(private _httpClient: HttpClient) {
    this.urlPesquisa = AppConstants.SERVERPATH + "categoria/pesquisa";
    this.urlAdiciona = AppConstants.SERVERPATH + "categoria/adiciona";
    this.urlAtualiza = AppConstants.SERVERPATH + "categoria/atualiza";
    this.urlRemove = AppConstants.SERVERPATH + "categoria/remove";
    this.urlPesquisaId = AppConstants.SERVERPATH + "categoria/pesquisa/"
  }

  adiciona(categoria: Categoria) {
    return this._httpClient.post(this.urlRemove, $.param(categoria.toJSON()), {
      headers: AppConstants.headers()
    });
  }

  atualiza(categoria: Categoria) {
    return this._httpClient.post(this.urlRemove, $.param(categoria.toJSON()), {
      headers: AppConstants.headers()
    });
  }

  remove(id) {
    return this._httpClient.post(this.urlRemove, $.param({ 'id': id }), {
      headers: AppConstants.headers()
    });
  }

  pesquisa() {
    return this._httpClient.get(this.urlPesquisa);
  }
}
