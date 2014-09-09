import java.util.Scanner;


public class Quick {
	public static void main(String[] args)
	{
		int[] array = new int[10];
		int i;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<10; i++)
			array[i] = in.nextInt();
		
		quick(array, 0, array.length-1);
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}

	private static void quick(int[] a, int start, int end)
	{
		int i, pIndex, pivot, temp;
	
		if (start >= end)
			return;
		
		pIndex = start;
		pivot = a[end];
		
		for(i=start; i<end; i++)
		{
			if(a[i] <= pivot)
			{
				temp = a[i];
				a[i] = a[pIndex];
				a[pIndex++] = temp;
			}
		}
		
		temp = a[end];
		a[end] = a[pIndex];
		a[pIndex] = temp;
		
		quick(a, start, pIndex-1);
		quick(a, pIndex+1, end);
	}
}
