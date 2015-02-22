import java.util.ArrayList;

public class Graph {
	private Node start;
	private Node finish;
	ArrayList<Route> possibles = new ArrayList<Route>();
	PriorityQueueGraph<Route> answer;
	PriorityQueueInterest<Route> interests;

	public Graph(Node root, Node begin, Node end) {
		start = begin;
		finish = end;
		answer=new PriorityQueueGraph<Route>();
		interests = new PriorityQueueInterest<Route>();
	}

	public ArrayList<Node> bestPath() {
		ArrayList<Node> aj= new ArrayList<Node>();
		aj.add(start);
		findPath( aj ,0,start);
		return answer.poll().getList();
	}
	
	public ArrayList<Node> mostInteresting(){
		ArrayList<Node> aj = new ArrayList<Node>();
		aj.add(start);
		findMostInteresting(aj, start.getInterest(), start);
		return answer.poll().getList();
	}

	
	private void findMostInteresting(ArrayList<Node> nodes, int interest, Node current) {
		for(Node n:current.neighbors){
			if(current.name.equals(finish.name)){
				Route r= new Route(nodes,interest);
				answer.add(r);
			}
			if(!nodes.contains(n)){
				ArrayList<Node> temp=new ArrayList<Node>();
				temp.addAll(nodes);
				temp.add(n);
				findPath(temp,interest+n.getInterest(),n);
			}
			
		}
		
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
