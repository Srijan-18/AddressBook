package com.addressbook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
interface IAddressBook
{
	public void addPerson();
	public void editPerson();
	public void deletePerson();
	public void sortAddressBookByZip();
	public void sortAddressBookByLastName();
	public void printAddressBook();
	public void addressBookMenu();
}
class AddressBook implements IAddressBook
{
	ArrayList<Person> addressBook;
	Scanner takeInput=new Scanner(System.in);
	public void addPerson()
	{	
		Person currentPerson=new Person();
		addressBook.add(currentPerson);
	}
	public void editPerson() 
	{
		System.out.println("Enter the ID of entry to edit :");
		int searchId=takeInput.nextInt();
		for(int i=0;i<addressBook.size();i++)
		{	
			Person currentPerson=addressBook.get(i);
			if(currentPerson.getId() == searchId)
			{
			System.out.println("Enter 1 to edit PhoneNumber\n"
					          +"Enter 2 to edit Street Address\n"
					          +"Enter 3 to edit City\n"
					          +"Enter 4 to edit State\n"
					          +"Enter 5 to edit zip code\n");
			int choice=takeInput.nextInt();
			switch (choice)
			{
				case 1:
					currentPerson.setPhoneNumber();
				break;
				case 2:
					currentPerson.completeAddress.setAddress();
				break;
				case 3:
					currentPerson.completeAddress.setCity();
				break;
				case 4:
					currentPerson.completeAddress.setState();
				break;
				case 5:
					currentPerson.completeAddress.setZipcode();
				break;
				default:
					System.out.println("INVALID INPUT");
			}		
			}
			}
		}

	public void deletePerson() 
	{
		System.out.println("Enter the ID of entry to delete :");
		int searchId=takeInput.nextInt();
		for(int i=0;i<addressBook.size();i++)
		{	
			Person currentPerson=new Person();
			if(currentPerson.getId() == searchId)
			{
				addressBook.remove(i);
			}
		}
	}

	public void sortAddressBookByZip() 
	{
		for (int i=0;i<addressBook.size();i++)
		{
			for (int j=1;j<addressBook.size()-i;j++)
			{
				if(addressBook.get(j-1).completeAddress.zipcode > addressBook.get(j).completeAddress.zipcode)
				{
					Collections.swap(addressBook, j-1, j);
				}
				else if(addressBook.get(j-1).completeAddress.zipcode == addressBook.get(j).completeAddress.zipcode)
				{
					if(addressBook.get(j-1).firstName.compareTo(addressBook.get(j).firstName)>0)
							{
								Collections.swap(addressBook, j-1, j);
							}
				}
			}
		}
	}
	public void sortAddressBookByLastName() 
	{
		for (int i=0;i<addressBook.size();i++)
		{
			for (int j=1;j<addressBook.size()-i;j++)
			{
				if(addressBook.get(j-1).lastName.compareTo(addressBook.get(j).lastName)>0)
				{
					Collections.swap(addressBook, j-1, j);
				}
				else if(addressBook.get(j-1).completeAddress.zipcode == addressBook.get(j).completeAddress.zipcode)
				{
					if(addressBook.get(j-1).firstName.compareTo(addressBook.get(j).firstName)>0)
							{
								Collections.swap(addressBook, j-1, j);
							}
				}
			}
		}
		
	}
	public void printAddressBook() {
		
		for (int i=0;i<addressBook.size();i++)
		{
			System.out.println(addressBook.get(i));
		}
	}
	@Override
	public void addressBookMenu() 
	{
		System.out.println("Enter 1 to add person\n"
						 + "Enter 2 to delete person\n"
						 + "Enter 3 to sort Address Book\n"
						 + "Enter 4 to Print Address Book\n"
						 + "Enter any other number to go to previous menu\n");
		int choice=takeInput.nextInt();
		switch(choice)
		{
			case 1:
				this.addPerson();
			break;
			case 2:
				this.deletePerson();
			break;
			case 3:
				boolean sortloop=true;
				while(sortloop==true)
				{	
					System.out.println("Enter 1 to Sort by ZipCode\n"
									  +"Enter 2 to Sort by Last Name\n");
					int sortChoice=takeInput.nextInt();
					switch(sortChoice)
					{
						case 1:
							this.sortAddressBookByZip();
							sortloop=false;
						break;
						case 2:
							this.sortAddressBookByLastName();
							sortloop=false;
						break;
						default :
							System.out.println("INVALID INPUT");
					}
				}
			break;
			case 4:
				this.printAddressBook();
			break;
			default :
				break;
		}	
	}
}
