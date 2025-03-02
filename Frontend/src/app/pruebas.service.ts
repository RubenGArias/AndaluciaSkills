import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PruebasService {
  uploadFile(FormData: { new(form?: HTMLFormElement, submitter?: HTMLElement | null): FormData; prototype: FormData; }) {
    throw new Error('Method not implemented.');
  }
  private apiUrl = 'http://localhost:8080/pruebas'

  constructor(private http: HttpClient) { }

  getPruebasPorEspecialidad(idEspecialidad: number): Observable<any>{
    return this.http.get(this.apiUrl + `/especialidad/${idEspecialidad}`);
  }

  crearPrueba(formData: FormData): Observable<any> {
    return this.http.post(this.apiUrl + '/add', formData);
  }
}
