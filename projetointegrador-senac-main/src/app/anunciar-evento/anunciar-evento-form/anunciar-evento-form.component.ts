import { Component } from '@angular/core';
import { Evento } from 'src/app/model/evento-model';
import { EventoService } from 'src/app/service/evento-service';

@Component({
  selector: 'pro-anunciar-evento-form',
  templateUrl: './anunciar-evento-form.component.html',
  styleUrls: ['./anunciar-evento-form.component.css']
})
export class AnunciarEventoFormComponent {

  constructor(private service: EventoService) {}

  evento: Evento = {
    id: 0,
    img_src: '',
    titulo: '',
    data_evento: '', // Inicialize com uma string vazia
    hora: '', // Inicialize com uma string vazia
    bairro: '',
    estado: '',
    rua: '',
    descricao: '',
    politica: '',
    min_lotacao: 0,
    max_lotacao: 0,
    status: false,
    min_idade: 0,
    categoria_id: 0
  };

  onFileSelected(event: any) {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      // Você pode acessar informações sobre o arquivo selecionado, se necessário.
      console.log('Nome do arquivo:', selectedFile.name);
      
      // Aqui, você pode fazer o que precisa com o arquivo selecionado, como fazer o upload para um servidor.
      // Você também pode atribuir o nome do arquivo ao objeto evento, se desejar:
      this.evento.img_src = selectedFile.name;
    }
  }

  onSubmit() {
    console.log('Valores do formulário:', this.evento);

    this.service.adicionarEvento(this.evento).subscribe(() => this.service.listarEventos);
    
    // Faça o que você precisa com os valores do formulário, como enviar para um serviço ou realizar uma ação.
  }

}
