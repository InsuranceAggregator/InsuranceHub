import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
 // Adjust the path
import { Observable } from 'rxjs';
import { UserDataService} from '../user-data.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  users: any[] = [];

  constructor(
    private userDataService: UserDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.userDataService.getAllUsers().subscribe(
      (data: any[]) => {
        this.users = data;
      },
      (error: any) => {
        console.error('Error fetching users: ', error);
      }
    );
  }

  viewUserDetails(id: number): void {
    this.router.navigate(['/user-details', id]);
  }

  navigateToAdminDashboard(): void {
    this.router.navigate(['/admin-dashboard']);
  }
}
