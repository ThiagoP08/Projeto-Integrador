import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/model/evento-model';
import { EventoService } from 'src/app/service/evento-service';

@Component({
  selector: 'pro-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent {

  @Input()evento!: Evento;
  id!: number;

  constructor(private service: EventoService, private route: ActivatedRoute) {

    this.id = this.route.snapshot.params['id'];
    console.log("evento-info id:" + this.id);
    
    this.service.listarEventoPorId(this.id).subscribe(dados => this.evento = dados);
  }
}
