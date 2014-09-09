import java.util.Scanner;


public class Heap {
	public static void main(String[] args)
	{
		int[] array;
		int i, num=0;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		num = in.nextInt();
		array = new int[num];
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<num; i++)
			array[i] = in.nextInt();
		
		heap(array, array.length);
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}
	
	private static void heap(int[] a, int len)
	{
		int end, temp;
		
		buildheap(a, len-1);
		end = len - 1;
		
		while (end > 0)
		{
			/* Swap the root with last element */
			temp = a[end];
			a[end] = a[0];
			a[0] = temp;
			
			end--;
			heapify(a, 0, end);
		}
	}
	
	private static void buildheap(int[] a, int count)
	{
		int i;
		
		for(i=(count/2); i>=0; i--)
		{
			heapify(a, i, count);
		}
	}
	
	private static void heapify(int[] a, int parent, int j)
	{
		int temp, k;
		
		if ((parent*2+1) > j) return;
		if ((parent*2+2) > j) 
			k = (parent*2+1);
		else
		{
			if(a[(parent*2)+1] > a[(parent*2)+2])
				k = (parent*2)+1;
			else
				k = (parent*2)+2;
		}
		
		if (a[parent] < a[k])
		{
			temp = a[parent];
			a[parent] = a[k];
			a[k] = temp;
			
			heapify(a, k, j);
		}
	}
}
