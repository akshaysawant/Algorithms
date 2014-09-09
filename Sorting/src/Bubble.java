/**
 * 
 */
import java.util.Scanner;

/**
 * @author akshaysawant
 *
 */
public class Bubble {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[10];
		int i,j,temp;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter 10 integers : ");
		for (i=0; i<10; i++)
			array[i] = in.nextInt();
		
		for (i=0; i<array.length; i++)
		{
			for (j=0; j<array.length; j++)
			{
				if(array[i] < array[j])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (i=0; i<array.length; i++)
			System.out.println("array element " +(i+1) +" = " +array[i]);
	}

}
