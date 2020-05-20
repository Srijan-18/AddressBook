package com.addressbook;

import java.util.Scanner;

class Address
{
	private String address;
	private String city;
	private String state;
	int zipcode;
	Scanner takeInput = new Scanner(System.in);
	public Address(String address, String city,String state,int zipcode)
	{
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
	}
	public Address()
	{
		this.setAddress();
		this.setCity();
		this.setState();
		this.setZipcode();
	}

	public void setAddress()
	{
		System.out.println("Enter House Number and Street :");
		address=takeInput.next();
	}
	public String getAddress()
	{
		return address;
	}
	public void setCity()
	{
		System.out.println("Enter City :");
		city=takeInput.next();
	}
	public String getCity()
	{
		return city;
	}
	public void setState()
	{
		System.out.println("Enter State :");
		state=takeInput.next();
	}
	public String getState()
	{
		return state;
	}
	public void setZipcode()
	{
		System.out.println("Enter Zipcode :");
		zipcode=takeInput.nextInt();
	}
	public int getZipcode()
	{
		return zipcode;
	}
public String savereturn()
{
	return address +"\n"+ "\n"+city +"\n"+ state +"\n"+ zipcode; 
}
	@Override
	public String toString() {
		return "Street=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode +".";
	}
	
}
