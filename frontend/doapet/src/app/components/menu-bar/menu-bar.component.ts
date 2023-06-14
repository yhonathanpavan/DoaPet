import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.scss']
})
export class MenuBarComponent implements OnInit {

  userType: string | null = '';
  link = '';

  constructor(private router: Router) { }

  ngOnInit() {
    this.userType = localStorage.getItem('userType');
    this.goToPerfil();
  }

  goToPerfil() {
    if(this.userType === 'donor') {
      this.link = '/donor_perfil'
    } else {
      this.link = '/ong_perfil'
    }
  }

}
