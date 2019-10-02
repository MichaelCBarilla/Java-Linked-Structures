
public class MyCircLinkedList<T> {
	//Fields
		private Node h;   //list header
		
		//Constructors
		MyCircLinkedList() {
			h = new Node();
			h.l = null;
			h.next = h;
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
			while (p!= h && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
				p = p.next;
			}
			if (p !=h) {
				KeyMode fetchedNode = (KeyMode) p.l;
				return (T) fetchedNode.deepCopy();
			} else {
				return null;
			}
		}
		
		public boolean delete(Object targetKey) {
			Node q = h;
			Node p = h.next;
			while (p!= h && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
				q = p;
				p = p.next;
			}
			if (p != h) {
				q.next = p.next;
				return true;
			} else {
				return false;
			}
		}
		
		public boolean update (Object targetKey, T  newObject) {
			Node q = h;
			Node p = h.next;
			while (p!= h && !(((KeyMode) p.l).compareTo(targetKey) == 0)) {
				q = p;
				p = p.next;
			}
			if (p !=h) {
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
			while (p != h) {
				System.out.println(((KeyMode) p.l).toString());
				p = p.next;
			}
		}
		
		//Inner Class
		public class Node  {
			private T l;
			private Node next;
			public Node() {
			}
		}
		
	}
