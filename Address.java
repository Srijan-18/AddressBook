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
		System.out.print("\n\t\t   Enter House Number and Street :");
		address=takeInput.nextLine();
	}
	public String getAddress()
	{
		return address;
	}
	public void setCity()
	{
		System.out.print("\n\t\t   Enter City :");
		city=takeInput.nextLine();
	}
	public String getCity()
	{
		return city;
	}
	public void setState()
	{
		System.out.print("\n\t\t   Enter State :");
		state=takeInput.nextLine();
	}
	public String getState()
	{
		return state;
	}
	public void setZipcode()
	{
		System.out.print("\n\t\t   Enter Zipcode :");
		zipcode=takeInput.nextInt();
	}
	public int getZipcode()
	{
		return zipcode;
	}
public String savereturn()
{
	return address +":"+city +":"+ state +":"+ zipcode; 
}
	@Override
	public String toString() {
		return "\"H.No. & Street: "+ address + "\tCity: " + city + "\tState: " + state + "\tZipcode: " + zipcode +"\"";
	}
	
}
