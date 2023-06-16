import { Component, OnInit } from '@angular/core';

import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/models/product';

@Component({
  selector: 'app-include-product-page',
  templateUrl: './include-product-page.component.html',
  styleUrls: ['./include-product-page.component.scss']
})
export class IncludeProductPageComponent implements OnInit {

  listCategories = [];
  listMeasurements = [];

  product: Product = {
    name: "",
    measure: "",
    product_category: "",
    price: 0,
  };

  typedValue: any;
  userToken: any;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.catchCategories();
    this.catchMeasurements();
    this.userToken = localStorage.getItem('token');
    console.log(this.userToken)
  }

  catchCategories() {
    this.productService.getCategories().subscribe(
      response => {
        this.listCategories = response;
        console.log('Lista de Categorias ', this.listCategories);
      },
      error => {
        console.log(error);
      }
    )
  }

  catchMeasurements() {
    this.productService.getMeasurements().subscribe(
      response => {
        this.listMeasurements = response;
        console.log('Lista de Medidas ', this.listMeasurements);
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
    this.product.price = this.typedValue;
    console.log('product ', this.product);
    this.productService.createProduct(this.userToken, this.product).subscribe(
      response => {
        console.log(response)
      },
      error => {
        console.log(error);
      }
    )
    location.reload();
  };
}
