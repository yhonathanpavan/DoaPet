import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-dark-orange-button',
  templateUrl: './dark-orange-button.component.html',
  styleUrls: ['./dark-orange-button.component.scss']
})
export class DarkOrangeButtonComponent implements OnInit {

  @Input() btnDarkIcon: string = '';
  @Input() btnDarkText: string = '';
  @Input() btnDarkWidth: string = '';
  @Input() btnDarkHeight: string = '';
  @Input() btnDarkFont: string = '';

  @Input() buttonDarkStyle = {'width': this.btnDarkWidth, 'height': this.btnDarkHeight, 'font-size': this.btnDarkFont}

  constructor() { }

  ngOnInit() {
  }

}
