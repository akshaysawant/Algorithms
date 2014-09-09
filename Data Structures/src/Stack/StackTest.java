package Stack;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class StackTest {
	public static void main(String[] args)
	{
		int size, choice = 0, num = 0;	
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the size of Stack : ");
		size = in.nextInt();
		Stack s = new Stack(size);
		
		while (choice != 3)
		{
			System.out.println("Enter your choice : ");
			System.out.println("1. Push  2. Pop  3. Exit");
			choice = in.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter number to push : ");
					num = in.nextInt();
					s.push(num);
					break;
					
			case 2: num = s.pop();
					break;
					
			case 3: break;
			}
		}
	}
}
