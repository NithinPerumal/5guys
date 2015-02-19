import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;



/**
 * shits about to go down here bois
 * 
 * @author hohljm
 *
 */
public class Route {
	private Node start;
	private Node dest;
	private double dEstimate;
	private ArrayList<Node> neighbors;
	private ArrayList<Path> paths;

	public Route(Node starter, Node finish) {
		start = starter;
		dest = finish;
		neighbors = start.getNeighbors();
		dEstimate = estimate();
	}
<<<<<<< HEAD

	public void createPaths() {
		PriorityQueue<Object> router = new PriorityQueue<Object>();
		ArrayList<Node>completeRoute=new ArrayList<Node>();
		Node checker = this.start;
		while (checker.name != dest.name) {
			for (Node p : neighbors) {
				Path path = new Path(start, p, estimate());
				router.add(path);
				/**
				 * Call best path return dest node of greatest path to take
				 * while ret(best path) != dest route bestpath() with start
				 * moved to the ret(best path) should return the priority queue
				 * of nodes to go to
				 */
			}
			checker = router.poll().getGoalNode();
			completeRoute.add(checker);
			router.clear();
=======
	public void createPaths(){
		PriorityQueue<Object>router=new PriorityQueue<Object>();
		for(Node p:neighbors){
			Path path = new Path(start, p, estimate(), 0);
			router.add(path);
			/**
			 * 	Call best path
			 * 	return dest node of greatest path to take
			 * 	while ret(best path) != dest route
			 * 		bestpath() with start moved to the ret(best path)
			 * 	should return the priority queue of nodes to go to
			 */
>>>>>>> origin/master
		}

	}

	private double estimate() {
		Point a = start.getCoord();
		Point b = dest.getCoord();
		return a.distance(b);

	}

	public Node bestPath() {

		return null;
	}

	public double getEstimate() {
		return this.dEstimate;
	}

}
