import java.awt.Point;
import java.util.ArrayList;

/**
 * shits about to go down here bois
 * @author hohljm
 *
 */
public class Route {
	private Node start;
	private Node dest;
	private double dEstimate;
	private ArrayList<Node>neighbors;
	
	
	public Route(Node starter, Node finish){		
		start=starter;
		dest=finish;
		neighbors=start.getNeighbors();
		dEstimate=estimate();
	}
	public void createPaths(){
		for(Node p:neighbors){
			
		}
	
	}
	private double estimate(){
		Point a=start.getCoord();
		Point b= dest.getCoord();
		return a.distance(b);
		
	}
	public Node bestPath(){
		return null;
	}
	
	public double getEstimate(){
		return this.dEstimate;
	}

}
