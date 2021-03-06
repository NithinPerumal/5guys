import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	String name;
	ArrayList<Node> neighbors = new ArrayList<Node>();
	Point coord;
	int radius;
	private Ellipse2D.Double dot;
	private Color color = Color.BLACK;
	private ArrayList<String> landmarks = new ArrayList<String>();
	private ArrayList<String> Stringneighbours = new ArrayList<String>();
	HashMap<Node, Integer> distMap = new HashMap<Node, Integer>();
	int interest;

	HashMap<String, Integer> attractions = new HashMap<String, Integer>();

	Node selectA;
	Node selectB;

	public Node(String name, ArrayList<Node> neighbor, int x, int y) {
		this.name = name;
		coord = new Point(x, y);
		neighbors.add(this);
		distMap.put(this, interest);
	}

	public Node(String cityName, ArrayList<String> landmarks,
			ArrayList<String> neighbours, int x, int y, int interest) {
		this.name = cityName;
		this.landmarks = landmarks;
		this.Stringneighbours = neighbours;
		this.interest = interest;
		coord = new Point(x, y);
		distMap.put(this, interest);  // need to find actual dist cost, can be used for interest
	}
	
	public void setDistCostMap(HashMap<Node, Integer> map){
		this.distMap = map;
	}

	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}

	public double getXCoord() {
		return coord.getX();
	}

	public double getYCoord() {
		return coord.getY();
	}

	public double getDistance(Node neighbor) {
		return Math.abs(this.coord.distance(neighbor.getCoord()));
	}

	public Point getCoord() {
		return this.coord;
	}

	public void draw(Graphics2D g, int radius) {
		this.radius = radius;
		dot = new Ellipse2D.Double(this.getXCoord(), this.getYCoord(), radius,
				radius);
		g.setColor(color);
		g.fill(dot);
	}

	public int attractiveness() {
		return 10;
	}

	public Integer addAttraction(String name, Integer rating) {
		return attractions.put(name, rating);
	}

	public void setColor(Graphics2D g, Color newColor) {
		color = newColor;
	}

	public Ellipse2D.Double getShape() {
		return dot;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		return this.name;
	}
	
	public Integer getDistCost(Node n){
		return distMap.get(n);
	}

	public int getInterest() {
		
		return this.interest;
	}
	public ArrayList<String> getLandmarks(){
		return this.landmarks;
	}

}
