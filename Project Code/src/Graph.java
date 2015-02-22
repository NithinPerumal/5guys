import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Graph {
	private Node start;
	private Node finish;
	private Node root;
	private ArrayList<Node> visited;
	private ArrayList<Node> route;
	ArrayList<Route> possibles = new ArrayList<Route>();
	PriorityQueueGraph<Route> answer;

	public Graph(Node root, Node begin, Node end) {
		this.root = root;
		start = begin;
		finish = end;
		answer=new PriorityQueueGraph<Route>();

	}

	public ArrayList<Node> bestPath() {
		ArrayList<Node> aj= new ArrayList<Node>();
		aj.add(start);
		findPath( aj ,0,start);
		return answer.poll().getList();
	}

	
	public  void findPath(ArrayList<Node> nodes,int cost,Node current){
		for(Node n:current.neighbors){
			if(current.name.equals(finish.name)){
				Route r= new Route(nodes,cost);
				answer.add(r);
			}
			if(!nodes.contains(n)){
				ArrayList<Node> temp=new ArrayList<Node>();
				temp.addAll(nodes);
				temp.add(n);
				findPath(temp,cost+current.getDistCost(n),n);
			}
			
		}
	}



	private Double getCost(ArrayList<Node> route) {
		Double dist = (double) 0;
		for (int i = 0; i < route.size() - 2; i++) {
			dist += route.get(i).getDistance(route.get(i + 1));
		}
		return dist;
	}

}
