package com.addressbook;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
interface IAddressBookManager
{
	public void AddressBooksManagermenu();
	public void newAddressBook();
	public void openAddressBook();
	public void closeAdrressBook();
	public void saveAddressBook();
	public void saveAs();
	public void quit();
}
class AddressBookManager implements IAddressBookManager 
{
	String fileName;
	FileWriter fileWriter = null;
	Scanner takeInput=new Scanner(System.in);
	int numberOfAddBook=0;
	AddressBook addressBookObject=new AddressBook();
	public void AddressBooksManagermenu() 
	{
		boolean abmMenuloop=true;
		while(abmMenuloop==true)
		{
			   System.out.print( "\n\n\t\t    1 --> Add new AddressBook                    \n"
							   + "\t\t    2 --> Open an existing AddressBook           \n"
							   + "\t\t    3 --> Close current AddressBook              \n"
							   + "\t\t    4 --> Save current AdressBook                \n"
							   + "\t\t    5 --> Save Address Book with different name  \n"
							   + "\t\t    6 --> Delete AddressBook                     \n"
							   + "\t\t    7 --> Quit                                   \n");
			System.out.print("\n\t\t    ENTER YOUR CHOICE :");				   
			int userChoice=Integer.parseInt(takeInput.nextLine());
			switch (userChoice)
			{
				case 1:
					this.newAddressBook();
					numberOfAddBook++;
					this.saveAddressBook();
					 this.AddressBooksManagermenu();	
				break;	
				case 2:
					this.openAddressBook();
					 this.AddressBooksManagermenu();	
				break;
				case 3:
					this.closeAdrressBook();
					 this.AddressBooksManagermenu();	
				break;
				case 4:
					this.saveAddressBook();
					 this.AddressBooksManagermenu();	
				break;
				case 5:
					this.saveAs();
					 this.AddressBooksManagermenu();	
				break;	
				case 6:
					this.deleteAddressBook();
					 this.AddressBooksManagermenu();	
					numberOfAddBook--;
				break;
				case 7:
					System.out.print("\n\t\t    1 --> Save and Quit"
									+"\n\t\t    Any Other number to Quit without saving"
									+"\n\t\t    ENTER YOUR CHOICE : ");
					int quitChoice=Integer.parseInt(takeInput.nextLine());
					if(quitChoice==1)
					{
						this.saveAddressBook();
						this.quit();
					}
					else
					this.quit();
				break;
				default:
					System.out.print("\n\t\t\tINVALID INPUT");
			}	
		}
	}
	public void newAddressBook() 
	{	
		
		System.out.print("\t\t    Enter the name of AddressBook to create :");
		fileName=takeInput.next();
		try
		{
			fileWriter=new FileWriter(fileName+".csv");
		     addressBookObject.addPerson();
		     addressBookObject.addressBookMenu();
		}catch (Exception e)
		{
			System.out.print("\n\t\t    Error in Creating AdrressBook :");
			e.printStackTrace();
		}
}
	public void openAddressBook()
 {
		String[] fileNames;
		File fileObj=new File("F:\\Eclipse programs\\CodinClub");
		FilenameFilter filter = new FilenameFilter() {
	        @Override
	        public boolean accept(File f, String name) {
	            return name.endsWith(".csv");
	        }
	    };
		fileNames=fileObj.list(filter);
		int fileCount=-1;
		for(String file : fileNames)
		{
			if(fileCount==-1)
			{
				System.out.println("\n\t\t    AVAILABLE FILES ARE :");
				fileCount++;
			}
			System.out.print("\n\t\t    "+file);
			fileCount++;
		}
		if(fileCount>0)
		{	
			System.out.print("\n\n\t\t    Enter Addressbook name to open :");
			fileName=takeInput.nextLine();
			BufferedReader fileReader=null;
			ArrayList<Person> addressBookObj = new ArrayList<Person>();
			try {
					fileReader=new BufferedReader(new FileReader(fileName+".csv"));
					final int PERSON_ID= 0;
					final int PERSON_FIRSTNAME= 1;
					final int PERSON_LASTNAME= 2;
					final int PERSON_PHONE_NUMBER = 3;
					final int PERSON_ADDRESS = 4;
					
				    String line = "";
				    fileReader.readLine();  
				    while ((line = fileReader.readLine()) != null) {
				        String[] tokens = line.split(",");
				        if (tokens.length > 0) {
				          Person ab = new Person(
				              Integer.parseInt(tokens[PERSON_ID]), 
				              tokens[PERSON_FIRSTNAME],
				              tokens[PERSON_LASTNAME], 
				              Long.parseLong(tokens[PERSON_PHONE_NUMBER]),
				              tokens[PERSON_ADDRESS]);
				          
				          addressBookObj.add(ab);
				        }
				      }
				    for (Person person : addressBookObj) {
				        System.out.print("\n\n\t"+person);
				      }
				    
				    addressBookObject.addressBook=addressBookObj;
					addressBookObject.addressBookMenu(); 
				    
			}catch (Exception e)
			{
				System.out.print("\n\t\t    Error in Opening Addressbook");
				e.printStackTrace();
				System.out.println("\n\n");
				try
				{
					wait(1000);
				}catch (Exception e1)
				{
				}
				
			} 
			
				try 
				{
			        fileReader.close();
				} catch (IOException e) 
			      {
						System.out.print("\n\t\t    Closing fileReader Error!");
				    	e.printStackTrace();
				  }
		}
		else
		{
			System.out.print("\n\t\t    NO ADDRESS BOOK PRESENT");
			
		}
	}
	public void closeAdrressBook() 
{
		this.saveAddressBook();
		}
	@Override
	public void saveAddressBook() 
	{
		final String CSV_HEADER = "ID,First Name, Last Name,Phone Number,Address";
		
		 try
		 {	
			 fileWriter = new FileWriter(fileName+".csv");
			 fileWriter.append(CSV_HEADER);
			 fileWriter.append('\n');
	    
			 for (Person person : addressBookObject.addressBook)
			 {
			    fileWriter.append(String.valueOf(person.getId()));
				fileWriter.append(',');
		        fileWriter.append(person.getFirstName());
		        fileWriter.append(',');
		        fileWriter.append(person.getLastName());
		        fileWriter.append(',');
		        fileWriter.append(String.valueOf(person.getPhoneNumber()));
		        fileWriter.append(',');
		        fileWriter.append(person.getCompleteAddress().savereturn());
		        fileWriter.append('\n');	
			 }
			 fileWriter.close();
		}catch (Exception e)
			{
			e.printStackTrace();
			}
		 
	}
	@Override
	public void saveAs() 
	{
		System.out.print("\n\t\t    Enter New name of AddressBook to update :");
		fileName=takeInput.nextLine();
		final String CSV_HEADER = "ID,First Name, Last Name,PhoneNumber,Address";

		try
		{	
			fileWriter = new FileWriter(fileName+".csv");
			fileWriter.append(CSV_HEADER);
			fileWriter.append('\n');
	 		for (Person person : addressBookObject.addressBook)
	 		{
	 			fileWriter.append(String.valueOf(person.getId()));
	 			fileWriter.append(',');
	 			fileWriter.append(person.getFirstName());
	 			fileWriter.append(',');
	 			fileWriter.append(person.getLastName());
	 			fileWriter.append(',');
	 			fileWriter.append(String.valueOf(person.getPhoneNumber()));
		        fileWriter.append(',');
	 			fileWriter.append(person.getCompleteAddress().savereturn());
	 			fileWriter.append('\n');	
	 		}
	 		fileWriter.close();
		}catch (Exception e)
		{
			System.out.print("\n\t\t    Error in saving the entered AddressBook");
			e.printStackTrace();
		}
	}
	public void deleteAddressBook()
	{
		String[] fileNames;
		File fileObj=new File("F:\\Eclipse programs\\CodinClub");
		FilenameFilter filter = new FilenameFilter() {
	        @Override
	        public boolean accept(File f, String name) {
	            return name.endsWith(".csv");
	        }
	    };
		fileNames=fileObj.list(filter);
		int fileCount=-1;
		for(String file : fileNames)
		{
			if(fileCount==-1)
			{
				System.out.println("\n\t\t    AVAILABLE FILES ARE :");
				fileCount++;
			}
			System.out.print("\n\t\t    "+file);
			fileCount++;
		}
		if(fileCount>0)
		{	
			System.out.print("\n\t\t    Enter name of AddressBook to delete :");
			fileName=takeInput.nextLine();
			try
			{
				File addressBookDelete = new File(fileName+".csv");
				if(addressBookDelete.delete())
				System.out.print("\n\t\t    Deleted the file :" + addressBookDelete.getName());
			}catch(Exception e)
			{
				System.out.print("\n\t\t    Failed to delete the file with error");
				e.printStackTrace();
			}	
		}
		else
			System.out.print("\n\t\t    NO FILE TO DELETE");
	}	
	public void quit()
	{
		System.exit(0);
		
	}
}
