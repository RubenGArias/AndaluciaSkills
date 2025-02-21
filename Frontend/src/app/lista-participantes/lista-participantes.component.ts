import { Component, OnInit } from '@angular/core';
import { ParticipantesService } from '../participantes.service';
import { NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-lista-participantes',
  imports: [CommonModule],
  templateUrl: './lista-participantes.component.html',
  styleUrl: './lista-participantes.component.css'
})
export class ListaParticipantesComponent implements OnInit{
  participantes: any[] = [];
  errorMessage: string = '';
  esExperto: boolean = false;

  constructor(private participantesService: ParticipantesService, private authService: AuthService){}

  ngOnInit(): void {
    this.verificarRol();
    this.cargarParticipantes();
  }

  verificarRol(){
    const role = this.authService.getRole();
    this.esExperto = role === 'ROLE_EXPERTO';
  }

  cargarParticipantes(){
    this.participantesService.getParticipantes().subscribe({
      next: data => {
        this.participantes = data;
      },
      error: err => {
        console.error('Error al cargar los participantes:', err);
        this.errorMessage = 'Error al cargar los participantes';
      }
    })
  }
}
