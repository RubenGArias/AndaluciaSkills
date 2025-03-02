import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EspecialidadesService } from '../especialidades.service';
import { AuthService } from '../auth.service';
import { PruebasService } from '../pruebas.service';
import { ItemsService } from '../items.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mi-especialidad',
  imports: [CommonModule],
  templateUrl: './mi-especialidad.component.html',
  styleUrl: './mi-especialidad.component.css'
})
export class MiEspecialidadComponent implements OnInit {
  especialidad: any = { pruebas: [] };
  pruebas: any[] = [];
  itemsPorPrueba: { [key: number]: any[] } = {}; // Almacena los ítems de cada prueba
  errorMessage: string = '';

  constructor(private especialidadesService: EspecialidadesService, 
              private pruebasService: PruebasService,
              private itemsService: ItemsService,
              private router: Router,
              private authService: AuthService) {}

  ngOnInit(): void {
    this.cargarDetallesEspecialidad();
    this.cargarPruebasEspecialidad(); // cargarPruebas ahora llama a cargarItemsPrueba cuando termina
    console.log('Pruebas en ngOnInit:', this.pruebas); // 🔍 Ver si está vacío al iniciar

  }

  cargarDetallesEspecialidad(): void {
    const idEspecialidad = this.authService.getIdEspecialidad();
    if (idEspecialidad) {
      this.especialidadesService.getEspecialidadById(idEspecialidad).subscribe({
        next: data => {
          this.especialidad = data;
        },
        error: err => {
          console.error('Error:', err);
          this.errorMessage = 'Error al cargar la especialidad';
        }
      });
    }
  }

  cargarPruebasEspecialidad(){
    const idEspecialidad = this.authService.getIdEspecialidad();
    if(idEspecialidad){
        this.pruebasService.getPruebasPorEspecialidad(idEspecialidad).subscribe({
            next: data => {
                console.log('Pruebas recibidas:', data); // 🟢 Verifica cuántas pruebas llegan realmente
                this.pruebas = data;
                console.log('Pruebas después de asignar:', this.pruebas);
                this.cargarItemsPrueba();
            },
            error: err => {
                console.error('Error:', err);
                this.errorMessage = 'Error al cargar las pruebas';
            }
        });
    }
}

cargarItemsPrueba() {
  if (!this.pruebas || this.pruebas.length === 0) {
      console.warn("No hay pruebas para cargar ítems.");
      return;
  }

  this.pruebas.forEach((prueba: any) => {
      if (!prueba.id) {
          console.error("La prueba no tiene un id válido:", prueba);
          return;
      }

      this.itemsService.getItemsByPrueba(prueba.id).subscribe({
          next: items => {
              this.itemsPorPrueba[prueba.id] = items;
              console.log(`Ítems de la prueba ${prueba.id}:`, this.itemsPorPrueba[prueba.id]);
          }, 
          error: err => {
              console.error(`Error al cargar ítems para la prueba ${prueba.id}:`, err);
          }
      });
  });
}


navigateToAddItem(idPrueba: number): void {
  // Navega al componente AddItemComponent y pasa el idPrueba como parámetro
  this.router.navigate(['/additem'], { queryParams: { idPrueba } });
}

navigateTo(path: string){
  this.router.navigate([path]);
}

}
