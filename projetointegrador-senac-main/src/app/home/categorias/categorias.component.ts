import { Component } from '@angular/core';
import { Categoria } from 'src/app/model/categoria-model';
import { CategoriaService } from 'src/app/service/categoria-service';

@Component({
  selector: 'pro-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent {
    categorias: Categoria[] = []

    constructor(private service: CategoriaService) {
      this.service.listarCategorias().subscribe(dados => this.categorias = dados);
      console.log(this.categorias);
    }
    
}
