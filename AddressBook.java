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
	ArrayList<Person> addressBook=new ArrayList<Person>();
	Scanner takeInput=new Scanner(System.in);
	public void addPerson()
	{	
		System.out.print("\n\t\t   Details of Individuals");
		Person currentPerson=new Person();
		addressBook.add(currentPerson);
	}
	public void editPerson() 
	{
		System.out.print("\n\t\t   Enter the ID of entry to edit :");
		int searchId=takeInput.nextInt();
		for(int i=0;i<addressBook.size();i++)
		{	
			Person currentPerson=addressBook.get(i);
			if(currentPerson.getId() == searchId)
			{
			System.out.print("\n\t\t   1 --> edit PhoneNumber\n"
					          +"\t\t   2 --> edit Street Address\n"
					          +"\t\t   3 --> edit City\n"
					          +"\t\t   4 --> edit State\n"
					          +"\t\t   5 --> edit zip code\n");
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
					System.out.print("\n\t\t   INVALID INPUT");
			}		
			}
			}
		}

	public void deletePerson() 
	{	
		if(addressBook.size()>0)
		{
			System.out.print("\n\t\t   Enter the ID of entry to delete :");
			int searchId=takeInput.nextInt();
			for(int i=0;i<addressBook.size();i++)
			{	
				if(addressBook.get(i).getId() == searchId)
				{
					addressBook.remove(i);
				}
			}
		}
		else
			System.out.print("\n\t\t   NO ENTRY TO DELETE");
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
				if(addressBook.get(j-1).lastName.compareToIgnoreCase((addressBook.get(j).lastName))>0)
				{
					Collections.swap(addressBook, j-1, j);
				}
				else if(addressBook.get(j-1).lastName.compareToIgnoreCase((addressBook.get(j).lastName))==0)
				{
					if(addressBook.get(j-1).firstName.compareTo(addressBook.get(j).firstName)>0)
							{
								Collections.swap(addressBook, j-1, j);
							}
				}
			}
		}
		
	}
	public void printAddressBook() 
	{
		if(addressBook.size()>0)
		{	
			for (int i=0;i<addressBook.size();i++)
			{
				System.out.println("\n"+addressBook.get(i));
			}
		}
		else
			System.out.print("\n\t\t   NO ENTRIES TO DISPLAY\n");
	}
	@Override
	public void addressBookMenu() 
	{
		boolean menuloop=true;
		while (menuloop==true)
		{
			System.out.print( "\n\t\t   1 --> add person"
						 	+ "\n\t\t   2 --> delete person"
						 	+ "\n\t\t   3 --> sort Address Book"
						 	+ "\n\t\t   4 ---> Print Address Book"
							+ "\n\t\t   Any other number to go to previous menu\n");
			System.out.print("\n\t\t   ENTER YOUR CHOICE :");
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
						System.out.print("\n\t\t   1 --> Sort by ZipCode\n"
										+"\n\t\t   2 --> Sort by Last Name\n");
						System.out.print("\n\t\t   ENTER YOUR CHOICE :");
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
								System.out.print("\n\t\t INVALID INPUT");
						}
					}
				break;
				case 4:
					this.printAddressBook();
					break;
				default :
					menuloop=false;
			}	
		}
	}
}	
