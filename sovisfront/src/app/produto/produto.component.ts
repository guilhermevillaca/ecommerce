import { AppComponent } from './../app.component';
import { Carrinho } from './../models/carrinho.models';
import { Produto } from './../models/produto.model';
import { ProdutoService } from './produto.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {
  produtos: Produto[] = [];  //lista de produtos
  produto: Produto; //produto para ser exibido detalhes
  showsingle: boolean = false; //booleano para mostrar lista ou detalhes de produto
  carrinho: Carrinho;  
  constructor(private _produtoService: ProdutoService, private _route: ActivatedRoute, private app: AppComponent) {
    
    this._route.params.subscribe(params => {
      if (params['ctgCodigo'] != null) {
        this.produtos = [];
        this.showsingle = false;
        this._produtoService.pesquisaCat(params['ctgCodigo']).toPromise().then(res => {
          this.produtos = res['response'].data;
        });
      } else if (params['prdCodigo'] != null) {
        this.produtos = [];
        this.produto = new Produto();
        this.showsingle = true;
        this._produtoService.pesquisaId(params['prdCodigo']).toPromise().then(res => {
          this.produto.initJSON(res['response'].data);
        });
      } else {
        this.showsingle = false;
        this.pesquisa();
      }
    })
  }

  ngOnInit() {
  }

  pesquisa() {
    this.produtos = [];
    this._produtoService.pesquisa().toPromise().then(res => {
      this.produtos = res['response'].data;
    });
  }

  addCarrinho(produto: Produto) {
    let item = {};
    item['prdCodigo'] = produto.prdCodigo;
    item['prdDescricao'] = produto.prdDescricao
    item['quantidade'] = 1;
    this.carrinhoPush(item);
  }

  /**
   * cria carrinho no localStorage. se já existir adiciona mais 1 item.
   * bug: ao dar refresh na página localStorage é limpo.
  **/
  carrinhoPush(item: any) {
    let cart = JSON.parse(localStorage.getItem('cart'));    
    let add :boolean = true;
    cart['items'].forEach(produto => {
      if(produto.prdCodigo == item.prdCodigo){
        add = false;
        produto.quantidade += 1;
      }
    })
    if(add){
      cart['items'].push(item);
    }
    this.app.atualizaQntCarrinho();
    localStorage.setItem('cart', JSON.stringify(cart));
  }
}
