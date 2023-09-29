import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/model/evento-model';

@Component({
  selector: 'pro-evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.css']
})
export class EventoComponent {
  
  @Input() evento!: Evento;
  @Input()id!: number;
  

  ngOnInit() {
    console.log("id" + this.id);
  }
}
