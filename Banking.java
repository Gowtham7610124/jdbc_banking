package controller;
import java.util.Scanner;

import utility.AccountWithdraw;
public class Banking extends AccountWithdraw {
	static int ch;
	static Scanner mb = new Scanner(System.in);

	public static void main(String args[ ])
	{
		// TODO Auto-generated method stub
		
		

		AccountWithdraw a1 = new AccountWithdraw();
			
		do
		{	

			
			System.out.println(" Welcome to Central Bank of India");
			System.out.println(".............................................");
			System.out.println("1.AddUser");
			System.out.println("2.ViewUser");		
			System.out.println("3.Deposit Amount");
			System.out.println("4.Withdraw  Amount");
			System.out.println("5.Check  Your Balance");
			System.out.println("6.Exit");
			System.out.print("Enter your choice:");
			ch = mb.nextInt();
			switch(ch)
			{
				case 1:     a1.addUser();
					System.out.println(".............................................");
					break;
				case 2: a1.viewUser();
					break;
				case 3: a1.deposit();
					break;
				case 4:a1.withdraw();
					break;
				case 5:a1.checkBalance();
					break;
				case 6: System.exit(0);
					break;
				default:System.out.println("Enter valid choice:");
					break;
			}
		}while(ch!=7);
		
	}
}
