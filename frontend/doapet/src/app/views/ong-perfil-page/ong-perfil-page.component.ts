import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ong-perfil-page',
  templateUrl: './ong-perfil-page.component.html',
  styleUrls: ['./ong-perfil-page.component.scss']
})
export class OngPerfilPageComponent implements OnInit {

  nameLabel: string = 'Nome';
  nameType: string = 'text';
  nameWidth: string = '100%';
  nameHeight: string = '40px';
  nameFont: string = ''

  nameStyle = {'width': this.nameWidth, 'height': this.nameHeight, 'fontSize': this.nameFont}

  cpfLabel: string = 'CPF';
  cpfType: string = 'text';
  cpfWidth: string = '100%';
  cpfHeight: string = '40px';
  cpfFont: string = ''

  cpfStyle = {'width': this.cpfWidth, 'height': this.cpfHeight, 'fontSize': this.cpfFont}

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

  presidentLabel: string = 'Presidente';
  presidentType: string = 'text';
  presidentWidth: string = '600px';
  presidentHeight: string = '40px';
  presidentFont: string = ''

  presidentStyle = {'width': this.presidentWidth, 'height': this.presidentHeight, 'fontSize': this.presidentFont}

  phoneLabel: string = 'Telefone';
  phoneType: string = 'tel';
  phoneWidth: string = '400px';
  phoneHeight: string = '40px';
  phoneFont: string = ''

  phoneStyle = {'width': this.phoneWidth, 'height': this.phoneHeight, 'fontSize': this.phoneFont}

  adressLabel: string = 'Endereço';
  adressType: string = 'text';
  adressWidth: string = '600px';
  adressHeight: string = '40px';
  adressFont: string = ''

  adressStyle = {'width': this.adressWidth, 'height': this.adressHeight, 'fontSize': this.adressFont}

  neighborLabel: string = 'Bairro';
  neighborType: string = 'tel';
  neighborWidth: string = '400px';
  neighborHeight: string = '40px';
  neighborFont: string = ''

  neighborStyle = {'width': this.neighborWidth, 'height': this.neighborHeight, 'fontSize': this.neighborFont}

  cityLabel: string = 'Cidade';
  cityType: string = 'text';
  cityWidth: string = '600px';
  cityHeight: string = '40px';
  cityFont: string = ''

  cityStyle = {'width': this.cityWidth, 'height': this.cityHeight, 'fontSize': this.cityFont}

  cepLabel: string = 'CEP';
  cepType: string = 'tel';
  cepWidth: string = '400px';
  cepHeight: string = '40px';
  cepFont: string = ''

  cepStyle = {'width': this.cepWidth, 'height': this.cepHeight, 'fontSize': this.cepFont}

  pixLabel: string = 'Chave Pix';
  pixType: string = 'tel';
  pixWidth: string = '100%';
  pixHeight: string = '40px';
  pixFont: string = ''

  pixStyle = {'width': this.pixWidth, 'height': this.pixHeight, 'fontSize': this.pixFont}


  constructor() { }

  ngOnInit() {
  }

}
