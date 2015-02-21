import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class homePanel {
	JPanel side;
	ArrayList<Node> list;
	
	public homePanel(ArrayList<Node> cities){
		list = cities;
		side = new JPanel();
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,1000));
		JTextArea textArea = new JTextArea(5, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		Border border1 = BorderFactory.createLineBorder(Color.red);
		textArea.setBorder(border1);
		side.add(textArea);
		String paths = "This is a test here \n is a path a whole new \n path maybe another";
		final JTextArea textArea1 = new JTextArea(paths, 10, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea1.setBackground(Color.BLACK);
		textArea1.setForeground(Color.WHITE);
		Border border2 = BorderFactory.createLineBorder(Color.red);
		textArea1.setBorder(border2);
		side.add(textArea1);
		final JTextField textField1 = new JTextField(10);
		side.add(textField1);
		final JTextField textField2 = new JTextField(10);
		side.add(textField2);
		ActionListener buttonListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String city1 = textField1.getText();
				String city2 = textField2.getText();
				Node node1 = null;
				Node node2 = null;
				for(int i=0; i<list.size(); i++){
					if (list.get(i).name.equals(city1)){
						node1 = list.get(i);
					}
					if (list.get(i).name.equals(city2)){
						node2 = list.get(i);
					}
				}
				System.out.println("hey");
				if (node1 != null && node2 != null){
					System.out.println("got here");
//					Graph finder = new Graph(node1, node1, node2);
					ArrayList<Node> visited = new ArrayList<Node>();
					ArrayList<Node> route = new ArrayList<Node>();
//					finder.findRoute(visited, node1, route);
					Route r = new Route(node1,node2);
					route=r.createPaths();
					String temp = "";
					for (int j=0; j<route.size(); j++){
						temp = temp + route.get(j) +"\n";
					}
					textArea1.setText(temp);
				}
			}
			
		};
		JButton button = new JButton("Get Path");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.RED);
		button.addActionListener(buttonListener);
		side.add(button);
	}
	
}
