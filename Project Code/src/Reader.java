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
				
				j++;
				while (j < tokens.length) {
					landmarks.add(tokens[j]);
					j++;
				}
			}
			if (this.name.length() != 0) {
				Node city = new Node(this.name, this.landmarks, null, this.x,
						this.y, this.interest);
				
				this.cities.add(city);

				this.name = "";
				this.landmarks = new ArrayList<String>();
				this.x = 0;
				this.y = 0;
			}

		}
		br.close();

		BufferedReader br2;
		br2 = new BufferedReader(new FileReader("Neighbours.txt"));
		String line2 = "";
		while ((line2 = br2.readLine()) != null) {
			String[] tokens = line2.split("\\s+");
			if (!line2.equals("**")) {
				
				for (int i = 1; i < tokens.length; i++) {
					for (int j = 0; j < this.cities.size(); j++) {
						if (tokens[0].equals(cities.get(j).name)) {
							for (int k = 0; k < this.cities.size(); k++) {
								
								if (tokens[i].equals(cities.get(k).toString())) {
									
									this.neighbours.add(cities.get(k));
								}
								
							}
						}
					}

				}
				for (int l = 0; l < this.cities.size(); l++) {
					if (tokens[0].equals(cities.get(l).name)) {
						cities.get(l).neighbors = this.neighbours;
						this.neighbormap.put(cities.get(l), this.neighbours);
					}
				}

				this.neighbours = new ArrayList<Node>();
			}
		}

		br2.close();

		BufferedReader br3;
		br3 = new BufferedReader(new FileReader("City-Paths.txt"));
		String line3;
		while ((line3 = br3.readLine()) != null) {
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
								HashMap<Node, Integer> temp = this.distanceMap;
								this.cities.get(i).distMap = temp;
							}
						}
					}

				}
			}

		}
		br3.close();
	}

}
