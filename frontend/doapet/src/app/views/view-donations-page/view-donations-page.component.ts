import { Component, OnInit } from '@angular/core';
import { DonationsModel } from 'src/app/mocks/donations.model';

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

  buttonLightStyle = {'width': this.btnWidth, 'height': this.btnHeight, 'font-size': this.btnFont}

  listDonationsRequest: DonationsModel[] = [
    {
      name: 'Saco Ração Seca Origens para Cães Adultos',
      weight: '10',
      unit: 'kg',
      quantity: '10',
      price: '150,00',
      totalPrice: '1500,00'
    },
    {
      name: 'Saco Ração Seca Origens para Gatos Filhotes',
      weight: '5',
      unit: 'kg',
      quantity: '10',
      price: '70,00',
      totalPrice: '700,00'
    },
    {
      name: 'Castração de Cachorros Machos',
      weight: '',
      unit: '',
      quantity: '5',
      price: '300,00',
      totalPrice: '1.500,00'
    },
  ];

  constructor() { }

  ngOnInit() {
  }

}
