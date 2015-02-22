import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalComboBoxButton;


public class tripPlannerPanel {
	JPanel side;
	ArrayList<Node> list;
	TextField distance;
	TextField time;
	
	public tripPlannerPanel(ArrayList<Node> cities){
		side = new JPanel();
		list = cities;
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,500));
		
		String[] cityStrings = new String[cities.size()];
		for (int i=0; i<cities.size(); i++){
			cityStrings[i] = cities.get(i).name;
		}
		String destinations = "";
		final JTextArea textArea = new JTextArea(destinations, 10, 10);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		Border border2 = BorderFactory.createLineBorder(Color.red);
		scrollPane.setBorder(border2);
		
		ActionListener boxListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				int index = box.getSelectedIndex();
				Node city = list.get(index);
				ArrayList<Node> found = new ArrayList<Node>();
				if (!time.getText().equals("") && distance.getText().equals("")){
					int interestWanted = Integer.parseInt(time.getText());
					found = findInterest(city, interestWanted);
				}else if (!distance.getText().equals("") && time.getText().equals("")){
					int distanceWanted = Integer.parseInt(distance.getText());
					found = findDistance(city, distanceWanted);
				}
				String temp = "";
				for (int j=0; j<found.size(); j++){
					temp = temp + found.get(j) +"\n";
				}
				if (found.size() == 0){
					temp = "Nothing found";
				}
				textArea.setText(temp);
			}
			
		};
		
		JComboBox cityList = new JComboBox(cityStrings);
		cityList.addActionListener(boxListener);
		cityList.setBackground(Color.BLACK);
		cityList.setForeground(Color.RED);
		cityList.setLightWeightPopupEnabled(false);
		side.add(cityList);
		
		JLabel timeLabel = new JLabel("Enter an intrest level:");
		timeLabel.setForeground(Color.RED);
		side.add(timeLabel);
		time = new TextField(10);
		side.add(time);
		
		JLabel distanceLabel = new JLabel("Enter a distance to travel:");
		distanceLabel.setForeground(Color.RED);
		side.add(distanceLabel);
		distance = new TextField(10);
		side.add(distance);
		side.add(scrollPane);
		
	}
	public ArrayList<Node> findDistance(Node start, int distance){
		ArrayList<Node> possibilities = new ArrayList<Node>();
		for (int i=0; i< start.neighbors.size(); i++){
			if (start.distMap.get(start.neighbors.get(i)) <= distance){
				possibilities.add(start.neighbors.get(i));
			}
		}
		return possibilities;
	}
	public ArrayList<Node> findInterest(Node start, int interest){
		ArrayList<Node> possibilities = new ArrayList<Node>();
		for (int i=0; i< start.neighbors.size(); i++){
			if (interest<= start.neighbors.get(i).interest){
				possibilities.add(start.neighbors.get(i));
			}
		}
		return possibilities;
	}

}
