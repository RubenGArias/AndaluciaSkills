import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  token: string;
  perfil: string;
  logeado: boolean;
  usuario: any;

  constructor() {
    this.token = '';
    this.perfil = '';
    this.logeado = false;
    this.usuario = {};
  }

  almacenar(){
    var objeto: any;
    objeto = {
      token: this.token,
      perfil: this.perfil,
      logieado: this.logeado,
      usuario: this.usuario
    }
    localStorage.setItem("LOGIN", JSON.stringify(objeto));
  }

  recuperar(){
    var cadena: string;
    cadena = localStorage.getItem("LOGIN")||"";
    if (cadena != "") {
      var objeto = JSON.parse(cadena);
      this.token = objeto.token;
      this.perfil = objeto.perfil;
      this.logeado = objeto.logeado;
      this.usuario = objeto.usuario;
    } else {
      this.logeado = false;
      this.token = '';
      this.perfil = '';
      this.usuario = {};
    }
  }


  machacar(){
    localStorage.removeItem("LOGIN");
  }
}
