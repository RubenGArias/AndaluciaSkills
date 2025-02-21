import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth'; 
  private tokenSubject = new BehaviorSubject<string | null>(null);
  private userSubject = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const body = { username, password }; // Crea el cuerpo de la petición
    return this.http.post(`${this.apiUrl}/login`, body); // Envía la petición POST
  }

  saveToken(token: string | null): void {
    if (token) {
      // Guarda el token y actualiza los Subjects
      sessionStorage.setItem('token', token);
      this.tokenSubject.next(token);
  
      try {
        const decodedToken: any = jwtDecode(token); // Decodifica el token
        console.log('Token decodificado:', decodedToken);
  
        this.userSubject.next({
          username: decodedToken.sub, // Asumiendo que 'sub' es el username
          role: decodedToken.role
        });
      } catch (error) {
        console.error('Error al decodificar el token:', error);
        this.userSubject.next(null);
      }
  
    } else {
      // Elimina el token al cerrar sesión
      sessionStorage.removeItem('token');
      this.tokenSubject.next(null);
      this.userSubject.next(null);
    }
  }
  

  //Para saber el rol del usuario desde el token en sessionStorage
  getRole(): string | null{
    const token = sessionStorage.getItem('token');
    if (token){
      const decodedToken: any = jwtDecode(token);
      return decodedToken.role || null;
    }
    return null;
  }

  // Expone el userSubject como observable
  getUser(): Observable<any> {
    return this.userSubject.asObservable();
  }

  // Verifica si el usuario está logeado
  isLoggedIn(): boolean {
    return !!sessionStorage.getItem('token');
  }



}