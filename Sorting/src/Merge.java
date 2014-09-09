import java.util.Scanner;


public class Merge {
	public static void main(String[] args)
	{
		int[] array = new int[4];
		int i;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter list of integers : ");
		for (i=0; i<4; i++)
			array[i] = in.nextInt();
		
		mergesort(array, 0, array.length);
		
		for (i=0; i<array.length; i++)
			System.out.println("array[" + i + "] = " +array[i]);
	}
	
	private static void mergesort(int[] a, int start, int len)
	{
		int n1, n2;
		
		if(len == 1)
			return;
		
		n1 = len/2;
		n2 = len-n1;
		
		mergesort(a, start, n1);
		mergesort(a, start+n1, n2);
		
		merge(a, start, n1, n2);
		
	}
	
	private static void merge(int[] a, int start, int n1, int n2)
	{
		int i=0,j=0,k=0;
		int Ln, Rn;
		int[] temp = new int[n1+n2];
		
		Ln = start;
		Rn = start+n1;
		
		while((i<n1) && (j<n2))
		{
			if(a[Ln+i] < a[Rn+j])
				temp[k] = a[Ln+i++];
			else
				temp[k] = a[Rn+j++];
			k++;
		}
		
		while(i<n1)
		{
			temp[k++] = a[Ln+i++];
		}
		
		while(j<n2)
		{
			temp[k++] = a[Rn+j++];
		}
		
		for (i=0; i<n1+n2; i++)
			a[start+i] = temp[i];
	}
}
