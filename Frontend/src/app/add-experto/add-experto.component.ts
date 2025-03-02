import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ExpertosService } from '../expertos.service';
import { EspecialidadesService } from '../especialidades.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-experto',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-experto.component.html',
  styleUrl: './add-experto.component.css'
})
export class AddExpertoComponent implements OnInit{
  experto = {
    role: 'ROLE_EXPERTO',
    username: '',
    password: '',
    idEspecialidad: null,
    dni: '',
    nombre: '',
    apellidos: ''
  }

  especialidades: any[] = [];
  message: string = '';

  constructor(private expertosService: ExpertosService, private especialidadesService: EspecialidadesService, private router: Router){}

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
    this.expertosService.addExperto(this.experto).subscribe({
      next: respone => {
        this.message = 'Experto creado con éxito';
        this.router.navigate(['/expertos']);
      },
      error: err => {
        console.log('Error al añadir el experto:', err);
        this.message = 'Error al añadir el experto';
      }
    })
  }

}
