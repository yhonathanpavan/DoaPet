import { Component, OnInit } from '@angular/core';

import { DonorService } from 'src/app/services/donor.service';

@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.scss']
})
export class PerfilPageComponent implements OnInit {

  donor: any;
  donorId: any;
  userToken: any;

  constructor(private donorService: DonorService) { }

  ngOnInit() {
    this.donorId =localStorage.getItem('userId')
    this.userToken = localStorage.getItem('token');
    this.getDonor();
  }

  getDonor() {
    this.donorService.getOngById(this.userToken, this.donorId).subscribe(data => {
      this.donor = data;
      console.log('donor infos ', this.donor);
    })
  }

  updateDonor() {
    let url = `http://localhost:8080/doapet/v1/donors/${this.donorId}`;
    this.donorService.updateDonor(url, this.donor, this.userToken).subscribe(
      response => {
        console.log(response)
      },
      error => {
        console.log('ERROR ', error);
      }
    )
  }

}
