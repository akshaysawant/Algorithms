import java.util.Scanner;
import java.util.ArrayList;
/*
 * Input - 23 5 32 65 8752 4 143 67 13 356
 * */

public class Radix {
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
		
		radix(array, array.length);
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}
	
	private static void radix(int[] a, int len)
	{
		int m = 10;
		int i, j, k;
		int n = 1;
		int flag = 0, mod, idx;
		
		do
		{
			flag = 0;
			ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
			for(i=0; i<10; i++)
				b.add(new ArrayList<Integer>());
			
			for(i=0; i<len; i++)
			{
				mod = a[i] % m;
				idx = mod / n;
				
				b.get(idx).add(a[i]);
			}
			
			k = 0;
			for(i=0; i<10; i++)
			{
				j = 0;
				while(!b.get(i).isEmpty())
				{
					a[k++] = b.get(i).get(0);
					b.get(i).remove(j);
					
					if (i > 0)
						flag = 1;
				}
			}
			m = m * 10;
			n = n * 10;
			
		}while(flag == 1);
	}
}
