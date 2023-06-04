import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-go-back-button',
  templateUrl: './go-back-button.component.html',
  styleUrls: ['./go-back-button.component.scss']
})
export class GoBackButtonComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  voltarTelaAnterior(): void {
    window.history.back();
  }

}
