package com.addressbook;

import java.util.Scanner;

class Person
{
<<<<<<< HEAD
	private String firstName;
	private String lastName;
	int Id;
	int phoneNumber;
	Address completeAddress;
	Scanner takeInput = new Scanner(System.in);
=======
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
>>>>>>> Address
	public Person()
	{
		this.setFirstName();
		this.setLastName();
		this.setId();
		this.setPhoneNumber();
<<<<<<< HEAD
		this.setCompleteAddress();
		
=======
		this.setCompleteAddress();	
>>>>>>> Address
	}
	
	public void setFirstName()
	{
<<<<<<< HEAD
		System.out.println("Enter First Name :");
		firstName=takeInput.next();
=======
		System.out.print("\n\t\t   Enter First Name :");
		firstName=takeInput.nextLine();
>>>>>>> Address
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setLastName()
	{
<<<<<<< HEAD
		System.out.println("Enter Last Name :");
		lastName=takeInput.next();
=======
		System.out.print("\n\t\t   Enter Last Name :");
		lastName=takeInput.nextLine();
>>>>>>> Address
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setId()
	{
<<<<<<< HEAD
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
=======
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
>>>>>>> Address
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
<<<<<<< HEAD
=======

	@Override
	public String toString() {
		return "\"First Name: " + firstName + "\"\t\"Last Name: " + lastName + "\"\t\"ID: " + id + "\"\t\"PhoneNumber: "
				+ phoneNumber +"\t"+ completeAddress ;
	}
	
>>>>>>> Address
}