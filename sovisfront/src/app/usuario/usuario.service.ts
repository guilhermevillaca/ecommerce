import { AppConstants } from './../app.constants';
import { HttpClient } from '@angular/common/http';
import { Usuario } from './../models/usuario.models';
import { InterfaceService } from './../interface/interface.service';
import { Injectable } from '@angular/core';
import * as $ from 'jquery/dist/jquery.min.js';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService implements InterfaceService<Usuario>{
  private urlPesquisaUsuario;
  constructor(private _httpClient: HttpClient) {
    this.urlPesquisaUsuario = AppConstants.SERVERPATH + "usuario/pesquisaUsuario";
  }

  adiciona(item: Usuario) {
    throw new Error("Method not implemented.");
  }
  atualiza(item: Usuario) {
    throw new Error("Method not implemented.");
  }
  remove(id: any) {
    throw new Error("Method not implemented.");
  }
  pesquisa() {
    throw new Error("Method not implemented.");
  }
  pesquisaUsuario(usuario: Usuario) {
    return this._httpClient.post(this.urlPesquisaUsuario, $.param(usuario.toJSONLogin()), {
      headers: AppConstants.headers()
    });
  }

}
