import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Evento } from "../model/evento-model";
import { PRO_API } from "../app-api";

@Injectable()
export class EventoService {

    constructor(private http: HttpClient) {}

    listarEventos(): Observable<Evento[]> {
        return this.http.get<Evento[]>( `${PRO_API}/projeto-backend/rest/evento/listar`);
    }

    listarEventosRandom(): Observable<Evento> {
        return this.http.get<Evento>(`${PRO_API}/projeto-backend/rest/evento/listarRandom`);
    }

    listarEventoPorId(id: number): Observable<Evento> {
        console.log("dentro da função id: " + id);
        console.log(`${PRO_API}/projeto-backend/rest/evento/eventos/${id}`);
        return this.http.get<Evento>(`${PRO_API}/projeto-backend/rest/evento/eventos/${id}`);
    }

    adicionarEvento(evento: Evento) {
        return this.http.post(`${PRO_API}/projeto-backend/rest/evento/`, evento);
    }


}   