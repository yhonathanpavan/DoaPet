import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dark-orange-button',
  templateUrl: './dark-orange-button.component.html',
  styleUrls: ['./dark-orange-button.component.scss']
})
export class DarkOrangeButtonComponent implements OnInit {

  btnIcon: string = '../../../assets/icons/icon-cat.svg';
  btnText: string = 'teste';
  btnWidth: string = '150px';
  btnHeight: string = '50px';
  btnFont: string = '18px';

  buttonStyle = {'width': this.btnWidth, 'height': this.btnHeight, 'font-size': this.btnFont}

  constructor() { }

  ngOnInit() {
  }

}
