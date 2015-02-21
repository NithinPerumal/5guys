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

		// int count = 1;
		// for (Node name : newReader.neighbormap.keySet()) {
		// // System.out.println(count);
		// String key = name.name;
		// String value = newReader.neighbormap.get(name).toString();
		// // System.out.println(key + " : " + value);
		// count++;
		// }
		// for (int i = 0; i < newReader.cities.size(); i++) {
		// System.out.println("City: " + newReader.cities.get(i).name);
		// System.out.println("Neighbors: "
		// + newReader.cities.get(i).neighbors.toString());
		// }

		// int count = 1;
		// System.out.println(newReader.distanceMap.keySet().size());
		// int i = 0;
		for (int i = 0; i < newReader.cities.size(); i++) {
			System.out.println("MAIN KEYSET "
					+ newReader.cities.get(i).distMap.keySet());
			for (Node name : newReader.cities) {
				// System.out.println(count);
				// String key = name.name;
				// Integer value = newReader.distanceMap.get(name);
				// Integer value = newReader.cities.get(i).distMap.get(key);
				// System.out.println("MAINTEST " + key + " : " + value);

				System.out.println("Main VALUES "
						+ newReader.cities.get(i).distMap.get(name));
			}
			// count++;
			// i++;
		}

	}

	ArrayList<Node> neighbours;
	ArrayList<String> landmarks;
	int x;
	int y;
	int interest;
	ArrayList<Node> cities;
	String name;
	HashMap<Node, ArrayList<Node>> neighbormap = new HashMap<Node, ArrayList<Node>>();
	HashMap<Node, Integer> distanceMap = new HashMap<Node, Integer>();

	public Reader() {
		neighbours = new ArrayList<Node>();
		landmarks = new ArrayList<String>();
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
				this.interest = Integer.parseInt(tokens[j]);
				// System.out.println("penis in the vagina");
				j++;
				while (j < tokens.length) {
					landmarks.add(tokens[j]);
					j++;
				}
			}
			if (this.name.length() != 0) {
				Node city = new Node(this.name, this.landmarks, null, this.x,
						this.y, this.interest);
				// System.out.println("hm of the distcost " +
				// city.distMap.size());
				// System.out.println("distcost name " +
				// city.distMap.put(city,city.interest));
				// System.out.println("reader hm " + this.distanceMap.size());
				// System.out.println("distmap name " + distanceMap.put(city,
				// city.interest));
				// System.out.println("new reader hm " +
				// this.distanceMap.size());
				// city.setDistCostMap(distanceMap);
				// System.out.println("new distmap " + city.distMap.size());
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
		// System.out.println("just inside br2");
		while ((line2 = br2.readLine()) != null) {
			String[] tokens = line2.split("\\s+");
			if (!line2.equals("**")) {
				// DO Nothing yet
				// System.out.println("cities size: " + this.cities.size());
				// System.out.println("CITYSIZE: " + cities.size());
				for (int i = 1; i < tokens.length; i++) {
					for (int j = 0; j < this.cities.size(); j++) {
						// System.out.println("J: " + j);
						if (tokens[0].equals(cities.get(j).name)) {
							for (int k = 0; k < this.cities.size(); k++) {
								// System.out.println("tokens[i] " + tokens[i]);
								// System.out.println("cities: "
								// + cities.get(k).toString());
								if (tokens[i].equals(cities.get(k).toString())) {
									// System.out.println("hihi");
									this.neighbours.add(cities.get(k));
								}
								// if(this.neighbours.contains(cities.get(j))){
								// continue;
								// }
							}
						}
					}

				}
				// System.out.println(this.neighbours.toString());
				for (int l = 0; l < this.cities.size(); l++) {
					if (tokens[0].equals(cities.get(l).name)) {
						// System.out.println("City:" + cities.get(l).name);
						cities.get(l).neighbors = this.neighbours;
						// System.out.println("Neighbors: "
						// + cities.get(l).neighbors.toString());
						this.neighbormap.put(cities.get(l), this.neighbours);
						// System.out.println(this.neighbormap.containsKey(cities
						// .get(l)));
					}
				}

				// System.out.println(neighbours.size());
				// System.out.println(this.neighbormap.get(cities.get(0)) +
				// " asdafwregwa");
				this.neighbours = new ArrayList<Node>();
				// System.out.println(this.neighbormap.get(cities.get(0)) +
				// " asdafwregwa");
				// System.out.println("neighbours " + neighbours.toString());
			}
			// System.out.println(this.neighbours.toString());
			// this.neighbours = new ArrayList<Node>();
		}

		br2.close();

		BufferedReader br3;
		br3 = new BufferedReader(new FileReader("City-Paths.txt"));
		String line3;
		while ((line3 = br3.readLine()) != null) {
			// System.out.println("inside br3");
			String[] tokens = line3.split("\\s+");
			if (tokens[0].equals("**")) {
				this.distanceMap = new HashMap<Node, Integer>();
			} else if (!tokens[0].equals("**")) {
				for (int i = 0; i < this.cities.size(); i++) {
					if (tokens[0].equals(this.cities.get(i).name)) {
						for (int k = 0; k < this.cities.size(); k++) {
							if (tokens[1].equals(this.cities.get(k).name)) {
								this.distanceMap.put(this.cities.get(k),
										Integer.parseInt(tokens[2]));
								System.out.println("CITIES "
										+ this.cities.get(k));
								System.out.println("tokens[2] "
										+ Integer.parseInt(tokens[2]));
								// System.out.println(this.distanceMap.get(cities.get(k)));
								// System.out.println("distance : " +
								// distanceMap.get(this.cities.get(k)));
								HashMap<Node, Integer> temp = this.distanceMap;
								this.cities.get(i).distMap = temp;
								// System.out.println("distancemap stuff " +
								// this.distanceMap.get(cities.get(k)));
								// System.out.println("stuff " +
								// cities.get(i).distMap.get(this.cities.get(k)));
							}
						}
					}
					// System.out.println("distMap KEYSET: "
					// + this.cities.get(i).distMap.keySet());
					// System.out.println("distanceMap KEYSET"
					// + this.distanceMap.keySet());
					// this.distanceMap = new HashMap<Node, Integer>();

				}
			}

		}
		br3.close();
	}

}
