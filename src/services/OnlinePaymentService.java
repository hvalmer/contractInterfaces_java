package services;

public interface OnlinePaymentService {

	double paymentFee(double amont);
	double interest(double amont, int months);
}
