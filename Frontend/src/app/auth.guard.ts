import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRoles = route.data['roles'] as Array<string>; // Ahora es un array
    const userRole = this.authService.getRole(); // Obtiene el rol actual del usuario
  
    if (userRole && expectedRoles.includes(userRole)) {
      return true; // Acceso permitido
    } else {
      this.router.navigate(['/']); // Redirige al inicio si no tiene permisos
      return false;
    }
  }
  
}
