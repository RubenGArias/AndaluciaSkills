import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { EspecialidadesService } from '../especialidades.service';
import { Router } from '@angular/router';
import { ExpertosService } from '../expertos.service';


@Component({
  selector: 'app-especialidades',
  imports: [CommonModule],
  templateUrl: './especialidades.component.html',
  styleUrl: './especialidades.component.css'
})
export class EspecialidadesComponent implements OnInit{
  especialidades: any[] = [];
  errorMessage: string = '';
  esExperto: boolean = false;
  esAdmin: boolean = false;
  esEspecialidad: boolean = false;
  especialidadUser: string = '';

  constructor(private especialidadesService: EspecialidadesService, private authService: AuthService, private router: Router, private expertosService: ExpertosService){}

  ngOnInit(): void {
    this.verificarRol();
    this.cargarEspecialidades();   
  }

  verificarRol(){
    const role = this.authService.getRole();
    this.esExperto = role === 'ROLE_EXPERTO';
    this.esAdmin = role === 'ROLE_ADMIN';
  }



  cargarEspecialidades(){
    this.especialidadesService.getEspecialidades().subscribe({
      next: data => {
        this.especialidades = data;
      },
      error: err => {
        console.error('Error al cargar las especialidades:', err);
        this.errorMessage = 'Error al cargar las especialidades';
      }
    })
  }



  navigateTo(path: string){
    this.router.navigate([path]);
  }

}
