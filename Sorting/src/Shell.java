import java.util.Scanner;


public class Shell 
{
	public static void main(String[] args)
	{
		int[] array = new int[10];
		int i;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<10; i++)
			array[i] = in.nextInt();
		
		shellsort(array, array.length);
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}
	
	private static void shellsort(int[] a, int n)
	{
		int i, j, temp, gap;
		
		gap = n/2;
		
		while (gap > 0)
		{
		    for (i = gap; i < n; i += 1)
		    {
		        temp = a[i];
		        for (j = i; j >= gap && a[j - gap] > temp; j -= gap)
		        {
		            a[j] = a[j - gap];
		        }
		        a[j] = temp;
		    }
		    
		    gap /= 2;
		}
	}
	
	private static void shell(int[] a, int len)
	{
		int i, j, gap, max;
		
		gap = len/2;
		
		/* Reducing the gap */
		while(gap > 0)
		{
			for (i=gap; i<len; i++)
			{
				max = a[i];
								
				for (j = i; j >= gap; j-=gap)
				{
					if(a[j-gap] < max)
					{
						a[j] = a[j-gap];
					}
				}
				a[j] = max;
			}
			
			gap = gap/2;
		}
	}
}
