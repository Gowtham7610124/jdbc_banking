package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import dao.DBconn;


public class AccountDetails {
	long acc,  balance ,amount;
	String name;
	Scanner sc = new Scanner(System.in);
	
		
	void addUser()
	{
		System.out.println("Enter your Name:");
		name = sc.next();
		
		System.out.println("\n\n");
		System.out.println("Enter your Account number:");
		acc = sc.nextLong();
		try
		{
			Connection c = DBconn.getCon();
			PreparedStatement ps1 = c.prepareStatement("insert into accounts values(?,?,?)");
			ps1.setLong(1, acc);
		    ps1.setString(2, name);
			ps1.setLong(3, balance);
			int i = ps1.executeUpdate();
			if(i>=1)
				System.out.println("Record Added Sucessfully");
			else
				System.out.println("Falid to Add Record ");
		}
		catch(Exception e)
		{
			
			System.out.println("duplicate value not allowed");
		}
		
		
		
	}
	
	public void viewUser()
	{
		System.out.println("Enter account number : ");
		acc=sc.nextInt();
		
		try
		{
			Connection con = DBconn .getCon();
			PreparedStatement ps2 = con.prepareStatement("Select * from accounts where acc=?");
			ps2.setLong(1, acc);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next())
			{
				System.out.println("Account Number - "+rs2.getLong(1));
				System.out.println("Account Name - "+rs2.getString(2));
				System.out.println("Account Balance - "+rs2.getLong(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
		
	public void checkBalance()
	{	
		System.out.println("Enter your Account number:");
		acc = sc.nextLong();	
		

		try
		{
			Connection c = DBconn.getCon();
			PreparedStatement ps2 = c.prepareStatement("Select * from accounts where acc=?");
			ps2.setLong(1, acc);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next())
			{
				System.out.println("Account Number : "+rs2.getLong(1));
				System.out.println("Account Holder Name : "+rs2.getString(2));
				System.out.println("Account Balance : "+rs2.getLong(3));
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		

		
		
	}
}
