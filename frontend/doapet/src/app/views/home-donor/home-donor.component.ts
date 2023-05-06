import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-donor',
  templateUrl: './home-donor.component.html',
  styleUrls: ['./home-donor.component.scss']
})
export class HomeDonorComponent implements OnInit {

  value: string = '';

  constructor() { }

  ngOnInit() {
  }

}
