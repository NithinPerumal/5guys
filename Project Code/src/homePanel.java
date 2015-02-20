import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class homePanel {
	JPanel side;
	ArrayList<Node> list;
	
	public homePanel(ArrayList<Node> cities){
		list = cities;
		side = new JPanel();
		side.setBackground(Color.RED);
		side.setPreferredSize(new Dimension(150,500));
		JTextArea textArea = new JTextArea(5, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		side.add(textArea);
		String paths = "This is a test here \n is a path a whole new \n path maybe another";
		JTextArea textArea1 = new JTextArea(paths, 10, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		side.add(textArea1);
		final JTextField textField1 = new JTextField(10);
		side.add(textField1);
		final JTextField textField2 = new JTextField(10);
		side.add(textField2);
		ActionListener buttonListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String city1 = textField1.getText();
				String city2 = textField2.getText();
				for(int i=0; i<list.size(); i++){
					Node node1 = null;
					Node node2 = null;
					if (list.get(i).name.equals(city1)){
						node1 = list.get(i);
					}
					if (list.get(i).name.equals(city2)){
						node2 = list.get(i);
					}
					if (node1 != null && node2 != null){
						Graph finder = new Graph(node1, node1, node2);
						ArrayList<Node> visited = new ArrayList<Node>();
						ArrayList<Node> route = new ArrayList<Node>();
						finder.findRoute(visited, node1, route);
						System.out.println(route.toString());
						System.out.println("hey");
					}
				}
			}
			
		};
		JButton button = new JButton("Get Path");
		button.addActionListener(buttonListener);
		side.add(button);
	}
	
}
