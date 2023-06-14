import { Component, OnInit } from '@angular/core';
import { sha256 } from 'js-sha256';

import { Ong } from 'src/app/models/ong';
import { OngService } from 'src/app/services/ong.service';

@Component({
  selector: 'app-ong-perfil-page',
  templateUrl: './ong-perfil-page.component.html',
  styleUrls: ['./ong-perfil-page.component.scss']
})
export class OngPerfilPageComponent implements OnInit {

  ong: any;

  imageHash: any;
  imageName: string = '';

  userType: string | null = '';

  ongId: any;

  constructor(private ongService: OngService) { }

  ngOnInit() {
    this.ongId = localStorage.getItem('savedOng')
    this.getOng()
    this.userType = localStorage.getItem('userType')
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
    this.ongService.createOng(this.ong).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
  }

  getOng() {
    this.ongService.getOngById(this.ongId).subscribe(data => {
      this.ong = data;
      console.log('retorno api, ', this.ong)
    })
  }

  updateOng() {
    let url = `http://localhost:8080/doapet/v1/ongs/${this.ongId}`;
    this.ongService.updateOng(url, this.ong).subscribe(
      response => {
        console.log(response)
      },
      error => {
        console.log('ERROR ', error);
      }
    )
  }
}
