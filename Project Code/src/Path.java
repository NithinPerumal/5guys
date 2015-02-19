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
	private double distance;
	private double time;
	
	public Path(Node starter, Node goal, double estimate, double time){
		distanceEstimate=estimate;
		start=starter;
		dest=goal;
		distance=setDistance();
		this.time = time;
	}
	
	
	public double getDCost(){
		return this.distanceEstimate;
	}

	public double getTime() {
		return this.time;
	}

	public double getDistance(){
		return this.distance;
	}
	public String getGoalName(){
		return this.dest.name;
	}
	public Node getGoalNode(){
		return this.dest;
	}
	private double setDistance(){
	return	dest.getDistance(start);
		
	}

}
