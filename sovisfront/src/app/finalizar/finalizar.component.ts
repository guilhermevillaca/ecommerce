import { MensagemEmailService } from './../mensagem-email/mensagem-email.service';
import { MensagemEmail } from './../models/mensagem-email.model';
import { ItensVendaService } from './../itens-venda/itens-venda.service';
import { VendaService } from './../venda/venda.service';
import { ItensVenda } from './../models/itens-venda.models';
import { FormaPagamento } from './../models/forma-pagamento.models';
import { Venda } from './../models/venda.models';
import { PssFisica } from './../models/pss-fisica.models';
import { UsuarioService } from './../usuario/usuario.service';
import { PssFisicaService } from './../pssFisica/pss-fisica.service';
import { Usuario } from './../models/usuario.models';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../models/produto.model';

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
  pgtoSucesso: boolean = false;
  constructor(private _usuarioService: UsuarioService,
    private _pssFisicaService: PssFisicaService,
    private _vendaService: VendaService, private _itensVendaService: ItensVendaService,
    private _mensagemEmailService: MensagemEmailService) {
    this.usuario = new Usuario();
    this.pssFisica = new PssFisica();
    let cart = JSON.parse(localStorage.getItem('cart'));
    this.total = cart['total'];
  }

  ngOnInit() {
  }

  entrar(usuario: Usuario) {
    this._usuarioService.pesquisaUsuario(usuario).toPromise().then(res => {
      if (res['response'].message == "usuario_invalido") {
        this.msg = "Usuário inválido, tente novamente ou crie um novo usuário!";
        localStorage.removeItem("logado");
      } else {
        this.logado = true;
        localStorage.setItem("usuario", JSON.stringify(res['response'].data));
      }
    });
  }

  cadastrar(pssFisica: PssFisica) {
    this._pssFisicaService.adiciona(pssFisica).toPromise().then(res => {
      console.log(res);
    });
  }

  pagamentoCartao() {
    //add venda
    let lsUsuario = JSON.parse(localStorage.getItem("usuario"));
    let usuario: Usuario = new Usuario();
    usuario.initJSON(lsUsuario);
    let venda: Venda = new Venda();
    let frmPagamento: FormaPagamento = new FormaPagamento();
    frmPagamento.frmPgtCodigo = 1;
    venda.formaPagamento = frmPagamento;
    venda.usuario = usuario;
    venda.vndValorTotal = this.total;
    venda.vndPgtoConfirmado = "T";

    this._vendaService.adiciona(venda).toPromise().then(res => {
      let v: Venda = new Venda();
      v.initJSON(res['response'].data);      
      //add itens venda
      let cart = JSON.parse(localStorage.getItem('cart'));
      let total = 0;
      cart['items'].forEach(produto => {
        let itensVenda: ItensVenda = new ItensVenda();
        itensVenda.produto = new Produto();
        itensVenda.venda = new Venda();
        itensVenda.produto.prdCodigo = produto.prdCodigo;
        itensVenda.itnVndQuantidade = produto.quantidade;
        itensVenda.itnVndTotal = produto.quantidade * produto.prdValor;
        itensVenda.venda.vndCodigo = v.vndCodigo;
        this._itensVendaService.adiciona(itensVenda).toPromise().then(res => {
          console.log(res);          
        });
      });
    });

    //enviar email
    let mensagemEmail: MensagemEmail = new MensagemEmail();    
    mensagemEmail.msgEmlDestinatario = usuario.pssFisica.pssFscEmail;
    mensagemEmail.mgsEmlRemetente = "ecommerce@site.com";
    mensagemEmail.msgEmlAssunto = "Confirmação de compra de produto";
    mensagemEmail.msgEmlCorpo = "Compra realizada com sucesso";
    this._mensagemEmailService.adiciona(mensagemEmail).toPromise().then(res => {
      this.msg = "Pagamento realizado com sucesso!, Foi enviado um email para " + usuario.pssFisica.pssFscEmail;
      this.pgtoSucesso = true;
    });

    
  }

}
