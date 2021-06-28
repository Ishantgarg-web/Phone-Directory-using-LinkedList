import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.soap.Node;


/****  REMAINING   ****
 * 
 * @author ishant
 * 1. check entered mobile number is previously present or not
 * 2. check entered name is previously present or not
 * 3. show suggestions feature
 * 4. At each and every place, there check for name and mobile number
 * 5. check Email condition
 * 6. use regular expression
 * 7. Finally Make document
 */

class LinkedList
{
	Node head,tail;
	static class Node
	{
		String name;
		String mobileno;
		String email,workplace;
		Node next,prev;
		Node(String n,String m,String e,String w)
		{
			name=n;
			mobileno=m;
			email=e;
			workplace=w;
		}
	}
	
	//insert data
	static LinkedList list=new LinkedList();
	public static ArrayList<String> take_input_from_user()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Name: ");
		MainPage mainobj = new MainPage();
		String name_of_contact = input.next();
		
		while(mainobj.checknameofcontact(name_of_contact)==false)
		{
			System.out.println("Enter valid Name: ");
			name_of_contact = input.next();
		}
		
		
		System.out.println("Enter Mobile Number: ");
		String mobile_no_of_contact="";
		mobile_no_of_contact=input.next();
		while(mainobj.checkmobilenumber(mobile_no_of_contact)==false)
		{
			System.out.println("Enter valid Mobile Number- This may be use previous: ");
			mobile_no_of_contact=input.next();
		}
		
		
		System.out.println("Enter E-Mail: ");
		String email_of_contact = input.next();
		/*
		while(checkemailofcontact(email_of_contact)==false)
		{
			System.out.println("Enter valid E-Mail: ");
			email_of_contact = input.next();
		}
		*/
		
		System.out.println("Enter Workplace: ");
		String workplace_of_contact = input.next();
		input.nextLine();
		while(mainobj.checkworkplaceofcontact(workplace_of_contact)==false)
		{
			System.out.println("Enter valid Workplace: ");
			workplace_of_contact = input.nextLine();
		}
		ArrayList<String> al=new ArrayList<String>();
		al.add(name_of_contact);
		al.add(mobile_no_of_contact);
		al.add(email_of_contact);
		al.add(workplace_of_contact);
		return al;
	}
	//insert node to linked list
	public static void insertnodetolinkedlist(LinkedList list,String a,String b,String c,String d)
	{
		Node newnode = new Node(a,b,c,d);
		if(list.head==null)
		{
			list.head=newnode;
			list.tail=newnode;
		}
		else
		{
			list.tail.next=newnode;
			Node temp=list.tail;
			list.tail=list.tail.next;
			list.tail.prev=temp;
		}
	}
	//print linkedlist
	public static void printlinkedlist(LinkedList list)
	{
		if(list.head!=null)
		{
			Node curr=list.head;
			while(curr!=null)
			{
				System.out.print("Name: "+curr.name+"\n"+"Mobile Number: "+curr.mobileno+"\n");
				curr=curr.next;
			}
			System.out.println();
		}
		else
		{
			System.out.println("Sorry!!But there is no contact in your Directory.");
		}
	}
	
	//Delete contact from given LinkedList
	public static void delete_node_from_linkedlist(LinkedList list,String s)
	{
		if(list.head == null)
		{
			System.out.println("There is no contact in your directory");
			return;
		}
		Node curr=list.head;
		while(curr!=null && (curr.name.toUpperCase().equals(s.toUpperCase()))==false)
		{
			curr=curr.next;
		}
		if(curr == null)
		{
			System.out.println("There is no Contact in the Linked List");
		}
		else if(curr.name.toUpperCase().equals(s.toUpperCase()))
		{
			//System.out.println("In intermediate...");
			if(curr == list.head)
			{
				list.head=list.head.next;
				if(list.head!=null) {list.head.prev=null;}
			}
			else if(curr.next == null)
			{
				curr.prev.next=null;
			}
			else {
			Node prev_node = curr.prev;
			Node next_node = curr.next;
			curr.next = next_node;
			next_node.prev = prev_node;}
			System.out.println("!!!!! Contact Deleted Successfully !!!!!");
		}
	}
	
	//	update_details_by_name
	public static void update_details_by_name(LinkedList list,String s)
	{
		Scanner input=new Scanner(System.in);
		if(list.head == null)
		{
			System.out.println("There is no contact in your directory");
			return;
		}
		Node curr=list.head;
		while(curr!=null && (curr.name.toUpperCase().equals(s.toUpperCase()))==false)
		{
			curr=curr.next;
		}
		if(curr == null)
		{
			System.out.println("There is no Contact in the Linked List");
		}
		else
		{
			System.out.println("Choose options for which you want to update details");
			System.out.println("1. Update Mobile Number"
					+ "\n2. Update Email"
					+ "\n3. Update Work-Place"
					+ "\n4. Exit");
			int choose_update = input.nextInt();
			while(choose_update<4 && choose_update>0)
			{
				if(choose_update == 1)
				{
					System.out.println("Your Current Mobile Number is: "+curr.mobileno);
					System.out.println("Please Enter New Mobile Number: ");
					String update_new_mobile_number = input.next();
					curr.mobileno = update_new_mobile_number;
					System.out.println("Mobile Number is Updated Successfully");
				}
				else if(choose_update == 2)
				{
					System.out.println("Your Current E-Mail is: "+curr.email);
					System.out.println("Please Enter New E-Mail: ");
					String update_new_email = input.next();
					curr.email = update_new_email;
					System.out.println("Email is Updated Successfully");
				}
				else if(choose_update == 3)
				{
					System.out.println("Your Current Workplace is: "+curr.workplace);
					System.out.println("Please Enter New WorkPlace: ");
					String update_new_workplace = input.next();
					curr.mobileno = update_new_workplace;
					System.out.println("Work Place is Updated Successfully");
				}
				System.out.println("Choose options for which you want to update details");
				System.out.println("1. Update Mobile Number"
						+ "\n2. Update Email"
						+ "\n3. Update Work-Place"
						+ "\n4. Exit");
				choose_update = input.nextInt();
			}
			return;
		}
	}
	
	//Search By Name
	public static void search_by_name(LinkedList list)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please Enter Name for which you want to search name");
		String search_name = input.next();
		Node curr = list.head;
		while(curr!=null && curr.name.toUpperCase().equals(search_name.toUpperCase())==false)
		{
			curr=curr.next;
		}
		if(curr == null)
		{
			System.out.println("There is no Contact with given Name");
		}
		else
		{
			System.out.println("Contact is found Successfully");
			System.out.println("1. Name of Contact: "+curr.name);
			System.out.println("2. Mobile Number of Contact: "+curr.mobileno);
			System.out.println("3. Email of Contact: "+curr.email);
			System.out.println("4. WorkPlace of Contact: "+curr.workplace);
		}
	}
	
	//search_by_mobile_number
	public static void search_by_mobile_number(LinkedList list)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please Enter Mobile number by which you want to search");
		String mobile_no_search = input.next();
		if(list.head == null)
		{
			System.out.println("There is no contact in your directory");
		}
		else
		{
			Node curr=list.head;
			while(curr!=null && curr.mobileno.equals(mobile_no_search)==false)
			{
				curr=curr.next;
			}
			if(curr == null)
			{
				System.out.println("Sorry!!There is no contact with given mobile number");
			}
			else
			{
				System.out.println("Contact is found Successfully");
				System.out.println("1. Name of Contact: "+curr.name);
				System.out.println("2. Mobile Number of Contact: "+curr.mobileno);
				System.out.println("3. Email of Contact: "+curr.email);
				System.out.println("4. WorkPlace of Contact: "+curr.workplace);
			}
		}
	}
	
	//search_by_email
	public static void search_by_email(LinkedList list)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Please Enter E-Mail for which you want to search");
		String email_search = input.next();
		if(list.head==null)
		{
			System.out.println("There is no contact in your directory");
		}
		else
		{
			Node curr=list.head;
			while(curr!=null)
			{
				while(curr!=null && curr.email.equals(email_search)==false)
				{
					curr=curr.next;
				}
				if(curr==null)
				{
					System.out.println("Sorry!!There is no contact with given mobile number");
					return;
				}
				else
				{
					System.out.println("Contact is found Successfully");
					System.out.println("1. Name of Contact: "+curr.name);
					System.out.println("2. Mobile Number of Contact: "+curr.mobileno);
					System.out.println("3. Email of Contact: "+curr.email);
					System.out.println("4. WorkPlace of Contact: "+curr.workplace);
					curr=curr.next;
				}	
			}
		}
	}
	
}




//Main Class
public class MainPage {
	
	//checknameofcontact
	//static LinkedList list=new LinkedList();
//	static Node obj_node=new Node();
	//LinkedList.Node main_obj =new LinkedList.Node(null, null, null, null);
	public static boolean checknameofcontact(String s)
	{
		
		for (int i=0;i<s.length();i++)
		{
			if((s.charAt(i)>=65 && s.charAt(i)<=90) || (s.charAt(i)>=97 && s.charAt(i)<=122))
			{
				continue;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	//checkmobilenumber
	public static boolean checkmobilenumber(String s)
	{
		if(s.length()!=10)
		{
			return false;
		}
		else
		{
			if(s.charAt(0)=='0')
			{
				return false;
			}
			else
			{
				for (int i=1;i<10;i++)
				{
					if(s.charAt(i)>=48 && s.charAt(i)<=57)
					{
						continue;
					}
					else {return false;}
				}
				return true;
			}
		}
	}
	
	//checkemailofcontact
	/*
	public static boolean checkemailofcontact(String email)
	{
		int i=0;
		for (i=0;i<email.length();i++)
		{
			if(email.charAt(i)=='@')
			{
				System.out.println(email.substring(i+1));
				if(email.substring(i+1).equals("gmail.com"))
				{
					return true;
				}
				else{return false;}
			}
			else{return false;}
		}
		return false;
	}
	*/
	//checkworkplaceofcontact
	public static boolean checkworkplaceofcontact(String s)
	{
		if(s.length()==0)
		{
			return false;
		}
		return true;
	}
	
	public static void show_internal_options()
	{
		//shows options
		System.out.println("\n\n\n1. Display your phone book\n2. Insert New Contact"
				+ "\n3. Delete Contact"
				+ "\n4. Update details on existing contact"
				+ "\n5. Search Contact Details"
				+ "\n6. EXIT");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("||||||||| WELCOME TO PHONE DIRECTORY MANAGEMENT PROJECT|||||||\n\n\n\n\n");
		System.out.println("Please Enter Your Name");
		String name_start=input.next();
		System.out.println("*********Welcome "+name_start+"*********\n\n\n\n");
		System.out.println("Let's Create our PhoneBook!!!\n\n\n");
		boolean repeating_loop = true;
		
		LinkedList list = new LinkedList();
		
		while(repeating_loop){
			
			//Node temp1=new Node();
			ArrayList<String> al1=new ArrayList<String>();
			al1=list.take_input_from_user();
			list.insertnodetolinkedlist(list,al1.get(0), al1.get(1), al1.get(2), al1.get(3));
			
			System.out.println("Do You Want To Continue??? 1 for yes");
			int repeat_loop_check = input.nextInt();
			if(repeat_loop_check == 1)
			{
				repeating_loop = true;
			}
			else
			{
				repeating_loop = false;
			}
		}
		show_internal_options();
		
		int choose_from_menu = input.nextInt();
		while(choose_from_menu!=6)
		{
			if(choose_from_menu == 1)
			{
				list.printlinkedlist(list);
			}
			else if(choose_from_menu == 2)
			{
				ArrayList<String> al1=new ArrayList<String>();
				al1=list.take_input_from_user();
				list.insertnodetolinkedlist(list,al1.get(0), al1.get(1), al1.get(2), al1.get(3));
			}
			else if(choose_from_menu == 3)
			{
				System.out.println("Please Enter Name: ");
				String name_of_delete = input.next();
				list.delete_node_from_linkedlist(list, name_of_delete);
			}
			else if(choose_from_menu == 4)
			{
				System.out.println("Please Enter Name for which you want to update...");
				//suggestion features will be enabled
				String update_name = input.next();
				list.update_details_by_name(list, update_name);
			}
			else if(choose_from_menu == 5)
			{
				System.out.println("Choose Options for which you want to search details\n");
				System.out.println("1. Search By Name\n2. Search By Mobile Number\n3. Search By Email\n4. Search By WorkPlace\n5. EXIT");
				int choose_search = input.nextInt();
				while(choose_search>=1 && choose_search<5)
				{
					if(choose_search == 1)
					{
						list.search_by_name(list);
					}
					else if(choose_search == 2)
					{
						list.search_by_mobile_number(list);
					}
					else if(choose_search == 3)
					{
						list.search_by_email(list);
					}
					choose_search = input.nextInt();
				}
				return;
			}
			
			show_internal_options();
			choose_from_menu = input.nextInt();
		}
		
		
		
		
		
		
	}

}
