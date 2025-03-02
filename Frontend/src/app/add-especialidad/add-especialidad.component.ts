import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { EspecialidadesService } from '../especialidades.service';

@Component({
  selector: 'app-add-especialidad',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-especialidad.component.html',
  styleUrl: './add-especialidad.component.css'
})
export class AddEspecialidadComponent {
  especialidad = {
    nombre : '',
    codigo : ''
  }

  message: string = '';

  constructor(private especialidadesService: EspecialidadesService, private router: Router) { }

  onSubmit(){
    this.especialidadesService.addEspecialidad(this.especialidad).subscribe({
      next: response => {
        this.message = 'Especialidad agragada con exito';
        this.router.navigate(['/especialidades']);
      },
      error: err => {
        console.log('Error al añadir la Especialidad:', err);
        this.message = 'Error al añadir la Especialidad';
      }
    })
  }

}
