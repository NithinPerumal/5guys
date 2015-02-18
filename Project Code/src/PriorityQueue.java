import java.util.ArrayList;
import java.util.Queue;

/**
 * Winter is Coming
 * 
 * @author hohljm class that creates a queue that orders the elements smallest
 *         to largest sorts it using a binary heap
 */
public class PriorityQueue<Object> extends ArrayList<Object> {
	private int size;

	public PriorityQueue() {
		size = 0;
	}

	/**
	 * adds elements to the queue then calls for it to be sorted
	 */
	public boolean add(Object element) {
		if (element == null)
			throw new NullPointerException();
		super.add(element);
		if (super.size() > 1)
			percolateUp(super.size() - 1);
		size++;
		return true;
	}

	// THIS IS UNFINISHED I JUST IMPORTED THE BINARY HEAP FROM EARL
	/**
	 * after removing elements this resorts the queue
	 * 
	 * @param spot
	 */
	public void percolateDown(int spot) {
		if (spot != super.size() - 1) {

			int lspot = ((spot + 1) * 2) - 1;
			int rspot = (spot + 1) * 2;
			if (rspot <= super.size() - 1) {
				Path lelement = (Path) super.get(lspot);
				Path relement = (Path) super.get(rspot);
				Path element = (Path) super.get(spot);

				if (element.getDistance() > lelement.getDistance()
						|| element.getDistance() > relement.getDistance()) {

					if (relement.getDistance() < lelement.getDistance()) {
						super.set(spot, (Object) relement);
						super.set(rspot, (Object) element);
					} else if (relement.getDistance() > lelement.getDistance()) {

					} else {
						return;
					}

				}
			}
		}

	}

	/**
	 * after adding an element to the end of the queue this resorts its all
	 * 
	 * @param index
	 */
	public void percolateUp(int index) {

		int parentIndex = ((index / 2) + (index % 2) - 1);
		Path parent = (Path) super.get(parentIndex);
		if (parent.getDistance() > ((Path) super.get(index)).getDistance()) {
			super.set(parentIndex, super.get(index));
			super.set(index, (Object) parent);
			if (parentIndex > 0)
				percolateUp(parentIndex);
		}
	}

	/**
	 * shows the element at the beginning of the queue
	 * 
	 * @return
	 */
	public Path peek() {
		if (super.size() == 0)
			return null;
		return (Path) super.get(0);

	}

	public int getSize() {
		return this.size;
	}

	/**
	 * shows the first element and removes it
	 * 
	 * @return first element
	 */
	public Path poll() {
		if (this.size() == 0)
			return null;
		if (this.size() > 2) {
			Path tempor = (Path) super.get(1);
			super.set(1, super.get(2));
			super.set(2, (Object) tempor);
		}
		Path temp = (Path) super.get(0);
		remove(temp);
		return temp;

	}

	/**
	 * removes the specified element
	 * 
	 * @param element
	 * @return if successful
	 */
	// public boolean remove(Object element) {
	// if (super.contains(element)) {
	// int spot = super.indexOf(element);
	// super.set(spot, super.get(super.size() - 1));
	// super.remove(super.size() - 1);
	// if (super.size() > 1)
	// percolateDown(spot);
	// return true;
	// } else
	// return false;
	//
	// }

	/**
	 * adds the element to the queue
	 * 
	 * @param element
	 * @return
	 */
	public boolean offer(Object element) {
		return this.add(element);
	}

}
