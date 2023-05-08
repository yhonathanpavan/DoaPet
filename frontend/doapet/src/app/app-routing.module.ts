import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PreLoginPageComponent } from './views/pre-login-page/pre-login-page.component';
import { LoginPageComponent } from './views/login-page/login-page.component';
import { RegisterPageComponent } from './views/register-page/register-page.component';
import { OngPerfilPageComponent } from './views/ong-perfil-page/ong-perfil-page.component';

const routes: Routes = [
  { path: '', component: PreLoginPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'ong_perfil', component: OngPerfilPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
