import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.plaf.metal.MetalComboBoxButton;


public class tripPlannerPanel {
	JPanel side;
	
	public tripPlannerPanel(ArrayList<Node> cities){
		side = new JPanel();
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,500));
		
		String[] cityStrings = new String[cities.size()];
		for (int i=0; i<cities.size(); i++){
			cityStrings[i] = cities.get(i).name;
		}
		JComboBox cityList = new JComboBox(cityStrings);
		cityList.setBackground(Color.BLACK);
		cityList.setForeground(Color.RED);
		cityList.setLightWeightPopupEnabled(false);
		side.add(cityList);
		
		JLabel timeLabel = new JLabel("Enter a time to travel:");
		timeLabel.setForeground(Color.RED);
		side.add(timeLabel);
		TextField time = new TextField(10);
		side.add(time);
		
		JLabel distanceLabel = new JLabel("Enter a distance to travel:");
		distanceLabel.setForeground(Color.RED);
		side.add(distanceLabel);
		TextField distance = new TextField(10);
		side.add(distance);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton path1 = new JRadioButton("Path 1");
		path1.setBackground(Color.BLACK);
		path1.setForeground(Color.RED);
		group.add(path1);
		side.add(path1);
		JRadioButton path2 = new JRadioButton("Path 2");
		path2.setBackground(Color.BLACK);
		path2.setForeground(Color.RED);
		group.add(path2);
		side.add(path2);
		JRadioButton path3 = new JRadioButton("Path 3");
		path3.setBackground(Color.BLACK);
		path3.setForeground(Color.RED);
		group.add(path3);
		side.add(path3);
		
	}

}
