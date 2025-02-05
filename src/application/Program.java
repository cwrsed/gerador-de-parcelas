package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Date (dd/MM/yyyy): ");
		String date = sc.nextLine();
		
		System.out.print("Contract value: ");
		double amount = sc.nextDouble();
		
		System.out.print("Interest number: ");
		int quantity = sc.nextInt();
		
		Contract contract = new Contract(number, LocalDate.parse(date, fmt1), amount);
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(contract, quantity);
		
		System.out.println("Interests:");
		System.out.println(contract);
	}
}
