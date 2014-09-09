
import java.util.Arrays;
import java.util.Scanner;

public class LongestUniqueSubstring {
	
public static String LongestUSubstring(String S)
{
    int start_ind=0;
    int end_ind=0;
    int maxlength=0;
    
    boolean visited[] = new boolean[256];	// Maintains which character has occurred. 
    
    int i=0;
    int j=0;
    int str_len = S.length();
    
    for( ; (i<str_len) && (j<str_len) && (maxlength < str_len-i); i++)
    {
    	// Initialize to false.
        Arrays.fill(visited, false);

        // Set current character to true.
        visited[S.charAt(i)]=true;
        
        /* Iterate over the next character and check if it was already visited. */
        for( j=i+1; j<S.length() && (visited[S.charAt(j)] == false); j++)
        {
        	visited[S.charAt(j)]=true;
        }
        
        if( maxlength < j-i)
        {
            start_ind = i;
            end_ind = j;
            maxlength = j-i;
        }
    }
    return S.substring(start_ind, end_ind);
}


public static void main(String[] args)
{	
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the input String : ");
	String S = in.next();
    
	System.out.format("%s  has largest unique substring as  {%s}%n", S, LongestUSubstring(S));
}

}