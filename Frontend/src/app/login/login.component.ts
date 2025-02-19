import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService) {}

  login() {
    console.log('Datos enviados:', this.username, this.password); // ✅ Depuración
  
    this.authService.login(this.username, this.password)
      .subscribe({
        next: response => {
          console.log('Token recibido:', response.token);
          localStorage.setItem('token', response.token);
        },
        error: error => {
          console.error('Error en login:', error);
          this.errorMessage = 'Usuario o contraseña incorrectos';
        }
      });
  }
  

  onSubmit() {
    this.login();
  }
  
  
}
