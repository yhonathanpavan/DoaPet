import { Injectable } from '@angular/core';

@Injectable()
export class Product {
  name: string = '';
  measure: string = '';
  product_category: string = '';
  price: number = 0;
}
