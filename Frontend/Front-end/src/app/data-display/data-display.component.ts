import { Component, OnInit } from '@angular/core';
import { BackendDataService } from '../service/search/backend-data.service';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-data-display',
  templateUrl: './data-display.component.html',
  styleUrls: ['./data-display.component.css']
})
export class DataDisplayComponent implements OnInit {
  data: any[] = [];
  filteredData: any[] = []; // Initialize filteredData as an empty array
  searchPolicyName: string | undefined;
 
  constructor(private backendDataService: BackendDataService, private router: Router) { }
 
  ngOnInit(): void {
    this.fetchData();
  }
 
  fetchData() {
    this.backendDataService.getData().subscribe((result: any[]) => {
      this.data = result;
      // Initially, assign all data to filteredData
      this.filteredData = this.data;
    });
  }
 
  searchDataByPolicyName() {
    if (this.searchPolicyName) {
      // Filter data based on searchPolicyName
      this.filteredData = this.data.filter(item =>
        item.policyName.toLowerCase().includes(this.searchPolicyName!.toLowerCase())
      );
    } else {
      // If searchPolicyName is empty, assign all data to filteredData
      this.filteredData = this.data;
    }
  }
 
  buyPolicy(id: number) {
    // Implement your buy policy logic here
    switch (id) {
      case 1:
        this.router.navigate(['/vehicle-buy2']);
        break;
      case 2:
        this.router.navigate(['/vehicle-buy1']);
        break;
      case 3:
        this.router.navigate(['/home-buy1']);
        break;
      case 4:
        this.router.navigate(['/home-buy2']);
        break;
     
      default:
        console.log('No path specified for this ID.');
        break;
    }
  }
}