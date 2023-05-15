import { Component, OnInit } from '@angular/core';

import { AssistanceService } from 'src/app/services/assistance.service';
import { Assistance } from 'src/app/models/assistance';

@Component({
  selector: 'app-include-assistance-page',
  templateUrl: './include-assistance-page.component.html',
  styleUrls: ['./include-assistance-page.component.scss']
})
export class IncludeAssistancePageComponent implements OnInit {

  listCategories = [];

  assistance: Assistance = {
    name: "",
    assistance_category: "",
    price: 0
  }

  typedValue: any;

  constructor(private assistanceService: AssistanceService) { }

  ngOnInit() {
    this.catchCategories();
  }

  catchCategories() {
    this.assistanceService.getCategories().subscribe(
      response => {
        this.listCategories = response;
        console.log('Lista de Categorias ', this.listCategories);
      },
      error => {
        console.log(error);
      }
    )
  }

  handleChange(event: any) {
    this.typedValue = event.target.value;
    console.log("Valor Digitado... ", this.typedValue);
  }

  onSubmit() {
    // this.assistance.price = this.typedValue;
    console.log('assistance ', this.assistance);
    this.assistanceService.createAssistance(this.assistance).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  };



}
