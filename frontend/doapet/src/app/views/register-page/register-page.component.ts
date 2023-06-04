import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { sha256 } from 'js-sha256';

import { Ong } from 'src/app/models/ong';
import { Donor } from 'src/app/models/donor';

import { OngService } from 'src/app/services/ong.service';
import { DonorService } from 'src/app/services/donor.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent implements OnInit {
  userType: string | null = '';
  imagePreviewUrl: string | undefined;
  imageName: string = '';

  ong: Ong = {
    name:"",
    email:"",
    password:"",
    phone_number:"",
    street:"",
    number:"",
    neighborhood:"",
    city:"",
    state:"",
    cnpj:"",
    pix:"",
    president_name:"",
    biography:"",
    profile_picture: "aisasadon123kvdnlsdfinaDSAPDMASD"
  };

  donor: Donor = {
    name: "",
    email: "",
    password: "",
    phone_number: "",
    street: "",
    number: "",
    neighborhood: "",
    city: "",
    state: "",
    cpf: "",
    birthdate: "",
    profile_picture: ""
  }

  imageHash: any;

  constructor(
    private ongService: OngService,
    private donorService: DonorService,
    private router: Router
  ) { }

  ngOnInit() {
    this.userType = localStorage.getItem("userType");
  }

  onFileSelected(event:any): void {
    const file = event.target.files[0];
    const reader = new FileReader();

    // reader.onload = () => {
    //   this.imagePreviewUrl = reader.result as string;
    // };
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
    this.redirectToLogin()
  }

  onSubmitDonor() {
    console.log('donor', this.donor)
    this.donorService.createDonor(this.donor).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      }
    )
    this.redirectToLogin()
  }

  redirectToLogin() {
    this.router.navigate(['/login'])
  }
}
