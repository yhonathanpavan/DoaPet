import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-inside',
  templateUrl: './input-inside.component.html',
  styleUrls: ['./input-inside.component.scss']
})
export class InputInsideComponent implements OnInit {

  inputPlaceholder: string = 'teste'
  inputType: string = 'text';
  inputWidth: string = '150px';
  inputHeight: string = '50px';
  inputFont: string = '16px'


  inputStyle = {'width': this.inputWidth, 'height': this.inputHeight, 'fontSize': this.inputFont}

  constructor() { }

  ngOnInit() {
  }

}
