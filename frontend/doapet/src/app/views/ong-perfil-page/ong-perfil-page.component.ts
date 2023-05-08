import { Component, OnInit } from '@angular/core';
import { sha256 } from 'js-sha256';

import { Ong } from 'src/app/models/ong';
import { DoapetService } from 'src/app/services/doapet.service';

@Component({
  selector: 'app-ong-perfil-page',
  templateUrl: './ong-perfil-page.component.html',
  styleUrls: ['./ong-perfil-page.component.scss']
})
export class OngPerfilPageComponent implements OnInit {

  ong: any;

  imageHash: any;
  imageName: string = '';

  constructor(private doapetService: DoapetService) { }

  ngOnInit() {
    this.getOng()
  }

  onFileSelected(event:any): void {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onloadend = () => {
      const buffer = reader.result as ArrayBuffer;
      const hash = sha256.create().update(buffer).hex();
      this.ong.profile_picture = hash;
      console.log('profile_pic ', this.ong.profile_picture);
    }

    reader.readAsArrayBuffer(file);
    console.log('file => ', file)

    this.imageName = file.name
  }

  onSubmit() {
    console.log('ong', this.ong)
    this.doapetService.createOng(this.ong).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  }

  getOng() {
    this.doapetService.getOngById(1).subscribe(data => {
      this.ong = data;
      console.log('retorno api, ', this.ong)
    })
  }



}
