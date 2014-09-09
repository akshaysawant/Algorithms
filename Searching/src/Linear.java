import java.util.Scanner;


public class Linear {

	public static void main(String[] args)
	{
		int[] a;
		int i, len, tgt, flag = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of elements of array : ");
		len = in.nextInt();
		
		a = new int[len];
		
		System.out.println("Enter the elements of the array : ");
		for (i=0; i<len; i++)
			a[i] = in.nextInt();
		
		System.out.println("Enter the element to be searched : ");
		tgt = in.nextInt();
		
		for (i=0; i<len; i++)
		{
			if (a[i] == tgt)
			{
				flag = 1;
				break;
			}
		}
		
		if (flag == 1)
			System.out.println("Target element "+ tgt +" found at "+ i+1 +" position.");
		else
			System.out.println("Target element "+ tgt +" not found.");
	}
}
