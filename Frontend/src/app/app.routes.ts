import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ListaParticipantesComponent } from './lista-participantes/lista-participantes.component';
import { EspecialidadesComponent } from './especialidades/especialidades.component';
import { ExpertosComponent } from './expertos/expertos.component';
import { GanadoresComponent } from './ganadores/ganadores.component';
import { GestionaParticipantesComponent } from './gestiona-participantes/gestiona-participantes.component';
import { AuthGuard } from './auth.guard';
import { AddParticipanteComponent } from './add-participante/add-participante.component';
import { AddEspecialidadComponent } from './add-especialidad/add-especialidad.component';
import { AddExpertoComponent } from './add-experto/add-experto.component';
import { ListaAlumnosComponent } from './lista-alumnos/lista-alumnos.component';
import { MiEspecialidadComponent } from './mi-especialidad/mi-especialidad.component';
import { AddPruebaComponent } from './add-prueba/add-prueba.component';
import { AddItemComponent } from './add-item/add-item.component';
import { EvaluarParticipanteComponent } from './evaluar-participante/evaluar-participante.component';
export const routes: Routes = [
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
  { path: 'inicio', component: ListaParticipantesComponent, pathMatch: 'full'},
  { path: 'especialidades', 
    component: EspecialidadesComponent, 
    canActivate: [AuthGuard],//Para que solo los usuarios autenticados puedan acceder
    data: { roles: ['ROLE_ADMIN', 'ROLE_EXPERTO']}//Para que solo los admin puedan entrar
  },
  { 
    path: 'expertos', 
    component: ExpertosComponent, 
    canActivate: [AuthGuard], 
    data: { roles: ['ROLE_ADMIN'] } 
  },  
  { path: 'ganadores', 
    component: GanadoresComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_ADMIN'] }
  },
  { path: 'participantes', 
    component: GestionaParticipantesComponent, 
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO'] }
  },
  {
    path: 'add-participante', 
    component: AddParticipanteComponent,
    canActivate:[AuthGuard],
    data: { roles: ['ROLE_EXPERTO']}
  },
  {
    path: 'add-especialidad',
    component: AddEspecialidadComponent,
    canActivate:[AuthGuard],
    data: { roles: ['ROLE_ADMIN']}
  },
  {
    path: 'add-experto',
    component: AddExpertoComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_ADMIN']}
  },
  {
    path: 'alumnos',
    component: ListaAlumnosComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO']}
  },
  {
    path: 'miespecialidad',
    component: MiEspecialidadComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO']},

  },
  {
    path: 'addprueba',
    component: AddPruebaComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO']}
  },
  {
    path: 'additem',
    component: AddItemComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO']}
  },
  {
    path: 'evaluar/:idParticipante',
    component: EvaluarParticipanteComponent,
    canActivate: [AuthGuard],
    data: { roles: ['ROLE_EXPERTO']}
  },
  { path: '**', redirectTo: 'inicio' }
];
