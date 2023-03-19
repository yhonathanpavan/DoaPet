import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-inside',
  templateUrl: './input-inside.component.html',
  styleUrls: ['./input-inside.component.scss']
})
export class InputInsideComponent implements OnInit {

  @Input() inputPlaceholder: string = ''
  @Input() inputType: string = '';
  @Input() inputStep: string = '';
  @Input() inputWidth: string = '';
  @Input() inputHeight: string = '';
  @Input() inputFont: string = ''
  @Input() inputMargin: string = '';

  @Input() inputStyle = {'width': this.inputWidth, 'height': this.inputHeight, 'fontSize': this.inputFont, 'margin': this.inputMargin}

  constructor() { }

  ngOnInit() {
  }

}
