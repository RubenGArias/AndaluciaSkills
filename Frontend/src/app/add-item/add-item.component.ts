import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ItemsService } from '../items.service';
import { PruebasService } from '../pruebas.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-item',
  imports: [CommonModule, FormsModule],
  templateUrl: './add-item.component.html',
  styleUrl: './add-item.component.css'
})
export class AddItemComponent implements OnInit{
  item = {
    descripcion: '',
    peso: null,
    gradosConsecucion: null,
    idPrueba: 0
  }

  message: string = '';

  constructor (private itemsService: ItemsService, private route: ActivatedRoute, private router: Router){}

  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.item.idPrueba = +params['idPrueba']; // Convierte el string a número
      console.log('idPrueba recibido:', this.item.idPrueba); // Verifica en la consola
    });
  }
  
  onSubmit(): void {
    if (!this.item.idPrueba || typeof this.item.idPrueba !== 'number') {
      alert('Error: idPrueba no es válido');
      return;
    }
  
    console.log('Enviando item:', this.item); // Verifica en la consola
    this.itemsService.addItem(this.item, this.item.idPrueba).subscribe({
      next: (response) => {
        this.message = 'Item agregado con éxito';
        this.router.navigate(['/miespecialidad']);
      },
      error: (err) => {
        console.error('Error al añadir el item:', err);
        this.message = 'Error al añadir el item';
      },
    });
  }

}
