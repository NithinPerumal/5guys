import java.util.ArrayList;
import java.util.Queue;

/**
 * Winter is Coming
 * 
 * @author hohljm class that creates a queue that orders the elements smallest
 *         to largest sorts it using a binary heap
 */
public class PriorityQueueGraph<Object> extends ArrayList<Object> {
	private int size;

	public PriorityQueueGraph() {
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
				Route lelement = (Route) super.get(lspot);
				Route relement = (Route) super.get(rspot);
				Route element = (Route) super.get(spot);

				if (element.getCost() > lelement.getCost()
						|| element.getCost() > relement.getCost()) {

					if (relement.getCost() < lelement.getCost()) {
						super.set(spot, (Object) relement);
						super.set(rspot, (Object) element);
						percolateDown(rspot);
					} else if (relement.getCost() > lelement.getCost()) {
						super.set(spot, (Object) lelement);
						super.set(lspot, (Object) element);
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
	 * 
	 * @param index
	 */
	public void percolateUp(int index) {

		int parentIndex = ((index / 2) + (index % 2) - 1);
		Route parent = (Route) super.get(parentIndex);
		if (parent.getCost() > ((Route) super.get(index)).getCost()) {
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
	public Route peek() {
		if (super.size() == 0)
			return null;
		return (Route) super.get(0);

	}

	public int getSize() {
		return this.size;
	}

	/**
	 * shows the first element and removes it
	 * 
	 * @return first element
	 */
	public Route poll() {
		if (this.size() == 0)
			return null;
		if (this.size() > 2) {
			Route tempor = (Route) super.get(1);
			super.set(1, super.get(2));
			super.set(2, (Object) tempor);
		}
		Route temp = (Route) super.get(0);
		remove(temp);
		return temp;

	}

	/**
	 * removes the specified element
	 * 
	 * @param element
	 * @return if successful
	 */
	public boolean remove(Route element) {
		if (super.contains(element)) {
			int spot = super.indexOf(element);
			super.set(spot, super.get(super.size() - 1));
			super.remove(super.size() - 1);
			if (super.size() > 1)
				percolateDown(spot);
			size--;
			return true;
		} else
			return false;

	}

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
