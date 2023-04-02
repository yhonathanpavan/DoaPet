import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
    RegisterPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
