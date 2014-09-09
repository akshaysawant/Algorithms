package Stack;

import java.util.NoSuchElementException;


public class Stack {
	
	private int[] a;
	private int size;
	private int capacity;
	
	public Stack(int capacity)
	{
		a = new int[capacity];
		this.capacity = capacity;
	}
	
	public void push(int num)
	{
		int i;
		
		if (size < capacity)
		{
			a[size++] = num;
		
			System.out.println("Added new element.");
			System.out.println("Updated array is :");
		
			for (i=0; i<size; i++)
				System.out.println("array[" + i + "] = " +a[i]);
		}
		else
			System.out.println("Stack is full. Cannot push new element.");
	}
	
	public int pop() throws NoSuchElementException
	{
		int val;
		
		if (size == 0)
			throw new NoSuchElementException("Cannot pop from empty Stack.");
		else
		{
			val = a[size-1];
			size--;
			
			System.out.println("Popped element is "+ val);

			return val;	
		}
	}
}
