package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Account;
import model.entities.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdraw = sc.nextDouble();
			Account account = new Account(number, name, balance, withdraw);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();	
			account.withdraw(amount);
			
			System.out.print(account);
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid information");
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}	
		
		sc.close();
	}
}
