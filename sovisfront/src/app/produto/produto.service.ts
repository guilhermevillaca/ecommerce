import { HttpClient } from '@angular/common/http';
import { InterfaceService } from './../interface/interface.service';
import { AppConstants } from './../app.constants';
import { Injectable } from '@angular/core';
import { Produto } from '../models/produto.model';
import * as $ from 'jquery/dist/jquery.min.js';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService implements InterfaceService<Produto>{

  private urlPesquisa;
  private urlAdiciona;
  private urlAtualiza;
  private urlRemove;
  private urlPesquisaId;
  private urlPesquisaCat;
  constructor(private _httpClient: HttpClient) {
    this.urlPesquisa = AppConstants.SERVERPATH + "produto/pesquisa";
    this.urlAdiciona = AppConstants.SERVERPATH + "produto/adiciona";
    this.urlAtualiza = AppConstants.SERVERPATH + "produto/atualiza";
    this.urlRemove = AppConstants.SERVERPATH + "produto/remove";
    this.urlPesquisaId = AppConstants.SERVERPATH + "produto/pesquisaId/";
    this.urlPesquisaCat = AppConstants.SERVERPATH + "produto/pesquisaCat/";
  }

  adiciona(item: Produto) {
    return this._httpClient.post(this.urlAdiciona, $.param(item.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  atualiza(item: Produto) {
    return this._httpClient.post(this.urlAtualiza, $.param(item.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  remove(id: any) {
    return this._httpClient.post(this.urlRemove, $.param({'id': id}), {
      headers: AppConstants.headers()
    });
  }
  pesquisa() {
    return this._httpClient.get(this.urlPesquisa);
  }

  pesquisaId(id: number) {
    return this._httpClient.get(this.urlPesquisaId + id);
  }

  pesquisaCat(id: number) {    
    return this._httpClient.get(this.urlPesquisaCat + id);
  }

}
