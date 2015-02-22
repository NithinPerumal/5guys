import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



/**
 * stuffs about to go down here bois
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
	private int interest;
	private ArrayList<Node> completeRoute = new ArrayList<Node>();
	private ArrayList<Node> visited = new ArrayList<Node>();
	
	HashMap<Double, ArrayList<Node>> finalPath = new HashMap<Double, ArrayList<Node>>();

	public Route(Node starter, Node finish) {
		start = starter;
		dest = finish;
		neighbors = start.getNeighbors();
		dEstimate = estimate();
		completeRoute=new ArrayList<Node>();
		interest = starter.interest + finish.interest;
	}
	
	public Route(ArrayList<Node> routeToTraverse, int distCost){
		this.paths = routeToTraverse;
		this.cost += distCost;
	}
	public Route(Node n, int distCost){
		this.paths.add(n);
		this.cost+=distCost;
		for(int i = 0; i < paths.size(); i ++){
			interest += paths.get(i).interest;
		}
	}
	

	
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
	
	public ArrayList<Node> getVisited(){
		return this.visited;
	}

	public int getInterest(){
		return this.interest;
	}


	public String toString(){
		if(completeRoute == null){
			System.out.println("complete route is null");
		}
		return this.paths.toString();
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
