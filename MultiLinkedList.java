
public class MultiLinkedList<T> {
	//Fields
	private SLL list1;
	private SLL list2;
	
	//Constructors
	MultiLinkedList() {
		list1 = new SLL();
		list2 = new SLL();
	}
	
	//Methods
	public boolean insert(T newObject) {
		KeyMode clone = (KeyMode) newObject;
		list1.insert(1, newObject);
		list2.insert(2, newObject);
		return true;
	}
	
	public boolean delete(Object targetKey1, Object targetKey2) {
		list1.delete(1, targetKey1);
		list2.delete(2, targetKey2);
		return true;
	}
	
	public void showAll(int listNumber) {
		if (listNumber == 1) {
			list1.showAll();
		} else {
			list2.showAll();
		}
	}
	
}
