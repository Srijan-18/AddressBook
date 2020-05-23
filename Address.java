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
		System.out.print("\n\t\t    Enter H.No. and Area :");
		String address=takeInput.nextLine();
		this.setAddress(address);
		System.out.print("\n\t\t    Enter City :");
		String city=takeInput.nextLine();
		this.setCity(city);
		System.out.print("\n\t\t    Enter State :");
		String state=takeInput.nextLine();
		this.setState(state);
		System.out.print("\n\t\t    Enter Zipcode : ");
		int zipcode=Integer.parseInt(takeInput.next());
		this.setZipcode(zipcode);
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return address;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public String getCity()
	{
		return city;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public String getState()
	{
		return state;
	}
	public void setZipcode(int zipcode)
	{
		this.zipcode=zipcode;
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
