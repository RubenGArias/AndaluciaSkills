import { Component } from '@angular/core';

@Component({
  selector: 'app-lista-competidores',
  imports: [],
  templateUrl: './lista-competidores.component.html',
  styleUrl: './lista-competidores.component.css'
})
export class ListaCompetidoresComponent {
  listaCompetidores: any[];
  constructor(){
    this.listaCompetidores = [
      {id:1,nombre: "Rubén", especialidad: "Informática"},
      {id:2,nombre: "BronJames", especialidad: "Sexo"},
      {id:3,nombre: "Alan Godoy", especialidad: "Futbol"}
    ]
  }
}
