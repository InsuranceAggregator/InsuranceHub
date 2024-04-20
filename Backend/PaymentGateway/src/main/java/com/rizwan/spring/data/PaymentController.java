package com.rizwan.spring.data;

import java.math.BigInteger;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/pg")
public class PaymentController {
	private RazorpayClient client;
	private static final String SECRET_ID1 = "rzp_test_wmDl5TjphiigG5";
	private static final String SECRET_KEY1 = "GLHzG7KW47OM0n8fcpWlmwQQ";
	private static final String SECRET_ID2 = "rzp_test_iNR6DPIhqIciUf";
	private static final String SECRET_KEY2 = "cX4QSSKa6fE14FFBYvWhVhac";

	@PostMapping("/createOrder")
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();
		try {
			if (orderRequest.getAmount().intValue() > 1000) {
				client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
			} else {
				client = new RazorpayClient(SECRET_ID2, SECRET_KEY2);
			}
			Order order = createRazorPayOrder(orderRequest.getAmount());
			System.out.println("---------------------------");
			String orderId = (String) order.get("id");
			System.out.println("Order ID: " + orderId);
			System.out.println("---------------------------");

			response.setRazorpayOrderId(orderId);
			response.setApplicationFee("" + orderRequest.getAmount());

			if (orderRequest.getAmount().intValue() > 1000) {
				response.setSecretKey(SECRET_KEY1);
				response.setSecretId(SECRET_ID1);
				response.setPgName("razor1");
			} else {
				response.setSecretKey(SECRET_KEY2);
				response.setSecretId(SECRET_ID2);
				response.setPgName("razor2");
			}

			return response;

		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		return response;
	}

	private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {
		JSONObject options = new JSONObject();
		options.put("amount", amount.multiply(BigInteger.valueOf(100)));
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
		return client.orders.create(options);
	}
}