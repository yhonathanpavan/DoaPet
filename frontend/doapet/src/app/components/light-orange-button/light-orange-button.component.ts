import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-light-orange-button',
  templateUrl: './light-orange-button.component.html',
  styleUrls: ['./light-orange-button.component.scss']
})
export class LightOrangeButtonComponent implements OnInit {

  @Input() btnIcon: string = '';
  @Input() btnText: string = '';
  @Input() btnWidth: string = '';
  @Input() btnHeight: string = '';
  @Input() btnFont: string = '';

  @Input() buttonLightStyle = {'width': this.btnWidth, 'height': this.btnHeight, 'font-size': this.btnFont}

  constructor() { }

  ngOnInit() {
  }

}
