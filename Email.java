package com.emailgen;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String companySuffix="oracle.com";
	private String password;
	private int mailboxCapacity=500;
	private String alternateEmail;
	private int defaultPasswordLength=10;
	
	/**
	 * This is the constructor to generate email and password
	 * @param firstName
	 * @param lastName
	 */
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email generation in progress for " + this.firstName + " "+ this.lastName);
		//call a function to get the department
		this.department = getDepartment();
		this.password = generateRandomPassword(defaultPasswordLength);
		if(department!="")
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"+this.department+"."+companySuffix;
		else
			this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@"+companySuffix;
		System.out.println("Email generation is complete!");
	}
	
	/**
	 * function to get the department code
	 * @return department code
	 */
	private String getDepartment() {
		System.out.println("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none.\nEnter department code:");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		switch(depChoice) {
		case 1:
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		case 0:
			return "";
			default:
				System.out.println("Invalid department code.");
				return "";
		}
	}
	
	/**
	 * function to generate a random password of given length
	 * @param length
	 * @return password
	 */
	public String generateRandomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int index = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(index);
		}
		return new String(password);
	}
	
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//set the password
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public String getAlternateEmail() { return alternateEmail; }
	public int getMailboxCapacity() { return mailboxCapacity; }
	
	/**
	 * function to show information related to Email generation
	 * @return String
	 */
	public String showInfo() {
		return "Employee Name : "+ firstName + " "+ lastName +
				"\nYour Email : "+email+
				"\nYour password : "+password+
				"\nYour mailbox capacity : "+mailboxCapacity+"MB";
	}

}
