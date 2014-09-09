import java.util.Scanner;



public class Selection {

	public static void main(String[] args)
	{
		int[] array = new int[10];
		int i,j,temp,min,index;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<10; i++)
			array[i] = in.nextInt();
		
		for (i=0; i<array.length-1; i++)
		{
			min = array[i];
			index = i;
			
			for (j=i+1; j<array.length; j++)
			{	
				if(array[j] < min)
				{
					min = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}
}
