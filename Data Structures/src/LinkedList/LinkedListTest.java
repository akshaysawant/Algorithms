
package LinkedList;

import java.util.Scanner;


public class LinkedListTest {
	
	private static LinkedList ln = new LinkedList();
	
	public static void main(String[] args)
	{
		int choice = 0;	
		Scanner in = new Scanner(System.in);
		
		while (choice != 3)
		{
			System.out.println("Enter your choice : ");
			System.out.println("1. Insert  2. Delete  3. Exit");
			choice = in.nextInt();
			
			switch(choice)
			{
			case 1: insert();
					break;
					
			case 2: delete();
					break;
					
			case 3: break;
			}
		}
	}
	
	private static void insert()
	{
		int choice = 0, val, pos;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter value to be inserted.");
		val = in.nextInt();
		
		System.out.println("Enter your choice for Insert position : ");
		System.out.println("1. At Start   2. At End   3. Specify position");
		choice = in.nextInt();
		
		switch(choice)
		{
		case 1: ln.insertAtStart(val);
				break;
				
		case 2: ln.insertAtEnd(val);
				break;
				
		case 3: System.out.println("Enter position at which value is to be inserted.");
				pos = in.nextInt();
				ln.insertAtPos(pos, val);
				break;
		}
	}
	
	private static void delete()
	{
		int choice = 0, val, pos;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your choice for Delete position : ");
		System.out.println("1. At Start   2. At End   3. Specify position   4. By Value");
		choice = in.nextInt();
		
		switch(choice)
		{
		case 1: ln.deleteAtStart();
				break;
				
		case 2: ln.deleteAtEnd();
				break;
				
		case 3: System.out.println("Enter position at which value is to be deleted.");
				pos = in.nextInt();
				ln.deleteAtPos(pos);
				break;
				
		case 4: System.out.println("Enter position at which value is to be deleted.");
				val = in.nextInt();
				ln.deleteByValue(val);
				break;
		}
	}
}
