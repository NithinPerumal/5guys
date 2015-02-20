import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Reader {

	public static void main(String[] args) {
		Reader newReader = new Reader();
		try {
			newReader.TextReader();
		} catch (IOException e) {
			// Done Auto-generated catch block
			e.printStackTrace();
		}

//		int count = 1;
//		for (Node name : newReader.neighbormap.keySet()) {
////			System.out.println(count);
//			String key = name.name;
//			String value = newReader.neighbormap.get(name).toString();
////			System.out.println(key + " : " + value);
//			count++;
//		}
		for (int i=0; i< newReader.cities.size(); i++){
			System.out.println("City: " + newReader.cities.get(i).name);
			System.out.println("Neighbors: " + newReader.cities.get(i).neighbors.toString());
		}
	}

	ArrayList<Node> neighbours;
	ArrayList<String> landmarks;
	int x;
	int y;
	ArrayList<Node> cities;
	String name;
	HashMap<Node, ArrayList<Node>> neighbormap = new HashMap<Node, ArrayList<Node>>();

	public Reader() {
		neighbours = new ArrayList<Node>();
		landmarks = new ArrayList<String>();
		int x = 0;
		int y = 0;
		this.cities = new ArrayList<Node>();
	}

	public void TextReader() throws IOException {
		BufferedReader br;
		br = new BufferedReader(new FileReader("City-list-with-landmarks.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			// process the line.
			// line.toString();
			String[] tokens = line.split("\\s+");
			if (line.equals("**")) {
				// DO Nothing yet
			} else if (line.charAt(0) != '*') {
				String name = tokens[0];
				this.name = name;
				int j = 1;
				this.x = Integer.parseInt(tokens[j]);
				j++;
				this.y = Integer.parseInt(tokens[j]);
				j++;
				while (j < tokens.length) {
					landmarks.add(tokens[j]);
					j++;
				}
			}
			if (this.name.length() != 0) {
				Node city = new Node(this.name, this.landmarks, null, this.x,
						this.y);

				// System.out.println("    ");
				this.cities.add(city);

				this.name = "";
				this.landmarks = new ArrayList<String>();
				// this.neighbours = new ArrayList<String>();
				this.x = 0;
				this.y = 0;
			}

		}
		br.close();

		BufferedReader br2;
		br2 = new BufferedReader(new FileReader("Neighbours.txt"));
		String line2 = "";
		System.out.println("just inside br2");
		while ((line2 = br2.readLine()) != null) {
			String[] tokens = line2.split("\\s+");
			if (!line2.equals("**")) {
				// DO Nothing yet
				// System.out.println("cities size: " + this.cities.size());
				// System.out.println("CITYSIZE: " + cities.size());
				for (int i = 1; i < tokens.length; i++) {
					for (int j = 0; j < this.cities.size(); j++) {
//						System.out.println("J: " + j);
						if (tokens[0].equals(cities.get(j).name)) {
							for (int k = 0; k < this.cities.size(); k++) {
//								System.out.println("tokens[i] " + tokens[i]);
//								System.out.println("cities: "
//										+ cities.get(k).toString());
								if (tokens[i].equals(cities.get(k).toString())) {
//									System.out.println("hihi");
									this.neighbours.add(cities.get(k));
								}
								// if(this.neighbours.contains(cities.get(j))){
								// continue;
								// }
							}
						}
					}
//					 System.out.println("neighbours " +
//					 neighbours.toString());
					// System.out.println("1");
//					System.out.println(cities.get(i).name);
//					System.out.println("size of neighbor "
//							+ this.neighbormap.get(cities.get(i)).size());

					// System.out.println(cities.get(i).toString());

				}
//				System.out.println(this.neighbours.toString());
				for (int l=0; l<this.cities.size(); l++){
					if (tokens[0].equals(cities.get(l).name)){
						System.out.println("City:" + cities.get(l).name);
						cities.get(l).neighbors = this.neighbours;
						System.out.println("Neighbors: " + cities.get(l).neighbors.toString());
						this.neighbormap.put(cities.get(l), this.neighbours);
						System.out.println(this.neighbormap.containsKey(cities.get(l)));
					}
				}

				// System.out.println(neighbours.size());
//				System.out.println(this.neighbormap.get(cities.get(0)) + " asdafwregwa");
				this.neighbours = new ArrayList<Node>();
//				System.out.println(this.neighbormap.get(cities.get(0)) + " asdafwregwa");
				// System.out.println("neighbours " + neighbours.toString());
			}
			// System.out.println(this.neighbours.toString());
			// this.neighbours = new ArrayList<Node>();
		}

		br2.close();
	}

}
