import { Component } from '@angular/core';
import { Evento } from 'src/app/model/evento-model';
import { EventoService } from 'src/app/service/evento-service';

@Component({
  selector: 'pro-carrossel',
  templateUrl: './carrossel.component.html',
  styleUrls: ['./carrossel.component.css']
})
export class CarrosselComponent {

  evento!: Evento;

  constructor(private service: EventoService) {
    // this.service.listarEventosRandom().subscribe(dados => this.evento = dados);
  }

  alterarImagem() {
    setInterval(()=>{
      console.log("A imagem foi alterada");
    }, 5000)
  }

  ngOnInit() {
    this.alterarImagem();
  }

}
