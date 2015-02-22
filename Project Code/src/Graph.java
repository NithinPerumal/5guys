import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Graph {
	private Node start;
	private Node finish;
	private Node root;
	private Node visited;
	private ArrayList<Node> route;
	ArrayList<Route> possibles = new ArrayList<Route>();

	public Graph(Node root, Node begin, Node end) {
		this.root = root;
		start = begin;
		finish = end;

	}

	public ArrayList<Node> bestPath() {
		PriorityQueueGraph<Route> answer = this.addRoutes();
		System.out.println(answer.size());
		return answer.poll().getList();
	}

	public PriorityQueueGraph<Route> addRoutes() {

		PriorityQueueGraph<Route> fin = new PriorityQueueGraph<Route>();
		 System.out.println("huh");
		// get the neighbor nodes
		
	    options(start);
		System.out.println(possibles.size()+"much goat");
		for (Route r : possibles) {
			if (r.getList().get(r.getList().size() - 1).name
					.equals(finish.name))
				fin.add(r);
		}

		return fin;

		// for (Node n : start.getNeighbors()) {
		//
		// if (start == root) { // if this start is equal to the first clicked
		//
		// ArrayList<Node> temp = new ArrayList<Node>();
		// // Path p = new Path(start, n, 0, 5, 5);
		// temp.add(start);
		// temp.add(n);
		//
		// if (start == null) {
		// System.out.println("bitches");
		// }
		// if (start == root) {
		// System.out.println("ditches");
		// System.out.println(n.name);
		// if (start == n) {
		// System.out.println("penis");
		// }
		// }
		// int distCost = start.getDistCost(n);
		// Route r = new Route(temp, distCost);
		// fin.add(r);
		// }
		//
		// else { // start != root
		//
		// if (visited != n)
		// for (Route r : fin) {
		// r.getList().add(n); // add each node to their routes,
		// // not update cost
		// r.updateCost(start.getDistCost(n)); // update cost
		// }
		// else {
		// continue;
		// }
		//
		// }
		//
		// if(n.name.equalsIgnoreCase(start.neighbors.get(start.neighbors.size()-1).name)){
		// visited = start;
		// start = n;
		// }
		//
		// if (start == finish) {
		// break;
		// }
		// }
		//
		// return fin;
	}

	public void options(Node n) {
		System.out.println(n.neighbors.size());
//		ArrayList<Route> temp = new ArrayList<Route>();
		if (n == finish)
			return;
		for (Node t : n.neighbors) {
			System.out.println("hola");
			if (n == this.root) {
				int dist=n.getDistCost(t);
				Route r= new Route(t,dist);
				possibles.add(r);
//				temp.addAll(options(t));
				
			} else {
//				Route rr= new Route()
//				temp.addAll(options(t));
			}
		}
		

	}

	// PriorityQueue<Route> routes = new PriorityQueue<Route>();

	// public void findRoute(ArrayList<Node> visited, Node n, ArrayList<Node>
	// route){
	// route.add(n);
	// Double cost = getCost(route);
	// Route r = new Route(route,cost);
	// if(routes.peek() != null){
	// if(routes.peek().getCost() < r.getCost())
	// return;
	//
	// }
	// for(Node neigh:n.getNeighbors()){
	// if(neigh.name.equalsIgnoreCase(finish.name)){
	// route.add(neigh);
	// cost=getCost(route);
	// Route fin=new Route(route,cost);
	// routes.add(fin);
	// return;
	// }else{
	// ArrayList<Node>unvisited=new ArrayList<Node>();
	// boolean lookedAt=false;
	// for(Node check: visited){
	// if(neigh.name.equalsIgnoreCase(check.name)){
	// lookedAt=true;
	// }
	// else{
	// visited.add(neigh);
	// }
	// if(!lookedAt)
	// unvisited.add(neigh);
	// if(unvisited.size()==0)
	// return;
	// else{
	// for(Node temp:unvisited){
	// ArrayList<Node> routeTemp = route;
	// routeTemp.add(temp);
	// findRoute(visited,temp,routeTemp);
	// }
	// }
	// }
	// }
	// }
	//
	//
	// }

	private Double getCost(ArrayList<Node> route) {
		Double dist = (double) 0;
		for (int i = 0; i < route.size() - 2; i++) {
			dist += route.get(i).getDistance(route.get(i + 1));
		}
		return dist;
	}

}
