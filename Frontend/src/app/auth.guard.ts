import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRole = route.data['role']; // Obtiene el rol esperado desde la ruta
    const userRole = this.authService.getRole(); // Obtiene el rol actual del usuario

    if (userRole === expectedRole) {
      return true; // ✅ Permite el acceso
    } else {
      this.router.navigate(['/']); // 🚫 Redirige al inicio si no tiene permisos
      return false;
    }
  }
}
