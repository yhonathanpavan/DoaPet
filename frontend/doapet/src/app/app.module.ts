import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// Import Components
import { DarkOrangeButtonComponent } from './components/dark-orange-button/dark-orange-button.component';
import { LightOrangeButtonComponent } from './components/light-orange-button/light-orange-button.component';
import { MenuBarComponent } from './components/menu-bar/menu-bar.component';
import { InputInsideComponent } from './components/input-inside/input-inside.component';
import { InputTopComponent } from './components/input-top/input-top.component';

@NgModule({
  declarations: [
    AppComponent,
    DarkOrangeButtonComponent,
    LightOrangeButtonComponent,
    MenuBarComponent,
    InputInsideComponent,
    InputTopComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
