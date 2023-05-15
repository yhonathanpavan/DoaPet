import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PreLoginPageComponent } from './views/pre-login-page/pre-login-page.component';
import { LoginPageComponent } from './views/login-page/login-page.component';
import { RegisterPageComponent } from './views/register-page/register-page.component';
import { OngPerfilPageComponent } from './views/ong-perfil-page/ong-perfil-page.component';
import { PerfilPageComponent } from './views/perfil-page/perfil-page.component';
import { IncludeProductPageComponent } from './views/include-product-page/include-product-page.component';
import { IncludeAssistancePageComponent } from './views/include-assistance-page/include-assistance-page.component';
import { ViewDonationsPageComponent } from './views/view-donations-page/view-donations-page.component';

const routes: Routes = [
  { path: '', component: PreLoginPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'ong_perfil', component: OngPerfilPageComponent },
  { path: 'donor_perfil', component: PerfilPageComponent },
  { path: 'include_product', component: IncludeProductPageComponent },
  { path: 'include_assistance', component: IncludeAssistancePageComponent },
  { path: 'view_donations', component: ViewDonationsPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
