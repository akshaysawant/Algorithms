import java.util.Scanner;

/*
 * Input - 23 39 40 57 84 92 104 128 238 837
 * */

public class Binary {
	
	public static void main(String[] args)
	{
		int[] a;
		int i, len, tgt, index = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of elements of array : ");
		len = in.nextInt();
		
		a = new int[len];
		
		System.out.println("Enter the elements of the array : ");
		for (i=0; i<len; i++)
			a[i] = in.nextInt();
		
		System.out.println("Enter the element to be searched : ");
		tgt = in.nextInt();
		
		index = binary(a, 0, len, tgt);
		
		if (index != -1)
			System.out.println("Target element "+ tgt +" found at "+ (index+1) +" position.");
		else
			System.out.println("Target element "+ tgt +" not found.");
	}
	
	private static int binary(int[] a, int start, int end, int tgt)
	{
		int index, mid;
		
		index = 0;
		if (start > end)
			return -1;
		else
		{
			mid = (start + end) / 2;
		
			if (a[mid] == tgt)
				return mid;
			if(tgt < a[mid])
				index = binary(a, start, mid-1, tgt);
			if(tgt > a[mid])
				index = binary(a, mid+1, end, tgt);
		}
		
		return index;
	}
}
