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
		this.setFirstName(takeInput.nextLine());
		System.out.print("\n\t\t    Enter Last Name :");
		this.setLastName(takeInput.nextLine());
		System.out.print("\n\t\t    Enter ID Number :");
		this.setId(Integer.parseInt(takeInput.nextLine()));
		System.out.print("\n\t\t    Enter Phone Number :");
		this.setPhoneNumber(Long.parseLong(takeInput.nextLine()));
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