package generic;

/**
 * A linked list of double values
 * 
 * @author t.perennou (Java code)
 * @author c.garion (algebraic data type specification)
 */
public class MyList<E> {

	/**
	 * Inner class to hold the cells forming the linked list
	 * 
	 * @author t.perennou
	 */
	class Cell {
		/** Value held by the cell */
		E value;
		/** Next cell in the list */
		Cell next;

		/**
		 * Creates a cell with the specified value and successor
		 * 
		 * @param value
		 *            Value to store in the cell
		 * @param next
		 *            Next cell in the list, or null if last element
		 */
		Cell(E value, Cell next) {
			this.value = value;
			this.next = next;
		}
	}

	/** Cell holding the first double in the list, or null */
	Cell first;

	/** Number of elements contained in the list */
	int size;

	/**
	 * Creates an empty list
	 */
	public MyList() {
		first = null;
		size = 0;
	}

	/**
	 * Creates a list with the specified values, in the specified order.
	 * 
	 * A call to <code>new DoubleList(3, 2, 1)</code> will create a [ 3.0,
	 * 2.0, 1.0 ] list.
	 * 
	 * @param values
	 *            Values of the list
	 */
	public MyList(E... values) {
		first = null;
		size = 0;
		for (E value : values) { // example of "for-each" loop
			insertElement(size, value);
		}
	}

	/**
	 * Checks whether the list is empty
	 * 
	 * @return true iff list is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Sub-method that stops the host program if index is out of [0 max]
	 * 
	 * @param index
	 *            The index to check
	 * @param max
	 *            Inclusive upper bound for the index
	 */
	private void checkIndex(int index, int max) {
		if (index < 0 || index > max) {
			throw new RuntimeException("Index " + index + " out of [0, " + max + "]");
		}
	}

	/**
	 * Gets the value of the n-th cell in the list, or throws an exception if
	 * the index is not in [0, size-1].
	 * 
	 * @param index
	 *            Index of the value to get
	 * @return The value held by the cell at the specified index
	 */
	public E getElement(int index) {
		checkIndex(index, size - 1);
		Cell traveller = first;
		for (int i = 0; i < index; i++) {
			traveller = traveller.next;
		}
		return traveller.value;
	}

	/**
	 * Adds a double to the list so that it will be found at the specified
	 * index, or throws an exception if the index is not in [0, size].
	 * 
	 * @param index
	 *            Index at which to insert the value
	 * @param value
	 *            Value to insert
	 */
	public void insertElement(int index, E value) {
		checkIndex(index, size); // not size-1: size may be used for appending
		if (index == 0) {
			first = new Cell(value, first);
		} else {
			Cell traveller = first;
			for (int i = 0; i < index - 1; i++) {
				traveller = traveller.next;
			}
			traveller.next = new Cell(value, traveller.next);
		}
		size++;
	}

	/**
	 * Removes the value found at the specified index from the list, or throws
	 * an exception if the index is not in [0, size-1].
	 * 
	 * @param index
	 */
	public void removeElement(int index) {
		checkIndex(index, size - 1);
		if (index == 0) {
			first = first.next;
		} else {
			Cell traveller = first;
			for (int i = 0; i < index - 1; i++) {
				traveller = traveller.next;
			}
			traveller.next = traveller.next.next;
		}
		size--;
	}

	/**
	 * Displays the list content in the console, in the form:
	 * <ul>
	 * <li>[ ] if the list is empty
	 * <li>[ x ] if the size of the list is 1
	 * <li>[ x, ..., y ] otherwise
	 * </ul>
	 */
	public void display() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Cell traveller = first;
		for (int i = 0; i < size; i++) {
			sb.append(traveller.value);
			traveller = traveller.next;
			if (i < size - 1) {
				sb.append(", ");
			} else {
				sb.append(" ");
			}
		}
		sb.append("]");
		System.out.println(sb);
	}

}
