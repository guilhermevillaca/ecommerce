import { Categoria } from './../models/categoria.model';
import { CategoriaService } from './categoria.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  categorias: Categoria[] = [];
  constructor(private _categoriaService: CategoriaService) { }

  ngOnInit() {
    this.pesquisa();
  }

  pesquisa(){
    this._categoriaService.pesquisa().toPromise().then(res => {
      this.categorias = res['response'].data;
    });
  }

}
