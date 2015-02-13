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
	
	public Path(Node starter, Node goal, double estimate){
		distanceEstimate=estimate;
		start=starter;
		dest=goal;
	}
	
	
	public double getDCost(){
		return this.distanceEstimate;
	}

}
