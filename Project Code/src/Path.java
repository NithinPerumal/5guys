import java.awt.Point;
import java.util.ArrayList;

/**
 * things are gonna change around here son   Prepare yourself
 * @author hohljm
 *
 */
public class Path {
	private double distanceEstimate;
	private Node start;
	private Node dest;
	private ArrayList<Node>neighbors;
	
	public Path(Node starter, Node goal){
		distanceEstimate=estimate();
		start=starter;
		dest=goal;
		neighbors=start.getNeighbors();
		
	}
	private double estimate(){
		Point a=start.getCoord();
		Point b= dest.getCoord();
		return a.distance(b);
		
	}
	public void createPaths(){
		for(Node p:neighbors){
			
		}
	
	}
	public Node bestPath(){
		return null;
	}
	

}
