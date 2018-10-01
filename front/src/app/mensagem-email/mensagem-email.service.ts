import { HttpClient } from '@angular/common/http';
import { AppConstants } from './../app.constants';
import { MensagemEmail } from './../models/mensagem-email.model';
import { InterfaceService } from './../interface/interface.service';
import { Injectable } from '@angular/core';
import * as $ from 'jquery/dist/jquery.min.js';

@Injectable({
  providedIn: 'root'
})
export class MensagemEmailService implements InterfaceService<MensagemEmail>{
  private urlAdiciona;
  constructor(private _httpClient: HttpClient) { 
    this.urlAdiciona = AppConstants.SERVERPATH + "mensagememail/adiciona";
  }

  adiciona(mensagemEmail: MensagemEmail) {
    return this._httpClient.post(this.urlAdiciona, $.param(mensagemEmail.toJSON()), {
      headers: AppConstants.headers()
    });
  }
  atualiza(item: any) {
    throw new Error("Method not implemented.");
  }
  remove(id: any) {
    throw new Error("Method not implemented.");
  }
  pesquisa() {
    throw new Error("Method not implemented.");
  }



}
