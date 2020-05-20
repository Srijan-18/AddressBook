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
		String[] tokens = completeAddress.split("\n");
		this.completeAddress=new Address(tokens[0], tokens[1],tokens[2],Integer.parseInt(tokens[3]));
	}
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
		System.out.println("Enter 5-digit Unique Id :");
		id=takeInput.nextInt();
	}
	public int getId()
	{
		return id;
	}
	public void setPhoneNumber()
	{
		System.out.println("Enter Phone Number :");
		phoneNumber=takeInput.nextLong();
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

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", Id=" + id + ", phoneNumber="
				+ phoneNumber + ", completeAddress=" + completeAddress ;
	}
	
}