import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.scss']
})
export class PerfilPageComponent implements OnInit {

  nameLabel: string = 'Nome';
  nameType: string = 'text';
  nameWidth: string = '100%';
  nameHeight: string = '40px';
  nameFont: string = ''

  nameStyle = {'width': this.nameWidth, 'height': this.nameHeight, 'fontSize': this.nameFont}

  emailLabel: string = 'E-mail';
  emailType: string = 'email';
  emailWidth: string = '600px';
  emailHeight: string = '40px';
  emailFont: string = ''

  emailStyle = {'width': this.emailWidth, 'height': this.emailHeight, 'fontSize': this.emailFont}

  passLabel: string = 'Senha';
  passType: string = 'password';
  passWidth: string = '400px';
  passHeight: string = '40px';
  passFont: string = ''

  passStyle = {'width': this.passWidth, 'height': this.passHeight, 'fontSize': this.passFont}

  phoneLabel: string = 'Telefone';
  phoneType: string = 'tel';
  phoneWidth: string = '600px';
  phoneHeight: string = '40px';
  phoneFont: string = ''

  phoneStyle = {'width': this.phoneWidth, 'height': this.phoneHeight, 'fontSize': this.phoneFont}

  bornLabel: string = 'Data de Nascimento';
  bornType: string = 'date';
  bornWidth: string = '400px';
  bornHeight: string = '40px';
  bornFont: string = ''

  bornStyle = {'width': this.bornWidth, 'height': this.bornHeight, 'fontSize': this.bornFont}

  constructor() { }

  ngOnInit() {
  }

}
