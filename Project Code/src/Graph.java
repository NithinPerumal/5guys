import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;


public class Graph {
	private Node start;
	private Node finish;
	private Node root;
	public Graph(Node root, Node begin,Node end){
		this.root = root;
		start=begin;
		finish=end;
		
	}
//	public ArrayList<Path>bestPath(){
////		PriorityQueue<Route> answer=this.findRoute();
//		return answer.poll().getList();		
//		
//	}
	
	
//	public PriorityQueue<Route> addRoutes(){
//		PriorityQueue<Route> fin = new PriorityQueue<Route>();
//		for(Node n: start.getNeighbors()){
////			Path p= new Path(start,n,0,5,5);
////			ArrayList<Node> temp = new ArrayList<Node>();
////			temp.add(n);
////			Route r= new Route(temp,p.getDistCost());
//			if(start == root){
//				ArrayList<Path> temp = new ArrayList<Path>(); 
//				Path p = new Path(start, n, 0, 5, 5);
//				temp.add(p);
//				Route r = new Route(temp, p.getDistCost());
//				fin.add(r);
//			}
//			
//			else{ // start != root
//				for(Route r : fin){
//					r.getList().add(new Path(start, n, 0, 5, 5));  // add each path to their routes
//				}
//			}
//		}
//		return fin;
//	}
	
	PriorityQueue<Route> routes = new PriorityQueue<Route>();
	
	public void findRoute(ArrayList<Node> visited, Node n, ArrayList<Node> route){
		route.add(n);
		Double cost = getCost(route);
		Route r = new Route(route,cost);
		if(routes.peek() != null){
			if(routes.peek().getCost()<r.getCost())
				return;
			
		}
		for(Node neigh:n.getNeighbors()){
			if(neigh.name.equalsIgnoreCase(finish.name)){
				route.add(neigh);
				cost=getCost(route);
				Route fin=new Route(route,cost);
				routes.add(fin);
				return;
			}else{
				ArrayList<Node>unvisited=new ArrayList<Node>();
				boolean lookedAt=false;
				for(Node check: visited){
					if(neigh.name.equalsIgnoreCase(check.name)){
						lookedAt=true;
					}
					else{
						visited.add(neigh);
					}
					if(!lookedAt)
						unvisited.add(neigh);
					if(unvisited.size()==0)
						return;
					else{
						for(Node temp:unvisited){
							ArrayList<Node> routeTemp = route;
							routeTemp.add(temp);
							findRoute(visited,temp,routeTemp);
						}
					}
				}
			}
		}
		
		
	}
	private Double getCost(ArrayList<Node> route) {
		Double dist = (double) 0;
		for(int i = 0; i < route.size() - 2; i ++){
			dist += route.get(i).getDistance(route.get(i + 1));
		}
		return dist;
	}
	
	

}
