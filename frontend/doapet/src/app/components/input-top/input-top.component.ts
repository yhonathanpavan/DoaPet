import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-top',
  templateUrl: './input-top.component.html',
  styleUrls: ['./input-top.component.scss']
})
export class InputTopComponent implements OnInit {

  inputLabel: string = '';
  inputType: string = '';
  inputWidth: string = '';
  inputHeight: string = '';
  inputFont: string = ''


  inputStyle = {'width': this.inputWidth, 'height': this.inputHeight, 'fontSize': this.inputFont}

  constructor() { }

  ngOnInit() {
  }

}
