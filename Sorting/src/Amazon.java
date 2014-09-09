import java.util.HashMap;


public class Amazon {

	public void secondLargetNumber (Node n)
	{
		Node p = n;
		while (n.right != NULL)
			n = n.right;
		
		Node result = inorderPred(n);
		HashMap 
	}
	
	HashMap<String, Integer> novel = new HashMap<String, Integer>();

	public void insertHash(String word)
	{
		if (novel.containsKey(word))
			novel.put(word, novel.get(word)+1);
		else
			novel.put(word, 1);
	}

	public int search(String word)
	{
		if (novel.containsKey(word))
			return novel.get(word);
		else 
			return 0;
	}


	
}

jonathu@amazon.com

