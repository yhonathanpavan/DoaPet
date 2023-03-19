import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-top',
  templateUrl: './input-top.component.html',
  styleUrls: ['./input-top.component.scss']
})
export class InputTopComponent implements OnInit {

  @Input() inputLabel: string = '';
  @Input() inputType: string = '';
  @Input() inputWidth: string = '';
  @Input() inputHeight: string = '';
  @Input() inputFont: string = ''


  @Input() inputStyle = {'width': this.inputWidth, 'height': this.inputHeight, 'fontSize': this.inputFont}

  constructor() { }

  ngOnInit() {
  }

}
