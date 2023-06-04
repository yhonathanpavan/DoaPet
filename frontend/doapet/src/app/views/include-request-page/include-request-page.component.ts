import { Component, OnInit } from '@angular/core';

import { ProductService } from 'src/app/services/product.service';
import { AssistanceService } from 'src/app/services/assistance.service';
import { OrderService } from 'src/app/services/order.service';

import { Order } from 'src/app/models/order';

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

  opcaoSelecionada = '';
  nameSelected: any = '';

  listNames: any = [];
  listSelected: any = [];

  realValue: any;

  typedValue: any;

  order: Order = {
    product_id: 0,
    assistance_id: 0,
    quantity: 0,
    order_status: "",
    priority_level_status: ""
  }

  constructor(
    private productService: ProductService,
    private assistanceService: AssistanceService,
    private orderService: OrderService,
  ) { }

  ngOnInit() {
  }

  onSelected() {
    this.printedOption = this.selectedOption;
    console.log('printedOption ', this.printedOption)
  }

  selecionarOpcao() {
    console.log('Opção selecionada:', this.opcaoSelecionada);
    this.fillSelectName();
    // Faça o que deseja com a opção selecionada
  }

  getProducts() {
    this.productService.getAllProducts().subscribe(
      response => {
        this.listNames = response.content;
        console.log('listNames ', this.listNames)
      },
      error => {
        console.log('ERROR', error)
      }
    )
  }

  getAssistances() {
    this.assistanceService.getAllAssistance().subscribe(
      response => {
        this.listNames = response.content;
        console.log('listNames ', this.listNames);
      },
      error => {
        console.log('ERROR', error)
      }
    )
  }

  fillSelectName() {
    if(this.opcaoSelecionada === 'product') {
      this.getProducts()
    } else {
      this.getAssistances()
    }
  }

  selectedName() {
    if (this.opcaoSelecionada === 'product') {
      this.order.product_id = this.nameSelected;
    } else {
      this.order.assistance_id = this.nameSelected;
    }

    console.log('nameSelected ', this.nameSelected);
    this.fillInputs(this.listNames, this.nameSelected);
  }

  fillInputs(list: any[], selectedValue: string) {
    console.log("chegou aqui!")
    for (let item of list) {
    console.log("item ", item)
      if (item.id == selectedValue) {
        this.listSelected = item;
        this.realValue = parseFloat(item.price);
        console.log("lista --- ", this.listSelected)
        console.log('realValue ', this.realValue)
      }
    }
  }

  catchTypedValue() {
    console.log('Valor digitado:', this.typedValue);
    console.log(this.typedValue * this.realValue)
  }

  onSubmit() {
    this.orderService.createOrder(this.order).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  }
}
