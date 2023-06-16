import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

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

  userType: string | null = '';

  email: string = '';
  password: string = '';

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.userType = localStorage.getItem('userType');
  }

  goToRegister() {
    this.router.navigate(['/register']);
  };

  goToHome() {
    if(this.userType === 'donor') {
      this.router.navigate(['/home_donor'])
    } else {
      this.router.navigate(['/home_ong'])
    }
  }

  login() {
    this.authService.login(this.email, this.password).subscribe(
      (response) => {
        console.log('Login bem-sucedido', response);
        localStorage.setItem('userId', response.authenticatedUserId)
        console.log('userID', localStorage.getItem('userId'));
        localStorage.setItem('token', response.token)
        this.goToHome();
      },
      (error) => {
        console.log('Erro no login', error)
      }
    )
  };

  logout() {
    this.authService.logout().subscribe(
      (response) => {
        console.log('Logout bem-sucedido', response);
      },
      (error) => {
        console.log('Erro no logout', error);
      }
    )
  };

}
