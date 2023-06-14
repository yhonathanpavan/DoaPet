import { Injectable } from '@angular/core';

@Injectable()
export class ObjetoOrder {
  content: any[] = []; // Tipo pode ser mais específico, se possível
  pageable: any;
  totalPages: number = 0;
  totalElements: number = 0;
  last: boolean = true;
  number: number = 0;
  size: number = 0;
  numberOfElements: number = 0;
  sort: any;
  first: boolean = true;
  empty: boolean = true;
}
