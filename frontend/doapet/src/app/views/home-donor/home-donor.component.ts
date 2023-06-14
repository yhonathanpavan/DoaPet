import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { OngService } from 'src/app/services/ong.service';

@Component({
  selector: 'app-home-donor',
  templateUrl: './home-donor.component.html',
  styleUrls: ['./home-donor.component.scss']
})
export class HomeDonorComponent implements OnInit {

  value: string = '';
  listOngs: [] = [];

  constructor(
    private ongService: OngService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.getOngs();
  }

  getOngs() {
    this.ongService.getAllOng().subscribe(data => {
      this.listOngs = data.content;
      console.log('data ', this.listOngs)
      this.teste();
    })
  }

  teste() {
    for (let i = 0; i <= this.listOngs.length; i++) {
      console.log("teste ", this.listOngs[i])
    }
  }

  goTo(ongId: number) {
    localStorage.setItem('savedOng', `${ongId}`);
    this.router.navigate(['/view_donations']);
  }

}
