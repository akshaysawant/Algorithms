package BinarySearchTree;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeTest {

	private static BinaryTree bt = new BinaryTree();
	
	/***
	 * Uncomment to run the code for Binary Search Tree
	 * and make the createTree() function static.
	public static void main(String[] args)
	{
		createTree();
	}
	 *
	 *
	***/
	
	public void createTree()
	{
		int choice = 0, val;	
		Scanner in = new Scanner(System.in);
		
		while (choice != 4)
		{
			System.out.println("Enter your choice : ");
			System.out.println("1. Insert   2. Delete  3. Traversal  4. Exit");
			choice = in.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter new element value : ");
					val = in.nextInt();
					bt.insertWrp(val);
					break;
					
			case 2: System.out.println("Enter element value to be deleted : ");
					val = in.nextInt();
					bt.deleteWrp(val);
					break;
					
			case 3: traversal();
					break;
					
			case 4: break;
			}
		}
	}
	
	private static void traversal()
	{
		int choice = 0;	
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter your choice for Traversal : ");
		System.out.println("1. Preorder   2. Inorder  3. Postorder");
		choice = in.nextInt();
			
		switch(choice)
		{
		case 1: bt.preorderTraversal();
				break;
		
		case 2: bt.inorderTraversal();
				break;
					
		case 3: bt.postorderTraversal();
				break;
		}
	}
	
	
	public ArrayList<LinkedList<ListNode>> LevelLinkdLst()
	{
		return (bt.LevelLinkdLst());
	}
	
	public void paths(int val)
	{
		bt.getPaths(val);
	}
}
