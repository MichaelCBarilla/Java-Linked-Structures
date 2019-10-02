import javax.sql.RowSetInternal;

public class DoubleEndSLL<T> {

	//Fields
		private Node h;   //list header
		private Node r;
		
		//Constructors
		DoubleEndSLL() {
			h = new Node();
			h.l = null;
			h.next = null;
			r = h.next;
		}
		
		//Methods
		public boolean insertHeader(T newObject) {
			KeyMode newNode = (KeyMode) newObject;
			Node n = new Node();
			if (n == null) {
				return false;
			} else if (h.next == null) {
				n.next = h.next;
				h.next = n;
				n.l = (T) newNode.deepCopy();
				r = n;
				return true;
			} else {
				n.next = h.next;
				h.next = n;
				n.l = (T) newNode.deepCopy();
				return true;
			}	
		}
		
		public boolean insertRear(T newObject) {
			KeyMode newNode = (KeyMode) newObject;
			Node n = new Node();
			if (n == null) {
				return false;
			} else if (r == null) {
				r = n;
				h.next = n;
				n.l = (T) newNode.deepCopy();
				return true;
			} else {
				r.next = n;
				r = n;
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
				if (p == r) {
					r = q;
				}
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
			private T l;
			private Node next;
			public Node() {
			}
		}
		
	}
