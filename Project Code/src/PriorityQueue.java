import java.util.ArrayList;
import java.util.Queue;

/**
 * Winter is Coming
 * @author hohljm
 *class that creates a queue that orders the elements smallest to largest
 *sorts it using a binary heap
 */
public class PriorityQueue<T extends Comparable<? super T>> extends
		ArrayList<T> {
	
	public PriorityQueue() {

	}
/**
 * adds elements to the queue then calls for it to be sorted
 */
	public boolean add(T element) {
		if (element == null)
			throw new NullPointerException();
		super.add(element);
		if (super.size() > 1)
			percolateUp(super.size() - 1);
		return true;
	}
// THIS IS UNFINISHED  I JUST IMPORTED THE BINARY HEAP FROM EARL
	/**
	 * after removing elements this resorts the queue
	 * @param spot
	 */
	public void percolateDown(int spot) {
		if (spot != super.size() - 1) {
			
				int lspot = ((spot + 1) * 2) - 1;
				int rspot = (spot + 1) * 2;
				if (rspot <= super.size() - 1) {
				T lelement = super.get(lspot);
				T relement = super.get(rspot);
				T element = super.get(spot);

				if (element.compareTo(lelement) == 1
						|| element.compareTo(relement) == 1) {
					int check = relement.compareTo(lelement);
					if (check == -1) {
						super.set(spot, relement);
						super.set(rspot, element);
						percolateDown(rspot);
					} else if (check == 1) {
						super.set(spot, lelement);
						super.set(lspot, element);
						percolateDown(lspot);
					} else {
						return;
					}

				}
			}
		}

	}

	/**
	 * after adding an element to the end of the queue this resorts its all
	 * @param index
	 */
	public void percolateUp(int index) {

		int parentIndex = ((index / 2) + (index % 2) - 1);
		T parent = super.get(parentIndex);
		if (parent.compareTo(super.get(index)) == 1) {
			super.set(parentIndex, super.get(index));
			super.set(index, parent);
			if (parentIndex > 0)
				percolateUp(parentIndex);
		}
	}

	/**
	 * shows the element at the beginning of the queue
	 * @return
	 */
	public T peek() {
		if (super.size() == 0)
			return null;
		return super.get(0);

	}

	
	/**
	 * shows the first element and removes it
	 * @return first element
	 */
	public T poll() {
		if (this.size() == 0)
			return null;
		if(this.size()>2)
		{
			T tempor= super.get(1);
			super.set(1,super.get(2));
			super.set(2,tempor);
		}
		T temp = super.get(0);
		remove(temp);
		return temp;

	}

	/**
	 * removes the specified element
	 * @param element
	 * @return if successful
	 */
	public boolean remove(T element) {
		if (super.contains(element)) {
			int spot = super.indexOf(element);
			super.set(spot, super.get(super.size() - 1));
			super.remove(super.size() - 1);
			if (super.size() > 1)
				percolateDown(spot);
			return true;
		} else
			return false;

	}

	/**
	 * adds the element to the queue
	 * @param element
	 * @return
	 */
	public boolean offer(T element) {
		return this.add(element);
	}

	

	
}
