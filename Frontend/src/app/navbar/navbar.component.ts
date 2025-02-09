import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  logeado:boolean;
  perfil:string;
  nombre:string;
  constructor(){
    this.logeado = true;
    this.nombre = 'Rubén GA';
    this.perfil = 'experto';
  }


  logout(){
    this.logeado = false;
  }

  login(){
    this.logeado = true;
  }
}
