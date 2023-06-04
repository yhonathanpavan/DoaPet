import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-card-donations',
  templateUrl: './card-donations.component.html',
  styleUrls: ['./card-donations.component.scss']
})
export class CardDonationsComponent implements OnInit {

  @Input() name: string = 'Saco Ração Seca Origens para Cães Adultos';
  @Input() weight: string = '10';
  @Input() unit: string = 'Kg';
  @Input() quantity: string = '10';
  @Input() price: string = '150,00';
  @Input() totalPrice: string = '1.500,00';

  userType: string | null = '';
  showModal = false;

  constructor() { }

  ngOnInit() {
    // this.userType = localStorage.getItem('userType');
    this.userType = 'donor';
    console.log("userType ", this.userType);
  }
}
