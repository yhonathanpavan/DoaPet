import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pre-login-page',
  templateUrl: './pre-login-page.component.html',
  styleUrls: ['./pre-login-page.component.scss']
})
export class PreLoginPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  goToOng() {
    localStorage.setItem('userType', 'ong');
  }

  goToDonor() {
    localStorage.setItem('userType', 'donor');
  }

}
