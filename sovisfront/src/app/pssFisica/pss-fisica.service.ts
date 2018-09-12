import { AppConstants } from './../app.constants';
import { HttpClient } from '@angular/common/http';
import { PssFisica } from './../models/pssFisica.models';
import { InterfaceService } from './../interface/interface.service';
import { Injectable } from '@angular/core';
import * as $ from 'jquery/dist/jquery.min.js';
@Injectable({
  providedIn: 'root'
})
export class PssFisicaService implements InterfaceService<PssFisica>{
  private urlAdiciona;
  constructor(private _httpClient: HttpClient) { 
    this.urlAdiciona = AppConstants.SERVERPATH + "pssFisica/adiciona";
  }

  adiciona(item: PssFisica) {
    console.log(item);    
    return this._httpClient.post(this.urlAdiciona, $.param(item.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  atualiza(item: PssFisica) {
    throw new Error("Method not implemented.");
  }
  remove(id: any) {
    throw new Error("Method not implemented.");
  }
  pesquisa() {
    throw new Error("Method not implemented.");
  }


}
