package com.addressbook;

import java.util.Scanner;

class Person
{
	private String firstName;
	private String lastName;
	int Id;
	int phoneNumber;
	Address completeAddress;
	Scanner takeInput = new Scanner(System.in);
	public Person()
	{
		this.setFirstName();
		this.setLastName();
		this.setId();
		this.setPhoneNumber();
		this.setCompleteAddress();
		
	}
	
	public void setFirstName()
	{
		System.out.println("Enter First Name :");
		firstName=takeInput.next();
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName()
	{
		System.out.println("Enter Last Name :");
		lastName=takeInput.next();
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setId()
	{
		System.out.println("Enter Id :");
		Id=takeInput.nextInt();
	}
	public int getId()
	{
		return Id;
	}
	public void setPhoneNumber()
	{
		System.out.println("Enter Phone Number :");
		phoneNumber=takeInput.nextInt();
	}
	public int getPhoneNumber()
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
}