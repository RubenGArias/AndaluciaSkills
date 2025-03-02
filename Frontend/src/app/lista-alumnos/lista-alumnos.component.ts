import { Component, OnInit } from '@angular/core';
import { ParticipantesService } from '../participantes.service';
import { AuthService } from '../auth.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-alumnos',
  imports: [CommonModule],
  templateUrl: './lista-alumnos.component.html',
  styleUrl: './lista-alumnos.component.css'
})
export class ListaAlumnosComponent implements OnInit{
  participantes: any[] = [];
  errorMessage: string = '';
  idEspecialidad: number | null = null;

  constructor(private participantesService: ParticipantesService, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.obtenerIdEspecialidad();
  }

  obtenerIdEspecialidad(): void {
    this.authService.getUser().subscribe({
      next: user => {
        if (user && user.idEspecialidad) {
          this.idEspecialidad = user.idEspecialidad;
          this.cargarParticipantes();
        }
      },
      error: err => {
        console.error('Error al obtener la especialidad:', err);
        this.errorMessage = 'Error al obtener la especialidad del usuario';
      }
    });
  }

  cargarParticipantes(): void {
    if (this.idEspecialidad) {
      this.participantesService.getParticipantesByEspecialidad(this.idEspecialidad).subscribe({
        next: data => {
          this.participantes = data;
        },
        error: err => {
          console.error('Error al cargar los participantes:', err);
          this.errorMessage = 'Error al cargar los participantes';
        }
      });
    }
  }

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }

  navigateToEvaluar(idParticipante: number): void {
    this.router.navigate(['/evaluar', idParticipante]); // Navega a la ruta de evaluación con el id del participante
  }


}
