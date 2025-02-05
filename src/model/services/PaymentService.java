package model.services;

public interface PaymentService {
	public Double paymentFee(double amount);
	public Double interest(double amount, int months);
}
