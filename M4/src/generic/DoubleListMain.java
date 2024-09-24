package generic;

public class DoubleListMain {
	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		// part 1: fill a DoubleList
		MyList dl1 = new MyList();
		dl1.display();
		dl1.insertElement(0, 0.0);
		dl1.display();
		dl1.insertElement(1, 1.1);
		dl1.display();
		
		// call some other methods
		int sz = dl1.size();
		boolean e = dl1.isEmpty();
		System.out.println("size = " +sz + ", empty = " + e);
		dl1.removeElement(0);
		dl1.display();
		
		// create other lists
		MyList dl2 = new MyList();
		dl2.insertElement(0, 11.1);
		dl2.insertElement(0, 22.2);
		MyList dl3 = new MyList();
		dl3.insertElement(0, 111.1);
		dl3.insertElement(0, 222.2);
		dl3.insertElement(0, 333.3);
		
		// display the 3 lists
		dl1.display();
		dl2.display();
		dl3.display();
	}
}
