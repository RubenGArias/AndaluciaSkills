import { Component, OnInit } from '@angular/core';
import { ParticipantesService } from '../participantes.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EspecialidadesService } from '../especialidades.service';

@Component({
  selector: 'app-add-participante',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-participante.component.html',
  styleUrl: './add-participante.component.css'
})
export class AddParticipanteComponent implements OnInit{
  participante = {
    nombre: '',
    apellidos: '',
    centro: '',
    idEspecialidad: null
  }

  especialidades: any[] = [];
  message: string = '';

  constructor (private participantesService: ParticipantesService, private especialidadesService: EspecialidadesService,private router: Router){}

  ngOnInit(): void {
      this.cargarEspecialidades();
  }

  cargarEspecialidades() {
    this.especialidadesService.getEspecialidades().subscribe({
      next: (data) => {
        this.especialidades = data;
      },
      error: (err) => {
        console.log('Error al cargar especialidades:', err);
      }
    });
  }

  onSubmit(){
    this.participantesService.addParticipante(this.participante).subscribe({
      next: response => {
        this.message = 'Participante agregado con éxito';
        this.router.navigate(['/inicio']);
      },
      error: err => {
        console.log('Error al añadir el participante:', err);
        this.message = 'Error al añadir participante';
      }
    });
  }


}
