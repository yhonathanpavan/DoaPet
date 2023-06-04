import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-ong',
  templateUrl: './home-ong.component.html',
  styleUrls: ['./home-ong.component.scss']
})
export class HomeOngComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  goToOrder() {
    this.router.navigate(['/include_request']);
  }

  goToProduct() {
    this.router.navigate(['/include_product']);
  }

  goToAssistance() {
    this.router.navigate(['/include_assistance']);
  }

  goToHistoric() {
    this.router.navigate(['/historic']);
  }

}
