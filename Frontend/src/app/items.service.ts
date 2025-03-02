import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  private apiUrl = 'http://localhost:8080/items'

  constructor(private http: HttpClient) { }

  getItemsByPrueba(idPrueba: number): Observable<any>{
    return this.http.get(this.apiUrl + `/prueba/${idPrueba}`);
  }

  addItem(item: any, idPrueba: number): Observable<any> {
    const url = `http://localhost:8080/items/add?idPrueba=${idPrueba}`;
    return this.http.post(url, item);
  }
}
