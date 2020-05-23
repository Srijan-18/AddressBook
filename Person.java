package com.addressbook;

import java.util.Scanner;

class Person
{

	String firstName;
	String lastName;
	int id;
	long phoneNumber;
	Address completeAddress;
	Scanner takeInput = new Scanner(System.in);
	public Person(int id, String firstName, String lastName, long phoneNumber, String completeAddress )
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
		String[] token = completeAddress.split(":");
		this.completeAddress=new Address(token[0], token[1],token[2],Integer.parseInt(token[3]));
	}
	public Person()
	{	
		System.out.print("\n\t\t    Enter First Name :");
		String firstName=takeInput.nextLine();
		this.setFirstName(firstName);
		System.out.print("\n\t\t    Enter Last Name :");
		String lastName=takeInput.nextLine();
		this.setLastName(lastName);
		System.out.print("\n\t\t    Enter ID Number :");
		int id=Integer.parseInt(takeInput.next());
		this.setId(id);
		System.out.print("\n\t\t    Enter Phone Number :");
		long phoneNumber=Long.parseLong(takeInput.next());
		this.setPhoneNumber(phoneNumber);
		this.setCompleteAddress();	
	}	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public long getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setCompleteAddress()
	{
		completeAddress=new Address();
	}
	public Address getCompleteAddress()
	{
		return completeAddress;
	}
	public String toString() 
	{
		return "\"First Name: " + firstName + "\"\t\"Last Name: " + lastName + "\"\t\"ID: " + id + "\"\t\"PhoneNumber: "
				+ phoneNumber +"\"\t"+ completeAddress ;
	}	
}