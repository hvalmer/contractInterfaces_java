package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class ContractProgram {

	public static void main(String[] args)  throws ParseException{
	
		Locale.setDefault(Locale.US);
		Scanner sca = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sca.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sca.next());
		System.out.print("Contract value: ");
		double totalValue = sca.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.print("Enter number of installments: ");
		int n = sca.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, n);
		
		System.out.println("Installments: ");
		for (Installment x : contract.getInstallments()) {
			System.out.println(x);
		}
		
		sca.close();
	}
}
