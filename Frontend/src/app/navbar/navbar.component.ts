import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit{
  logeado : boolean = false;
  role : string | null = null;
  username : string | null = null;


  constructor(private router: Router, private authService: AuthService){

  }

  ngOnInit() {

    this.authService.getUser().subscribe(user => {
      if (user) {
        this.logeado = true;
        this.username = user.username;
        this.role = user.role;
      } else {
        this.logeado = false;
        this.username = null;
        this.role = null;
      }
    });

      const token = sessionStorage.getItem('token');
      if ( token ){
        const decodedToken: any = JSON.parse(atob(token.split('.')[1]));//Decodifica el token
        this.authService.saveToken(token);
      }
  }

  logout(){
    this.authService.saveToken(null); // Limpia el estado global y sessionStorage
    this.router.navigate(['/login']);
  }

  login(){
    this.router.navigate(['/login']);
  }

  navigateTo(path: string){
    this.router.navigate([path]);
  }

  

}
