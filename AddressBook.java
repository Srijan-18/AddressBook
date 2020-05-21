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
<<<<<<< HEAD
	ArrayList<Person> addressBook;
	Scanner takeInput=new Scanner(System.in);
	public void addPerson()
	{	
=======
	ArrayList<Person> addressBook=new ArrayList<Person>();
	Scanner takeInput=new Scanner(System.in);
	public void addPerson()
	{	
		System.out.print("\n\t\t   Details of Individuals");
>>>>>>> Address
		Person currentPerson=new Person();
		addressBook.add(currentPerson);
	}
	public void editPerson() 
	{
<<<<<<< HEAD
		System.out.println("Enter the ID of entry to edit :");
=======
		System.out.print("\n\t\t   Enter the ID of entry to edit :");
>>>>>>> Address
		int searchId=takeInput.nextInt();
		for(int i=0;i<addressBook.size();i++)
		{	
			Person currentPerson=addressBook.get(i);
			if(currentPerson.getId() == searchId)
			{
<<<<<<< HEAD
			System.out.println("Enter 1 to edit PhoneNumber\n"
					          +"Enter 2 to edit Street Address\n"
					          +"Enter 3 to edit City\n"
					          +"Enter 4 to edit State\n"
					          +"Enter 5 to edit zip code\n");
=======
			System.out.print("\n\t\t   1 --> edit PhoneNumber\n"
					          +"\t\t   2 --> edit Street Address\n"
					          +"\t\t   3 --> edit City\n"
					          +"\t\t   4 --> edit State\n"
					          +"\t\t   5 --> edit zip code\n");
>>>>>>> Address
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
<<<<<<< HEAD
					System.out.println("INVALID INPUT");
=======
					System.out.print("\n\t\t   INVALID INPUT");
>>>>>>> Address
			}		
			}
			}
		}

	public void deletePerson() 
<<<<<<< HEAD
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
=======
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
>>>>>>> Address
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
<<<<<<< HEAD
				if(addressBook.get(j-1).lastName.compareTo(addressBook.get(j).lastName)>0)
				{
					Collections.swap(addressBook, j-1, j);
				}
				else if(addressBook.get(j-1).completeAddress.zipcode == addressBook.get(j).completeAddress.zipcode)
=======
				if(addressBook.get(j-1).lastName.compareToIgnoreCase((addressBook.get(j).lastName))>0)
				{
					Collections.swap(addressBook, j-1, j);
				}
				else if(addressBook.get(j-1).lastName.compareToIgnoreCase((addressBook.get(j).lastName))==0)
>>>>>>> Address
				{
					if(addressBook.get(j-1).firstName.compareTo(addressBook.get(j).firstName)>0)
							{
								Collections.swap(addressBook, j-1, j);
							}
				}
			}
		}
		
	}
<<<<<<< HEAD
	public void printAddressBook() {
		
		for (int i=0;i<addressBook.size();i++)
		{
			System.out.println(addressBook.get(i));
		}
=======
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
>>>>>>> Address
	}
	@Override
	public void addressBookMenu() 
	{
<<<<<<< HEAD
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
=======
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
>>>>>>> Address
