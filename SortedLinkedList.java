
public class SortedLinkedList<T> {
	//Fields
		private Node h;   //list header
		
		//Constructors
		SortedLinkedList() {
			h = new Node();
			h.l = null;
			h.next = null;
		}
		
		//Methods
		public boolean insert(T newObject) {
			KeyMode newNode = (KeyMode) newObject;
			Node n = new Node();
			Node p = h.next;
			Node q = h;
			if (p == null) {
				h.next = n;
				n.l = (T) newNode.deepCopy();
				return true;
			}
			while (p != null && newNode.compareTo(((KeyMode) p.l).getKey1()) > 0) {
					q = p;
					p = p.next;
				}
				n.next = q.next;
				q.next = n;
				n.l = (T) newNode.deepCopy();
				return true;
		}
		
		
		public T fetch(Object targetKey) {
			Node p = h.next;
			while (p!= null && (((KeyMode) p.l).compareTo(targetKey) < 0)) {
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
			while (p!= null && (((KeyMode) p.l).compareTo(targetKey) < 0)) {
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
				q.next = p.next;
				p = p.next;
				KeyMode newNode = (KeyMode) newObject;
				Node n = new Node();
				if (newNode.compareTo(((KeyMode) q.l).getKey1()) > 0) {
					while (p != null && newNode.compareTo(((KeyMode) p.l).getKey1()) > 0) {
						q = p;
						p = p.next;
					}
					n.next = q.next;
					q.next = n;
					n.l = (T) newNode.deepCopy();
					return true;
				} else {
					q = h;
					p = h.next;
					while (p != null && newNode.compareTo(((KeyMode) p.l).getKey1()) > 0) {
						q = p;
						p = p.next;
					}
					n.next = q.next;
					q.next = n;
					n.l = (T) newNode.deepCopy();
					return true;
				}
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
			public Node() {
			}
		}
		
	}
