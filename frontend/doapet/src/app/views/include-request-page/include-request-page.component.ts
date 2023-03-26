import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-include-request-page',
  templateUrl: './include-request-page.component.html',
  styleUrls: ['./include-request-page.component.scss']
})
export class IncludeRequestPageComponent implements OnInit {

  goalList = [
    {option: 'produto', value: 'product'},
    {option: 'serviço', value: 'assistance'}
  ];

  quantityLabel: string = 'Quantidade';
  quantityType: string = 'number';
  quantityWidth: string = '300px';
  quantityHeight: string = '30px';
  quantityFont: string = '16px';

  quantityStyle = {'width': this.quantityWidth, 'height': this.quantityHeight, 'fontSize': this.quantityFont}

  itemName = '';
  itemWeight = '';
  itemUnit = '';
  itemPrice = '';
  itemTotalPrice = '';

  selectedOption = '';
  printedOption = '';

  constructor() { }

  ngOnInit() {
  }

  onSelected() {
    this.printedOption = this.selectedOption;
  }

}
