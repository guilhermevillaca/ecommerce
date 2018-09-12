import { UsuarioService } from './../usuario/usuario.service';
import { PssFisicaService } from './../pssFisica/pss-fisica.service';
import { Usuario } from './../models/usuario.models';
import { PssFisica } from './../models/pssFisica.models';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-finalizar',
  templateUrl: './finalizar.component.html',
  styleUrls: ['./finalizar.component.css']
})
export class FinalizarComponent implements OnInit {
  msg: string;
  logado: boolean = false;
  usuario: Usuario;
  pssFisica: PssFisica;
  total: number;
  constructor(private _usuarioService: UsuarioService, private _pssFisicaService: PssFisicaService) {
    this.usuario = new Usuario();
    this.pssFisica = new PssFisica();
    let cart = JSON.parse(localStorage.getItem('cart'));        
    this.total = cart['total'];
  }

  ngOnInit() {    
  }

  entrar(usuario: Usuario){
    this._usuarioService.pesquisaUsuario(usuario).toPromise().then(res => {
      if(res['response'].message=="usuario_invalido"){
        this.msg = "Usuário inválido, tente novamente ou crie um novo usuário!";
        localStorage.removeItem("logado");
      } else{
        this.logado = true;
      }      
    });
  }

  cadastrar(pssFisica: PssFisica){
    this._pssFisicaService.adiciona(pssFisica).toPromise().then(res =>{
      console.log(res);
    });
  }

}
