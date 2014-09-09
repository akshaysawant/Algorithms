package BinarySearchTree;

public class ListNode {
	
	protected Node n;
	protected int level;
	
	public ListNode(Node n, int level)
	{
		this.n = n;
		this.level = level;
	}
	
	public ListNode()
	{
		n = null;
		level = -1;
	}
}
