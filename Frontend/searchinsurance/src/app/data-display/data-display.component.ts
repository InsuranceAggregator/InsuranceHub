
import { Component, OnInit } from '@angular/core';

import { BackendDataService } from '../backend-data.service';
 
@Component({

  selector: 'app-data-display',

  templateUrl: './data-display.component.html',

  styleUrls: ['./data-display.component.css']

})

export class DataDisplayComponent implements OnInit {

  data: any;

  searchPolicyName: string | undefined;
 
  constructor(private backendDataService: BackendDataService) { }
 
  ngOnInit(): void {

    this.fetchData();

  }
 
  fetchData() {

    this.backendDataService.getData().subscribe(

      (response) => {

        this.data = response;

      },

      (error) => {

        console.error('Error fetching data: ', error);

      }

    );

  }
 
  searchDataByPolicyName() {

    if (this.searchPolicyName) {

      this.backendDataService.searchByPolicyName(this.searchPolicyName).subscribe(

        (response) => {

          this.data = response;

        },

        (error) => {

          console.error('Error fetching data: ', error);

        }

      );

    } else {

      this.fetchData(); // If searchPolicyName is empty, fetch all data

    }

  }

}
