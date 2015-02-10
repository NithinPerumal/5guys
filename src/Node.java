
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	String name;
	private ArrayList<Node> neighbors = new ArrayList<Node>();
	Point coord;
	
	Node selectA;
	Node selectB;
	
	public Node(String name, ArrayList<Node> neighbor, int x, int y){
		this.name = name;
		coord = new Point(x,y);
		neighbors.add(this);
		
	}
	
	public ArrayList<Node> getNeighbors(){
		return neighbors;
	}
	
	public double getXCoord(){
		return coord.getX();
	}
	
	public double getYCoord(){
		return coord.getY()	;
	}
	
	public double getDistance(Node neighbor){
		return this.coord.distance(neighbor.getCoord());
	}
	
	public Point getCoord(){
		return this.coord;
	}
	
	public void draw(Graphics2D g, int radius){
		g.drawOval((int)this.getXCoord(), (int)this.getYCoord(), radius, radius);
		g.setColor(Color.BLACK);
		g.fillOval((int)this.getXCoord(), (int)this.getYCoord(), radius, radius);
	}
	
	public int attractiveness(){
		return 10;
	}
	
	public void mouseClicked(MouseEvent e) {
	       System.out.println("Mouse clicked (# of clicks: "
	                    + e.getClickCount() + ")");
	       
	       if(e.getClickCount() % 2 != 0){
	    	   selectA = this;
	       }
	       else selectB = this;
	    }
	
}
