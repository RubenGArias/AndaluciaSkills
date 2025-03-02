import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ExpertosService } from '../expertos.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-expertos',
  imports: [CommonModule],
  templateUrl: './expertos.component.html',
  styleUrl: './expertos.component.css'
})
export class ExpertosComponent implements OnInit{
  expertos: any[] = [];
  errorMessage: string = '';
  esAdmin: boolean = false;

  constructor(private expertosService: ExpertosService, private authService: AuthService, private router: Router){}

  ngOnInit(): void {
      this.verificarRol();
      this.cargarExpertos();
  }

  verificarRol(){
    const role = this.authService.getRole();
    this.esAdmin = role === 'ROLE_ADMIN';
  }

  cargarExpertos(){
    this.expertosService.getExpertos().subscribe({
      next: data => {
        this.expertos = data;
      },
      error: err => {
        console.error('Error al cargar los Expertos:', err);
        this.errorMessage = 'Error al cargar los Expertos';
      }
    })
  }

  navigateTo(path: string){
    this.router.navigate([path]);
  }
  

}
