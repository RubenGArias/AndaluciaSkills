import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipantesService {
  private apiUrl = 'http://localhost:8080/api/participantes'

  constructor(private http: HttpClient) { }

  getParticipantes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
  }
}
