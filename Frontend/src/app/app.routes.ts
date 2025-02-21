import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListaParticipantesComponent } from './lista-participantes/lista-participantes.component';
import { EspecialidadesComponent } from './especialidades/especialidades.component';
import { ExpertosComponent } from './expertos/expertos.component';
import { GanadoresComponent } from './ganadores/ganadores.component';
import { GestionaParticipantesComponent } from './gestiona-participantes/gestiona-participantes.component';
import { AuthGuard } from './auth.guard';
export const routes: Routes = [
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'inicio', component: ListaParticipantesComponent, pathMatch: 'full'},
  { path: 'especialidades', 
    component: EspecialidadesComponent, 
    canActivate: [AuthGuard],//Para que solo los usuarios autenticados puedan acceder
    data: { role: 'ROLE_ADMIN'}//Para que solo los admin puedan entrar
  },
  { 
    path: 'expertos', 
    component: ExpertosComponent, 
    canActivate: [AuthGuard], 
    data: { role: 'ROLE_ADMIN' } 
  },  
  { path: 'ganadores', 
    component: GanadoresComponent, 
    canActivate: [AuthGuard],
    data: { role: 'ROLE_ADMIN' }
  },
  { path: 'participantes', 
    component: GestionaParticipantesComponent, 
    canActivate: [AuthGuard],
    data: { role: 'ROLE_EXPERTO' }
  },
  { path: '**', redirectTo: 'inicio' }
];
