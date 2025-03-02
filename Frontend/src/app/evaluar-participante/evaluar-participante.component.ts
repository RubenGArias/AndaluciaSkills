import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EvaluacionServiceService } from '../evaluacion-service.service';
import { AuthService } from '../auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms'; // Importa NgForm

@Component({
  selector: 'app-evaluar-participante',
  imports: [CommonModule, FormsModule],
  templateUrl: './evaluar-participante.component.html',
  styleUrl: './evaluar-participante.component.css'
})
export class EvaluarParticipanteComponent implements OnInit {
  idParticipante: number;
  pruebas: any[] = [];
  itemsPorPrueba: { [key: number]: any[] } = {};
  evaluacionAnterior: any = null;
  showSuccessMessage = false; // Para mostrar mensaje de éxito

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private evaluacionService: EvaluacionServiceService,
    private authService: AuthService
  ) {
    this.idParticipante = +this.route.snapshot.params['idParticipante']; // Obtiene el id del participante desde la URL
  }

  ngOnInit(): void {
    const idEspecialidad = this.authService.getIdEspecialidad(); // Obtiene el id de la especialidad del usuario loggeado
    if (idEspecialidad === null) {
      alert('Error: No se pudo obtener la especialidad del usuario.');
      return;
    }
    // Obtiene las pruebas de la especialidad
    this.evaluacionService.getPruebasByEspecialidad(idEspecialidad).subscribe({
      next: (pruebas) => {
        this.pruebas = pruebas;
        this.loadItemsForPruebas();
      },
      error: (err) => {
        console.error('Error al obtener las pruebas:', err);
      }
    });

    // Obtiene la evaluación anterior del participante si existe
    this.evaluacionService.getEvaluacionByParticipantes(this.idParticipante).subscribe({
      next: (evaluacion) => {
        this.evaluacionAnterior = evaluacion;
      },
      error: (err) => {
        console.error('Error al obtener la evaluación anterior:', err);
      }
    });
  }

  loadItemsForPruebas(): void {
    this.pruebas.forEach((prueba) => {
      this.evaluacionService.getItemsByPrueba(prueba.id).subscribe({
        next: (items: any[]) => { // Define el tipo de 'items' como any[] si no tienes una interfaz
          this.itemsPorPrueba[prueba.id] = items.map((item: { id: number; gradosConsecucion: number }) => ({
            ...item,
            valoracion: this.getValoracionAnterior(item.id) || null, // Inicializa con valoración anterior o null
          }));
        },
        error: (err) => {
          console.error('Error al obtener los ítems:', err);
        },
      });
    });
  }

  getValoracionAnterior(idItem: number): number | null {
    if (!this.evaluacionAnterior) return null;
    const itemEvaluado = this.evaluacionAnterior.items.find(
      (item: { idItem: number; valoracion: number }) => item.idItem === idItem
    );
    return itemEvaluado ? itemEvaluado.valoracion : null;
  }

  onSubmit(form: NgForm): void {
    if (form.invalid) {
      alert('Por favor, selecciona una valoración para todos los ítems.');
      return;
    }
  
    // Obtener el usuario actual desde el AuthService
    this.authService.getUser().subscribe((user) => {
      if (!user) {
        alert('Error: No se pudo obtener el usuario.');
        return;
      }
  
      // Obtener el idUser desde el usuario
      const idUser = user.idUsuario;
      if (!idUser) {
        alert('Error: No se pudo obtener el ID del usuario.');
        return;
      }
  
      // Filtrar las pruebas que tienen ítems
      const evaluaciones = this.pruebas
        .filter((prueba) => this.itemsPorPrueba[prueba.id]?.length > 0) // Filtra pruebas con ítems
        .map((prueba) => ({
          idPrueba: prueba.id, // ID de la prueba
          items: this.itemsPorPrueba[prueba.id].map((item: { id: number; valoracion: number }) => ({
            idItem: item.id,
            valoracion: item.valoracion, // Valor seleccionado por el usuario
          })),
        }));
  
      // Crear el objeto que se enviará al backend
      const evaluacion = {
        idParticipante: this.idParticipante, // ID del participante
        idUser: idUser,                     // ID del usuario
        evaluaciones: evaluaciones,         // Lista de evaluaciones filtradas
      };
  
      console.log('Datos enviados al backend:', evaluacion); // Depuración
  
      // Enviar el objeto al backend
      this.evaluacionService.saveEvaluacion(evaluacion).subscribe({
        next: (response) => {
          this.showSuccessMessage = true;
          setTimeout(() => (this.showSuccessMessage = false), 3000); // Ocultar mensaje después de 3 segundos
        },
        error: (err) => {
          console.error('Error al guardar la evaluación:', err);
          alert('Error al guardar la evaluación');
        },
      });
    });
  }

  getGradosConsecucion(gradosConsecucion: number): number[] {
    return Array.from({ length: gradosConsecucion }, (_, i) => i + 1);
  }
}