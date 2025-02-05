package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private PaymentService payService;
	
	public ContractService(PaymentService payService) {
        this.payService = payService;
    }
	
	public void processContract(Contract contract, int months) {
		double value = contract.getTotalValue()/months;
		
		for (int i = 1; i <= months; i++) {
			
			double interest = payService.interest(value, i);
			double payFee = payService.paymentFee(value + interest);
			
			double quota = value + interest + payFee;
			
			Installment installment = new Installment(contract.getDate().plusMonths(i), quota);
			contract.getInstallments().add(installment);
		}
	}
}
