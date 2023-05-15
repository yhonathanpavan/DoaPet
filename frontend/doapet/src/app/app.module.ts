import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Import Components
import { DarkOrangeButtonComponent } from './components/dark-orange-button/dark-orange-button.component';
import { LightOrangeButtonComponent } from './components/light-orange-button/light-orange-button.component';
import { MenuBarComponent } from './components/menu-bar/menu-bar.component';
import { InputInsideComponent } from './components/input-inside/input-inside.component';
import { InputTopComponent } from './components/input-top/input-top.component';
import { CardDonationsComponent } from './components/card-donations/card-donations.component';
import { PriorityComponent } from './components/priority/priority.component';
import { GoBackButtonComponent } from './components/go-back-button/go-back-button.component';

// Import Pages
import { ViewDonationsPageComponent } from './views/view-donations-page/view-donations-page.component';
import { IncludeProductPageComponent } from './views/include-product-page/include-product-page.component';
import { IncludeAssistancePageComponent } from './views/include-assistance-page/include-assistance-page.component';
import { IncludeRequestPageComponent } from './views/include-request-page/include-request-page.component';
import { LoginPageComponent } from './views/login-page/login-page.component';
import { PreLoginPageComponent } from './views/pre-login-page/pre-login-page.component';
import { RegisterPageComponent } from './views/register-page/register-page.component';
import { HomeDonorComponent } from './views/home-donor/home-donor.component';
import { HomeOngComponent } from './views/home-ong/home-ong.component';
import { PerfilPageComponent } from './views/perfil-page/perfil-page.component';
import { OngPerfilPageComponent } from './views/ong-perfil-page/ong-perfil-page.component';

import { OngService } from './services/ong.service';
import { ProductService } from './services/product.service';
import { AssistanceService } from './services/assistance.service';

@NgModule({
  declarations: [
    AppComponent,
    DarkOrangeButtonComponent,
    LightOrangeButtonComponent,
    MenuBarComponent,
    InputInsideComponent,
    InputTopComponent,
    CardDonationsComponent,
    PriorityComponent,
    GoBackButtonComponent,
    ViewDonationsPageComponent,
    IncludeProductPageComponent,
    IncludeAssistancePageComponent,
    IncludeRequestPageComponent,
    LoginPageComponent,
    PreLoginPageComponent,
    RegisterPageComponent,
    HomeDonorComponent,
    HomeOngComponent,
    PerfilPageComponent,
    OngPerfilPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    OngService,
    ProductService,
    AssistanceService
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
