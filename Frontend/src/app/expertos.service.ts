import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpertosService {
  private apiUrl = 'http://localhost:8080/api/auth'

  constructor(private http:HttpClient) { }

  getExpertos(): Observable<any> {
    return this.http.get<any[]>(this.apiUrl + '/expertos');
  }

  addExperto(experto: any){
    return this.http.post(this.apiUrl + '/register', experto);
  }
}
