
public class MyLinkedList<T> {
	
	//Fields
	private Node h;   //list header
	public MyIterator i;
	
	//Constructors
	MyLinkedList() {
		h = new Node();
		i = new MyIterator();
		h.l = null;
		h.next = null;
	}
	
	//Methods
	public boolean insert(T newObject) {
		KeyMode newNode = (KeyMode) newObject;
		Node n = new Node();
		if (n == null) {
			return false;
		} else {
			n.next = h.next;
			h.next = n;
			n.l = (T) newNode.deepCopy();
			return true;
		}
	}
	
	public T fetch(Object targetKey) {
		Node p = h.next;
		while (p!= null && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
			p = p.next;
		}
		if (p != null) {
			KeyMode fetchedNode = (KeyMode) p.l;
			return (T) fetchedNode.deepCopy();
		} else {
			return null;
		}
	}
	
	public boolean delete(Object targetKey) {
		Node q = h;
		Node p = h.next;
		while (p!= null && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
			q = p;
			p = p.next;
		}
		if (p != null) {
			q.next = p.next;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean update (Object targetKey, T  newObject) {
		Node q = h;
		Node p = h.next;
		while (p!= null && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
			q = p;
			p = p.next;
		}
		if (p != null) {
			KeyMode newNode = (KeyMode) newObject;
			Node n = new Node();
			n.next = p.next;
			q.next = n;
			n.l = (T) newNode.deepCopy();
			return true;
		} else {
			return false;
		}
	}
	
	public void showAll() {
		Node p = h.next;
		while (p != null) {
			System.out.println(((KeyMode) p.l).toString());
			p = p.next;
		}
	}
	
	//Inner Class
	public class Node  {
		//Fields
		private T l;
		private Node next;
		
		//Constructors
		public Node() {
		}
	}
	
	//Iterator
	public class MyIterator {
		//Fields
		private Node ip;
		
		//Constructors
		public MyIterator() {
			ip = h;
		}
		
		//Methods
		public void reset() {
			ip = h;
		}
		
		public boolean hasNext() {
			if (ip.next != null) {
				return true;
			} else {
				return false;
			}
		}
		
		public T next() {
			ip = ip.next;
			KeyMode nextNode = (KeyMode) ip.l;
			return (T) nextNode.deepCopy();
		}
		
		public void set(T newObject) {
			KeyMode newInfo = (KeyMode) newObject;
			ip.l = (T) newInfo.deepCopy();
		}
	}
}
