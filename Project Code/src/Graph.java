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
	public ArrayList<Path>bestPath(){
		PriorityQueue<Route> answer=this.addRoutes();
		return answer.poll().getList();		
		
	}
	
	
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
	
	public void findRoute(ArrayList<Node> visited, Node n, ArrayList<Node> route){
		route.add(n);
		route.get(0);
	}
	
	

}
