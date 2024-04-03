import { Component } from '@angular/core';
import { EmailService } from './email.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'insuranceAggregator';
  constructor(private emailService: EmailService) {}

  sendEmail() {
    const emailData = {
      to: 'rijjuclash@gmail.com',
      subject: 'Test Email',
      text: 'This is a test email sent from Angular.'
    };

    this.emailService.sendEmail(emailData).subscribe(
      response => {
        console.log('Email sent successfully:', response);
        // Handle success
      },
      error => {
        console.error('Error sending email:', error);
        // Handle error
      }
    );
  }
}
