import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-include-product-page',
  templateUrl: './include-product-page.component.html',
  styleUrls: ['./include-product-page.component.scss']
})
export class IncludeProductPageComponent implements OnInit {

  namePlaceholder: string = 'Nome';
  nameType: string = 'text';
  nameWidth: string = '100%';
  nameHeight: string = '40px';
  nameFont: string = '16px';
  nameMargin: string = '10px 50px 10px auto';

  nameStyle = {'width': this.nameWidth, 'height': this.nameHeight, 'fontSize': this.nameFont, 'margin': this.nameMargin};

  weightPlaceholder: string = 'Peso';
  weightType: string = 'number';
  weightWidth: string = '80%';
  weightHeight: string = '40px';
  weightFont: string = '16px';
  weightMargin: string = '10px 0 10px 0px';

  weightStyle = {'width': this.weightWidth, 'height': this.weightHeight, 'fontSize': this.weightFont, 'margin': this.weightMargin};

  pricePlaceholder: string = 'Valor Unitário';
  priceType: string = 'number';
  priceWidth: string = '100%';
  priceHeight: string = '40px';
  priceFont: string = '16px';
  priceMargin: string = '10px 0 10px 0';

  priceStyle = {'width': this.priceWidth, 'height': this.priceHeight, 'fontSize': this.priceFont, 'margin': this.priceMargin};

  constructor() { }

  ngOnInit() {
  }

}
