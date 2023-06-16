import { Injectable } from '@angular/core';

@Injectable()
export class Order {
  product_id: number = 0;
  assistance_id: null= null;
  quantity: number = 0;
  order_status: string = '';
  priority_level_status: string = '';
  total_price: number = 0;
}
