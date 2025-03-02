import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PruebasService } from '../pruebas.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-prueba',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-prueba.component.html',
  styleUrl: './add-prueba.component.css'
})
export class AddPruebaComponent {
  enunciadoPdf: File | null = null;
  puntuacionMaxima: number = 0;
  idEspecialidad: number | null = null;
  message: string = '';

  constructor(
    private pruebasService: PruebasService,
    private authService: AuthService,
    private router: Router
  ) {
    // Obtén el idEspecialidad del usuario loggeado
    this.idEspecialidad = this.authService.getIdEspecialidad();
    if (this.idEspecialidad === null) {
      alert('No se pudo obtener el idEspecialidad del usuario.');
    }
  }

  onFileSelected(event: any): void {
    this.enunciadoPdf = event.target.files[0];
  }

  onSubmit(): void {
    if (!this.enunciadoPdf) {
      this.message = 'Por favor, elige un archivo'
      return;
    }

    if (this.idEspecialidad === null) {
      this.message = 'No se puede obtener el id del Usuario'
      return;
    }

    const formData = new FormData();
    formData.append('enunciadoPdf', this.enunciadoPdf);
    formData.append('puntuacionMaxima', this.puntuacionMaxima.toString());
    formData.append('idEspecialidad', this.idEspecialidad.toString());

    this.pruebasService.crearPrueba(formData).subscribe(
      (response) => {
        this.message = 'Prueba creada con éxito';
        this.router.navigate(['/miespecialidad']);
      },
      (error) => {
        console.error('Error al crear la prueba:', error);
        this.message = 'Error al crear la prueba';
      }
    );
  }

}
