import java.util.Scanner;

/*
 * Input - 23 5 32 65 8752 4 143 67 13 356
 * */

public class Insertion
{
	public static void main(String[] args)
	{
		int[] array = new int[10];
		int i, j, cur;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<10; i++)
			array[i] = in.nextInt();
		
		for (i=1; i<array.length; i++)
		{
			cur = array[i];
			j = i-1;
			while((j>=0) && (array[j] > cur))
			{	
				array[j+1] = array[j];
				j--;
				array[j+1] = cur;
				/*temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				cur = array[j--];*/
			}
		}
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}

}
