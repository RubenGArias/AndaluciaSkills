import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EvaluacionServiceService {
  private apiUrl = 'http://localhost:8080/evaluaciones';


  constructor(private http: HttpClient) { }

  getPruebasByEspecialidad(idEspecialidad: number): Observable<any>{
    return this.http.get(this.apiUrl + `/pruebas?idEspecialidad=${idEspecialidad}`);
  }

  getItemsByPrueba(idPrueba: number): Observable<any>{
    return this.http.get(this.apiUrl + `/items?idPrueba=${idPrueba}`);
  }

  getEvaluacionByParticipantes(idParticipante: number): Observable<any>{
    return this.http.get(this.apiUrl + `/participante/${idParticipante}`);
  }

  saveEvaluacion(evaluacion: any): Observable<any> {
    return this.http.post(this.apiUrl + `/save`, evaluacion);
  }
}
