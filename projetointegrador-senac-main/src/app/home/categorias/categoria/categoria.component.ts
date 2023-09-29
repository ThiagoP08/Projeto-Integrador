import { Component, Input } from '@angular/core';
import { Categoria} from 'src/app/model/categoria-model';

@Component({
  selector: 'pro-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent {

  @Input() categoria!: Categoria;

  ngOnInit() {
    // console.log(this.categoria.img);
  }

}
