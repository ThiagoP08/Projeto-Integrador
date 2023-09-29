import { Injectable } from "@angular/core";
import { HttpClient} from "@angular/common/http"
import { Observable } from "rxjs";
import { Categoria } from "../model/categoria-model";
import { PRO_API } from "../app-api";


@Injectable()
export class CategoriaService {

    constructor(private http: HttpClient) {}

    listarCategorias(): Observable<Categoria[]> {        
        console.log(`${PRO_API}/projeto-backend/rest/categoria/listar`);
        return this.http.get<Categoria[]>(`${PRO_API}/projeto-backend/rest/categoria/listar`);
    }

    
    listarCategoriaPorId(id: number): Observable<Categoria> {
        console.log("dentro da função id: " + id);
        console.log(`${PRO_API}/projeto-backend/rest/categoria/categorias/${id}`);
        return this.http.get<Categoria>(`${PRO_API}/projeto-backend/rest/categoria/categorias/${id}`);
    }

}