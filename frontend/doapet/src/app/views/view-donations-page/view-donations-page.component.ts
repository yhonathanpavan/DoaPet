import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DonationsModel } from 'src/app/mocks/donations.model';
import { Router } from '@angular/router';

import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-view-donations-page',
  templateUrl: './view-donations-page.component.html',
  styleUrls: ['./view-donations-page.component.scss']
})
export class ViewDonationsPageComponent implements OnInit {

  btnText: string = 'Ver Perfil';
  btnWidth: string = '150px';
  btnHeight: string = '50px';
  btnFont: string = '16px';

  buttonLightStyle = {'width': this.btnWidth, 'height': this.btnHeight, 'font-size': this.btnFont};

  savedOngId: any;

  listDonationsRequest = [];

  flagModal = false;

  order: any;
  variavelCompartilhada: boolean = false;

  userToken: any;

  constructor(
    private orderService: OrderService,
    private router: Router
  ) { }

  ngOnInit() {
    this.savedOngId = localStorage.getItem('savedOng');
    this.userToken = localStorage.getItem('token');
    console.log('savedOng ', this.savedOngId);
    this.getOrders();
  }

  getOrders() {
    this.orderService.getById(this.userToken, this.savedOngId).subscribe((data: any) => {
      this.listDonationsRequest = data.content;
      console.log(this.listDonationsRequest)
    })
  }

  receberVariavelCompartilhada(valor: any) {
    this.variavelCompartilhada = valor;
  }

  goToPerfilOng() {
    this.router.navigate(['/ong_perfil']);
  }

  handleBoolean(value: boolean) {
    this.flagModal = value;
    console.log('flagModal ', this.flagModal);
  }

  closeModal() {
    this.flagModal = false
  }
}
