import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-light-orange-button',
  templateUrl: './light-orange-button.component.html',
  styleUrls: ['./light-orange-button.component.scss']
})
export class LightOrangeButtonComponent implements OnInit {

  btnIcon: string = '../../../assets/icons/icon-dog.svg';
  btnText: string = 'teste';
  btnWidth: string = '150px';
  btnHeight: string = '50px';
  btnFont: string = '18px';

  buttonLightStyle = {'width': this.btnWidth, 'height': this.btnHeight, 'font-size': this.btnFont}

  constructor() { }

  ngOnInit() {
  }

}
