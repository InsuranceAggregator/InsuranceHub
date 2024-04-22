import { Component, OnInit } from '@angular/core';
import { AdminContactService } from '../admin-contact.service';
import { Contact } from '../models/contact';


@Component({
  selector: 'app-admin-support',
  templateUrl: './admin-support.component.html',
  styleUrls: ['./admin-support.component.css']
})
export class AdminSupportComponent implements OnInit {
  contactMessages: Contact[] = [];

  constructor(private adminContactService: AdminContactService) { }

  ngOnInit(): void {
    this.loadSupportMessages();
  }

  loadSupportMessages(): void {
    this.adminContactService.getAllContactMessages().subscribe(
      (data: Contact[]) => {
        this.contactMessages = data;
      },
      (error: any) => {
        console.error('Error loading support messages:', error);
      }
    );
  }

  acceptMessage(messageId: number): void {
    this.adminContactService.deleteContactMessage(messageId).subscribe(
      () => {
        console.log(`Message with ID ${messageId} accepted and deleted successfully.`);
        this.loadSupportMessages();  // Reload the messages after deletion
      },
      (error: any) => {
        console.error(`Error accepting message with ID ${messageId}:`, error);
      }
    );
  }

  deleteMessage(messageId: number): void {
    this.adminContactService.deleteContactMessage(messageId).subscribe(
      () => {
        console.log(`Message with ID ${messageId} deleted successfully.`);
        this.loadSupportMessages();  // Reload the messages after deletion
      },
      (error: any) => {
        console.error(`Error deleting message with ID ${messageId}:`, error);
      }
    );
  }
}
