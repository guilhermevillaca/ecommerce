import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{  
  quantidade: number;
  cart = {};
  constructor(){
    this.cart['items'] = [];
    localStorage.setItem("cart", JSON.stringify(this.cart));
  }

  ngOnInit() {
    this.atualizaQntCarrinho();
  }

  atualizaQntCarrinho(){
    let cart = JSON.parse(localStorage.getItem('cart'));           
    let total = 0;
    cart['items'].forEach(produto => {      
      total += produto.quantidade;
    });         
    this.quantidade = total;    
  }

}
