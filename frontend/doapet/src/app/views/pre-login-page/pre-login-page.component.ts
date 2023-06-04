import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pre-login-page',
  templateUrl: './pre-login-page.component.html',
  styleUrls: ['./pre-login-page.component.scss']
})
export class PreLoginPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToOng() {
    localStorage.setItem('userType', 'ong');
    this.router.navigate(['/login'])
  }

  goToDonor() {
    localStorage.setItem('userType', 'donor');
    this.router.navigate(['/login'])
  }

}
