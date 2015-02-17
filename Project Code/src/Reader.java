import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {

	public static void main(String[] args) {
		Reader newReader = new Reader();
		try {
			newReader.TextReader();
		} catch (IOException e) {
			// Done Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < newReader.neighbours.size(); i++) {
			System.out.println("neighbours "+ newReader.neighbours.get(i));
		}
		System.out.println(newReader.landmarks.size());
		for (int i = 0; i < newReader.landmarks.size(); i++) {
			System.out.println("landmarks " + newReader.landmarks.get(i));
		}		
		System.out.println("x: " + newReader.x);
		System.out.println("y: " + newReader.y);
		
	}
	
	ArrayList<String> neighbours;
	ArrayList<String> landmarks;
	int x;
	int y;
	ArrayList<Node> cities;
	String name;
	
	public Reader() {
		neighbours = new ArrayList<String>();
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
			} 
			else if (line.charAt(0) != '*') {
				String name = tokens[0];
				this.name = name;
//				ArrayList<String> neighbours = new ArrayList<String>();
//				ArrayList<String> landmarks = new ArrayList<String>();
//				System.out.println(name);
				int j = 1;
//				System.out.println(tokens.length);
				while (tokens[j].charAt(0) != '0' && tokens[j].charAt(0) != '1'
						&& tokens[j].charAt(0) != '2'
						&& tokens[j].charAt(0) != '3'
						&& tokens[j].charAt(0) != '4'
						&& tokens[j].charAt(0) != '5'
						&& tokens[j].charAt(0) != '6'
						&& tokens[j].charAt(0) != '7'
						&& tokens[j].charAt(0) != '8'
						&& tokens[j].charAt(0) != '9') {
//					System.out.println(j);
					neighbours.add(tokens[j]);
//					System.out.println(tokens[j]);
//					System.out.println(j);
//					System.out.println(tokens[j].charAt(0) != '1');
					j++;
				}
				this.x = Integer.parseInt(tokens[j]);
//				System.out.println(x);
				j++;
				this.y = Integer.parseInt(tokens[j]);
//				System.out.println(y);
				j++;
//				System.out.println(j);
				while (j < tokens.length) {
					landmarks.add(tokens[j]);
//					System.out.println(landmarks.get(j));
					j++;
				}
			}
			Node city = new Node(this.name, this.landmarks, this.neighbours, this.x, this.y);
			this.cities.add(city);
			this.name = "";
			this.landmarks = new ArrayList<String>();
			this.neighbours = new ArrayList<String>();
			this.x = 0;
			this.y = 0;
			
		}
		br.close();
	}
	
	
}
