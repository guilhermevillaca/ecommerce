import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {
  carrinho = [];
  total: number;
  constructor() { 
    let cart = JSON.parse(localStorage.getItem('cart'));
    this.carrinho = cart['items'];
    this.total = cart['total'];
  }

  ngOnInit() {
  }

}
