
public class DoublyLinkedList<T> {
	
		//Fields
		private Node h;   //list header
		
		//Constructors
		DoublyLinkedList() {
			h = new Node();
			h.l = null;
			h.next = null;
			h.back = null;
		}
		
		//Methods
		public boolean insert(T newObject) {
			KeyMode newNode = (KeyMode) newObject;
			Node n = new Node();
			if (n == null) {
				return false;
			} else if (h.next == null) {
				h.next = n;
				n.back = null;
				n.l = (T) newNode.deepCopy();
				return true;
			} else {
				n.next = h.next;
				h.next.back = n;
				h.next = n;
				n.back = null;
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
				if (p.next == null) {
				} else {	
					p.next.back = q;
				}
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
				n.back = q;
				if (p.next == null) {
				} else {
					p.next.back = n;
				}
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
			private T l;
			private Node next;
			private Node back;
			public Node() {
			}
		}
		
	}
