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
		this.setFirstName();
		this.setLastName();
		this.setId();
		this.setPhoneNumber();
		this.setCompleteAddress();	
	}
	
	public void setFirstName()
	{
		System.out.print("\n\t\t   Enter First Name :");
		firstName=takeInput.nextLine();
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName()
	{
		System.out.print("\n\t\t   Enter Last Name :");
		lastName=takeInput.nextLine();
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setId()
	{
		System.out.print("\n\t\t   Enter ID Number :");
		id=takeInput.nextInt();
	}
	public int getId()
	{
		return id;
	}
	public void setPhoneNumber()
	{
		System.out.print("\n\t\t   Enter Phone Number :");
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
		return "\"First Name: " + firstName + "\"\t\"Last Name: " + lastName + "\"\t\"ID: " + id + "\"\t\"PhoneNumber: "
				+ phoneNumber +"\t"+ completeAddress ;
	}
	
}