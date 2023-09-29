import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/model/evento-model';
import { EventoService } from 'src/app/service/evento-service';

@Component({
  selector: 'pro-resultado',
  templateUrl: './resultado.component.html',
  styleUrls: ['./resultado.component.css']
})
export class ResultadoComponent {

  eventos: Evento[] = [];
  id!: number;

  constructor(private service: EventoService, private route: ActivatedRoute) {
    this.service.listarEventos().subscribe(dados => this.eventos = dados);

  }

  ngOnInit() {
    this.id = this.route.snapshot.params["id"];
  }

}
