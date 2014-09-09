
package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTree {
	
	private Node root;
	
	private ArrayList<LinkedList<Node>> paths = new ArrayList<LinkedList<Node>>();
	
	public BinaryTree()
	{
		root = null;
	}
	
	public void preorderTraversal()
	{
		preorder(root);
	}
	
	private void preorder(Node p)
	{
		if (p != null)
		{
			System.out.println(" "+ p.data);
			preorder(p.left);
			preorder(p.right);
		}
	}
	
	public void inorderTraversal()
	{
		inorder(root);
	}
	
	private void inorder(Node p)
	{
		if (p != null)
		{
			inorder(p.left);
			System.out.println(" "+ p.data);
			inorder(p.right);
		}
	}
	
	public void postorderTraversal()
	{
		postorder(root);
	}
	
	private void postorder(Node p)
	{
		if (p != null)
		{
			postorder(p.left);
			postorder(p.right);
			System.out.println(" "+ p.data);
		}
	}
	
	public void simpleInsert(int val)
	{
		Node p, parent;
		p = root;
		parent = null;
		
		Node n = new Node(val);
		
		while (p != null)
		{
			if (p.data >= val)
			{
				parent = p;
				p = p.left;
			}
			else
			{
				parent = p;
				p = p.right;
			}
		}
		
		if (parent == null)
			root = n;
		else if (parent.data >= val)
			parent.left = n;
		else
			parent.right = n;
		
		if (isBalanced())
			System.out.println("The tree is balanced.");
		else
			System.out.println("The tree is unbalanced.");
	}
	
	public void insertWrp(int val)
	{
		simpleInsert(val);
		//recInsert(root, val);
	}
	
	private void recInsert(Node n, int val)
	{
		if (n == null)
			n = new Node(val);
		if (n.data > val)
		{
			if (n.left == null)
				n.left = new Node(val);
			else
				recInsert(n.left, val);
		}
		else
		{
			if (n.right == null)
				n.right = new Node(val);
			else
				recInsert(n.right, val);
		}
	}
	
	public void deleteWrp(int val)
	{
		delete(root, null, val);
	}
	
	private void delete(Node p, Node parent, int val)
	{		
		if (p.data > val)
			delete(p.left, p, val);
		else if (p.data < val)
			delete(p.right, p, val);
		else
		{
			if ((p.left == null) && (p.right == null))
				deleteNode(parent, p, null);
			else if (p.left == null)
				deleteNode(parent, p, p.right);
				else if (p.right == null)
					deleteNode(parent, p, p.left);
					else
					{
						Node succesor = inorderPred(p);
						Node succParent = succesorParent(p);
						
						p.data = succesor.data;
						delete(succesor, succParent, succesor.data);
					}
					
		}
	}
	
	private void deleteNode(Node parent, Node p, Node child)
	{
		if (parent != null)
		{
			if (parent.left == p)
				parent.left = child;
			else if (parent.right == p)
				parent.right = child;
		}
		else
			root = null;
	}
	
	private Node inorderPred(Node n)
	{
		Node p = n.left;
		
		while (p.right != null)
			p = p.right;
		
		return p;
	}
	
	private Node succesorParent(Node n)
	{
		Node parent = n;
		Node p = n.left;
		
		while (p.right != null)
		{
			parent = p;
			p = p.right;
		}
		
		return parent;
	}
	
	private boolean isBalanced()
	{
		return((maxDepth(root) - minDepth(root)) <= 1);
	}
	
	private int maxDepth(Node p)
	{
		if (p == null)
			return 0;
		
		return (1 + Math.max(maxDepth(p.right), maxDepth(p.left)));
	}
	
	private int minDepth(Node p)
	{
		if (p == null)
			return 0;
		
		return (1 + Math.min(minDepth(p.right), minDepth(p.left)));
	}
	
	// THIS IS BFS. NOT DFS.
	public ArrayList<LinkedList<ListNode>> LevelLinkdLst()
	{
		int level = 0;
		
		ArrayList<LinkedList<ListNode>> result = new ArrayList<LinkedList<ListNode>>();
		
		LinkedList<ListNode> list = new LinkedList<ListNode>();
		LinkedList<ListNode> queue = new LinkedList<ListNode>();
		
		ListNode lnode = new ListNode(root, level);
		
		queue.add(lnode);
		
		
		while (!queue.isEmpty())
		{
			ListNode v = new ListNode();
			v = queue.removeFirst();
			
			if (v.level == level)
				list.add(v);
			else
			{
				result.add(list);
				list = new LinkedList<ListNode>();
				list.add(v);
				level++;
			}
			
			if (v.n.left != null)
			{
				lnode = new ListNode(v.n.left, level+1);
				queue.add(lnode);
			}
			
			if (v.n.right != null)
			{
				lnode = new ListNode(v.n.right, level+1);
				queue.add(lnode);
			}
		}
		
		result.add(list);
		
		return result;
	}
	
	
	public void getPaths(int val)
	{
		paths(root, 0, val, new LinkedList<Node>());
	}
	
	
	private void paths(Node p, int sum, int val, LinkedList<Node> list)
	{
		if (p.data + sum == val)
		{
			list.add(p);
			
			System.out.println();
			while(!list.isEmpty())
				System.out.print(" "+ list.removeFirst().data);
			
			if (p.left != null)
				paths(p.left, 0, val, new LinkedList<Node>());
			if (p.right != null)
				paths(p.right, 0, val, new LinkedList<Node>());
		}
		
		if (p.data + sum < val)
		{
			list.add(p);
			
			if (p.left != null)
				paths(p.left, sum+p.data, val, new LinkedList<Node>(list));
			if (p.right != null)
				paths(p.right, sum+p.data, val, new LinkedList<Node>(list));
			if (p.left != null)
				paths(p.left, 0, val, new LinkedList<Node>());
			if (p.right != null)
				paths(p.right, 0, val, new LinkedList<Node>());
		}
	}
}
