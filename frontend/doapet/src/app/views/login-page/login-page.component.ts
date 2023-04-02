import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  darkBtnIcon: string = '../../assets/icons/icon-cat.svg';
  darkBtnText: string = 'Login';
  darkBtnWidth: string = '190px';
  darkBtnHeight: string = '45px';
  darkBtnFontSize: string = '16px';

  darkBtnStyle = {'width': this.darkBtnWidth, 'height': this.darkBtnHeight, 'font-size': this.darkBtnFontSize};

  lightBtnIcon: string = '../../assets/icons/icon-dog.svg';
  lightBtnText: string = 'Cadastrar';
  lightBtnWidth: string = '190px';
  lightBtnHeight: string = '45px';
  lightBtnFontSize: string = '16px';

  lightBtnStyle = {'width': this.lightBtnWidth, 'height': this.lightBtnHeight, 'font-size': this.lightBtnFontSize};

  constructor() { }

  ngOnInit() {
  }

}
