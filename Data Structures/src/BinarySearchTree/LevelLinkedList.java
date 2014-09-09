
package BinarySearchTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class LevelLinkedList {

	public static void main(String[] args)
	{
		BinaryTreeTest bt = new BinaryTreeTest();
		
		bt.createTree();
		
		ArrayList<LinkedList<ListNode>> lst = new ArrayList<LinkedList<ListNode>>();
		
		System.out.println("Creating Level Linked List.");
		
		lst = bt.LevelLinkdLst();
		
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		
		for (int i = 0; i < lst.size(); i++)
		{
			System.out.println("");
			list = lst.get(i);
			
			while(!list.isEmpty())
			{
				ListNode lnode = new ListNode();
				lnode = list.removeFirst();
				
				System.out.print("   " + lnode.n.data);
			}
		}
		
		int val;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter value for paths : ");
		
		val = in.nextInt();
		
		bt.paths(val);
		
	}
	
}
