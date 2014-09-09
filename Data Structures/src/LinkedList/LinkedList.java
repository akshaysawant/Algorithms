package LinkedList;

public class LinkedList {
	
	public class Node {
		
		public int data;
		public Node next;
		
		public Node(int val)
		{
			this.data = val;
			this.next = null;
		}
	}
	
	private Node n;
	
	public LinkedList()
	{
		n = null;
	}
	
	public void insertAtStart(int val)
	{
		Node newNode = new Node(val);
		
		newNode.next = n;
		n = newNode;
		
		System.out.println("New value added at the start of the queue");
	}
	
	public void insertAtEnd(int val)
	{
		Node p = n;
		Node np = null;
		Node newNode = new Node(val);
		
		if (p == null)
		{
			n = newNode;
			return;
		}
		
		np = p.next;
		while(np != null)
		{
			p = np;
			np = np.next;
		}
		
		p.next = newNode;
	}
	
	public void insertAtPos(int pos, int val)
	{
		Node ptr = n;
		Node pptr = null;
		Node newNode = new Node(val);
		
		int i = 1;
		
		while ((ptr != null) && (i != pos))
		{
			pptr = ptr;
			ptr = ptr.next;
			i++;
		}
		
		if (ptr == null)
		{
			System.out.println("No such position exists in Linked List");
			return;
		}
		else if (i == pos)
		{
			pptr.next = newNode;
			newNode.next = ptr;
		}
	}
	
	public void showList()
	{
		Node p = n;
		
		System.out.println("Elements of list are : ");
		while (p != null)
		{
			System.out.println(p.data);
			p = p.next;
		}
	}
	
	public void deleteAtStart()
	{
		System.out.println("Value "+ n.data +" is deleted.");
		n = n.next;
	}
	
	public void deleteAtEnd()
	{
		Node p = n;
		Node prevp = null;
		
		if (p == null)
		{
			System.out.println("Cannot delete element. Linked list is empty.");
			return;
		}
		
		while (p != null)
		{
			prevp = p;
			p = p.next;
		}
		
		System.out.println("Value "+ prevp.data +" is deleted.");
		prevp.next = null;
	}
	
	public void deleteAtPos(int pos)
	{
		Node ptr = n;
		Node pptr = null;
		int i = 1;
		
		while ((ptr != null) && (i != pos))
		{
			pptr = ptr;
			ptr = ptr.next;
			i++;
		}
		
		if (ptr == null)
		{
			System.out.println("No such position exists in Linked List");
			return;
		}
		else if (i == pos)
		{
			System.out.println("Value "+ ptr.data +" is deleted.");
			pptr.next = ptr.next;
		}
	}
	
	public void deleteByValue(int val)
	{
		Node p = n;
		Node prevp = null;
		
		while ((p != null) && (p.data != val))
		{
			prevp = p;
			p = p.next;	
		}
		
		if (p == null)
		{
			System.out.println("No node for input value "+ val +" exists in Linked List");
			return;
		}
		else if (p.data == val)
		{
			System.out.println("Value "+ p.data +" is deleted.");
			prevp.next = p.next;
		}
			
	}
}
