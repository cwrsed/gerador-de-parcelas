package model.services;

public class PayPalService implements PaymentService {
	
	@Override
	public Double paymentFee(double amount) {
		return amount * 0.02;
	}
	
	@Override
	public Double interest(double amount, int months) {
		return 0.01 * months * amount;
	}
}
