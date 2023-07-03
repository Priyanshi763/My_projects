package bank_management;
import java.util.Scanner;

import javax.swing.JFrame;
public class Bank_management_system {
		public static void main(String[] args) {
			Scanner scn=new Scanner(System.in);
			BankAccount obj = new BankAccount();
			obj.read();
			System.out.println();
			obj.showMenu();
			
			
		}

	}

	class BankAccount{
		int balance;
		int previousTransaction;
		String customerName;
		String customerId;
		
		Scanner scn=new Scanner(System.in);
		
		BankAccount(){
			
		}
		
		BankAccount(String cname , String cid) {
			customerName = cname;
			customerId =cid;
		}
		void read() {
			System.out.println("Enter Customer name");
			customerName=scn.next();
			System.out.println("Enter Customer id");
			customerId = scn.next();
			
		}
		
		void deposit(int amount) {
			if(amount != 0) {
				balance = balance + amount;
				previousTransaction = amount;
			}
		}
		
		void withdraw(int amount) {
			if(balance<=0) {
				System.out.print("Not sufficient balance");
			}
			else if(amount != 0) {
				balance = balance - amount;
				previousTransaction = -amount;
			}
		}
		
		void getPreviousTransaction() {
			if(previousTransaction > 0) {
				System.out.println("Deposited: " + previousTransaction);
			}
			else if(previousTransaction < 0) {
				System.out.println("Withdraw: " +Math.abs(previousTransaction));
			}
			
			else {
				System.out.println("No Transaction Occured");
			}
		}
		
		void showMenu() {
			
			char option = '\0';
			Scanner scn = new Scanner(System.in);
			System.out.println("Customer name: "+ customerName);
			WelcomeFrame welcomeFrame = new WelcomeFrame(customerName);
	        welcomeFrame.setVisible(true);
			System.out.println("Customer Id: "+ customerId);
			System.out.println("\n");
			System.out.println("What do you want to know about?");
			System.out.println("\n");
			
			System.out.println("A : Check Your Balance");
			System.out.println("B : Deposit");
			System.out.println("C : Withdraw");
			System.out.println("D : Previous Transaction");
			System.out.println("E : Exit The System");
			
			do {
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("Enter Your Option");
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				option = scn.next().charAt(0);
				System.out.println("\n");
				
				switch (option) {
				
				case 'a','A' :
				
					System.out.println("-------------------------------------------------------");
					System.out.println("Balance = "+balance);
					System.out.println("-------------------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'B','b':
					System.out.println("-------------------------------------------------------");
					System.out.println("Enter an amount to deposit ");
					System.out.println("-------------------------------------------------------");
					
					int amount = scn.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C','c':
					System.out.println("-------------------------------------------------------");
					System.out.println("Enter an amount to withdraw ");
					System.out.println("-------------------------------------------------------");
					
					int amount2 = scn.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'D','d':
					System.out.println("-------------------------------------------------------");
					getPreviousTransaction();
					System.out.println("-------------------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'E','e' :
					System.out.println("-------------------------------------------------------");
	                break;


				default:
					System.out.println("Invalid Option!! Please Enter Correct Opton...");
					break;
				}			
			}
			while(option != 'E' && option!='e');
	
				System.out.println("Thank You for Using our Services.....!!");
		}
	}

