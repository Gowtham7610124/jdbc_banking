package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.DBconn;



public class AccountWithdraw extends AccountDeposit {
	long  withdraw = 0;

	public void withdraw()
	{	
		try
		{
			Connection c = DBconn.getCon();
			
			System.out.println("Enter account number : ");
			acc=sc.nextInt();
			System.out.println("Enter Amount to withdraw : ");
			withdraw=sc.nextInt();
			
			PreparedStatement ps2 = c.prepareStatement("Select * from accounts where acc=?");
			ps2.setLong(1, acc);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next())
			{
				balance = rs2.getInt(3);
			}
			long amount = 0;
			balance=balance - withdraw;
			
			PreparedStatement ps1 = c.prepareStatement("update accounts set balance=? where acc=?");
			ps1.setLong(1, balance);
			ps1.setLong(2, acc);
			int i = ps1.executeUpdate();
			if(i>=1)
				System.out.println("Record Updated Sucessfully");
			else
				System.out.println("Failed to update Please Retry");
		}
		catch(Exception e)
		{
			System.out.println("Transaction not possible check acc no and balance");
			e.printStackTrace();
		}
			
			
	}

	public void addUser() {
		// TODO Auto-generated method stub
		
	}
}
