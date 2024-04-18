import { HttpClient } from '@angular/common/http';
import { Component, HostListener } from '@angular/core';
import { OrderServiceService } from '../order-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserDetailsService } from '../user-details.service';
 
declare var Razorpay: any;
 
@Component({
  selector: 'app-payment-gateway',
  templateUrl: './payment-gateway.component.html',
  styleUrls: ['./payment-gateway.component.css']
})
export class PaymentGatewayComponent {

  form: any = {};

  constructor(private http: HttpClient,
    private orderService:OrderServiceService,
    private router: Router,
    private userDetailsService: UserDetailsService,
    private route: ActivatedRoute ) {
 
  }
  ngOnInit() {
    const formData = history.state.formData;
    if (formData) {
      this.form = formData;
    }
  }
 
  sayHello() {
    alert("Hello InsuraNexus");
  }
 
  paymentId: string | undefined;
  error: string | undefined;
 
  options = {
    "key": "",
    "amount": "",
    "name": "InsuraNexus",
    "description": "Insurance Aggregator",
    "image": "./assets/InsuraNexus.png",
    "order_id":"",
    "handler": function (response: any){
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );    
      window.dispatchEvent(event);
    }
    ,
    "prefill": {
    "name": "",
    "email": "",
    "contact": ""
    },
    "notes": {
    "address": ""
    },
    "theme": {
    "color": "#3399cc"
    }
    };
 
    onSubmit(): void {
      this.paymentId = '';
      this.error = '';
      this.orderService.createOrder(this.form).subscribe(
      data => {
        this.options.key = data.secretId;
        this.options.order_id = data.razorpayOrderId;
        this.options.amount = data.applicationFee; //paise
        this.options.prefill.name = "InsuraNexus";
        this.options.prefill.email = "dxcinsuranceaggregator@gmail.com";
        this.options.prefill.contact = "9988776655";
       
        if(data.pgName ==='razor2') {
          this.options.image="./assets/InsuraNexus.png";
          var rzp1 = new Razorpay(this.options);
          rzp1.open();
        } else {
          var rzp2 = new Razorpay(this.options);
          rzp2.open();
        }
       
               
        rzp1.on('payment.failed',  (response: { error: { code: any; description: any; source: any; step: any; reason: string; metadata: { order_id: any; payment_id: any; }; }; }) =>{    
          // Todo - store this information in the server
          console.log(response);
          console.log(response.error.code);    
          console.log(response.error.description);    
          console.log(response.error.source);    
          console.log(response.error.step);    
          console.log(response.error.reason);    
          console.log(response.error.metadata.order_id);    
          console.log(response.error.metadata.payment_id);
          this.error = response.error.reason;
        }
        );
        rzp1.on('payment.success', (response: any) => {
          // Handle payment success
          console.log('Payment success:', response);
          this.sendFormDataToService(this.form);
        });
        rzp2.on('payment.success', (response: any) => {
          // Handle payment success
          console.log('Payment success:', response);
          this.sendFormDataToService(this.form);
        });
      }
      ,
      err => {
        this.error = err.error.message;
      }
      );
    }
    
    sendFormDataToService(formData: any) {
      this.userDetailsService.submitUserDetails(formData).subscribe(
        response => {
          console.log('Success message sent:', response);
          this.router.navigate(['/homepage'], { skipLocationChange: true });
        },
        error => {
          console.error('Error sending success message:', error);
        }
      );
    }
  
    @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: { detail: any; }): void {
    console.log(event.detail);
    this.sendFormDataToService(this.form);
  }
}