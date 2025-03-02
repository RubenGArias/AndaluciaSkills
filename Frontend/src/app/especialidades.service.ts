import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadesService {
  private apiUrl = 'http://localhost:8080/especialidades'

  constructor(private http: HttpClient) { }

  getEspecialidades(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  addEspecialidad(especialidad: any){
    return this.http.post(this.apiUrl, especialidad);
  }

  getEspecialidadById(id: number){
    return this.http.get(this.apiUrl + `/` + id);
  }
}
