import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent implements OnInit {

  inputHeight: string = '40px'
  inputFont: string = '16px'

  nameLabel: string = 'Nome';
  nameType: string = 'text';
  nameWidth: string = '100%';
  nameStyle = {'width': this.nameWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  cnpjLabel: string = 'CNPJ';
  cnpjType: string = 'text';
  cnpjWidth: string = '100%';
  cnpjStyle = {'width': this.nameWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  emailLabel: string = 'E-mail';
  emailType: string = 'email';
  emailWidth: string = '100%';
  emailStyle = {'width': this.emailWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  passLabel: string = 'Senha';
  passType: string = 'password';
  passWidth: string = '';
  passStyle = {'width': this.passWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  ownerLabel: string = 'Presidente';
  ownerType: string = 'text';
  ownerWidth: string = '';
  ownerStyle = {'width': this.ownerWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  phoneLabel: string = 'Telefone';
  phoneType: string = 'tel';
  phoneWidth: string = '';
  phoneStyle = {'width': this.passWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  adressLabel: string = 'Endereço';
  adressType: string = 'text';
  adressWidth: string = '';
  adressStyle = {'width': this.adressWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  bairroLabel: string = 'Bairro';
  bairroType: string = 'text';
  bairroWidth: string = '';
  bairroStyle = {'width': this.bairroWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  cityLabel: string = 'Cidade';
  cityType: string = 'text';
  cityWidth: string = '';
  cityStyle = {'width': this.cityWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  codeLabel: string = 'CEP';
  codeType: string = 'text';
  codeWidth: string = '';
  codeStyle = {'width': this.codeWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  pixLabel: string = 'Chave PIX';
  pixType: string = 'text';
  pixWidth: string = '100%';
  pixStyle = {'width': this.pixWidth, 'height': this.inputHeight, 'fontSize': this.inputFont};

  userType: string = 'donor'

  constructor() { }

  ngOnInit() {
  }

  

}
