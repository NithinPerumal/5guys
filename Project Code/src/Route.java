import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
	private ArrayList<Node> paths = new ArrayList<Node>();
	private int cost = 0;
	private ArrayList<Node> completeRoute;
	
	HashMap<Double, ArrayList<Node>> finalPath = new HashMap<Double, ArrayList<Node>>();

	public Route(Node starter, Node finish) {
		start = starter;
		dest = finish;
		neighbors = start.getNeighbors();
		dEstimate = estimate();
		completeRoute=new ArrayList<Node>();
	}
	
	public Route(ArrayList<Node> routeToTraverse, int distCost){
		this.neighbors = routeToTraverse;
		System.out.println("distcost " + routeToTraverse+ distCost);
		this.cost += distCost;
	}
	
//	public Route(ArrayList<Path> paths, Double pathCost){
//		this.paths = paths;
//		this.cost = pathCost;
//	}
	
	public ArrayList<Node> getList(){
		return this.paths;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public boolean updateCost(Integer cost){
		this.cost += cost;
		return true;
	}

//	public ArrayList<Node> createPaths() {		
//		
//		PriorityQueue<Object> router = new PriorityQueue<Object>();
//	    completeRoute = new ArrayList<Node>();
//		Node checker = this.start;
//		double est=this.start.getDistance(dest)+300;
//		ArrayList<Double> curDistances = new ArrayList<Double>();
////		double totalDist = 0;
//		while (!checker.name.equals( dest.name) ) {  
//			System.out.println(checker.neighbors.size());
//			for (Node p : checker.neighbors) { 
////				System.out.println(p.name);// for each node in neighbors
//				Path path = new Path(checker, p, estimate(), 10, 7);  // third and fourth are from text doc
//				
//				if(p.getDistance(dest) < checker.getDistance(dest)){  // prevent from going in opposite direction
//				
////				if(p.getDistance(dest)<est){
////					System.out.println("much goat");
//					router.add(path);
//				}				
////				if(p.coord.y>checker.coord.y)
////					router.add(path);
//				/**
//				 * Call best path return dest node of greatest path to take
//				 * while ret(best path) != dest route bestpath() with start
//				 * moved to the ret(best path) should return the priority queue
//				 * of nodes to go to
//				 */
//				
//				
//				
//			}
////			System.out.println(router.peek().getGoalName());
//			checker = router.poll().getGoalNode(); 
//			System.out.println(checker.name);
//			// changes which one is the current node to be checked and pops off the one on top
//			completeRoute.add(checker);  // adds the current checked one to the complete route
//			router.clear(); 
			
			// clears the router

			
//		}
//			
//			if(router.peek().getStart() == this.start){  // if this is the start location
////				ArrayList<Node> 
//				for(Object p : router){  // for each of the first starting paths
//					Path path = (Path) p;
//					finalPath.put(path.getDistCost(), new ArrayList<Node>());  // create the one for the start of the HM with the start dist cost and the start and the AL
//					finalPath.get(path.getDistCost()).add(path.getStart());  // add the start
//					finalPath.get(path.getDistCost()).add(path.getGoalNode());  // add the first stop
//					curDistances.add(path.getDistCost());
//				}
//			}
//			
//			else{ // if this is not the start location
//				// check to see if in curDistances
//				// if yes, then update that one
//				// if not, then add it in to the HM and the curDistance AL
//				
//				for(Object p : router){  // getting each of the different paths
//					Path path = (Path) p;
//					
//					for(int i = 0; i < curDistances.size(); i ++){ // getting and checking values of curDistances
//						if(finalPath.get(curDistances.get(i)) != null){ // make sure that this is actually in here
//							// reset the key
//							
//							ArrayList<Node> tempAr = finalPath.get(curDistances.get(i)); // get the old AL
//							Double tempKey = curDistances.get(i);  // get the old key
//							tempKey += path.getDistCost();  // update the key
//							
//							tempAr.add(path.getGoalNode());  // update the AL
//							finalPath.put(tempKey, tempAr);  // add the updated info
//							
//							// you will not need to remove anything until the very end this way
//							if(p == router.get(router.size() - 1)){
//								finalPath.remove(curDistances.get(i));  // remove this from the HM
//							}
//						}
//						
//						
//					}
//				}
//			}
//			
	
			
//			totalDist += router.peek().getDistCost();
			
//			checker = router.poll().getGoalNode();  // changes which one is the current node to be checked and pops off the one on top
//			completeRoute.add(checker);  // adds the current checked one to the complete route
//			router.clear();  // clears the router
////		}
		/*
		 * 	Iterate through the first d nodes,
		 *  and calculate the distance
		 *  and then add to the hashmap
		 */
		
		
//		while(( completeRoute).peek() != dest){
////			totalDist += completeRoute.peek().getDistance(neighbor)
//			
//		}
//		System.out.println("size of route "+ completeRoute.size());
//		return completeRoute;
//	}


	public String toString(){
		return this.completeRoute.toString();
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
