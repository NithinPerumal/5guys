import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class tripPlannerPanel {
	JPanel side;
	
	public tripPlannerPanel(){
		side = new JPanel();
		side.setBackground(Color.RED);
		side.setPreferredSize(new Dimension(150,500));
		
		String[] cityStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		JComboBox cityList = new JComboBox(cityStrings);
		side.add(cityList);
		
		JLabel timeLabel = new JLabel("Enter a time to travel:");
		side.add(timeLabel);
		TextField time = new TextField(10);
		side.add(time);
		
		JLabel distanceLabel = new JLabel("Enter a distance to travel:");
		side.add(distanceLabel);
		TextField distance = new TextField(10);
		side.add(distance);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton path1 = new JRadioButton("Path 1");
		path1.setBackground(Color.RED);
		group.add(path1);
		side.add(path1);
		JRadioButton path2 = new JRadioButton("Path 2");
		path2.setBackground(Color.RED);
		group.add(path2);
		side.add(path2);
		JRadioButton path3 = new JRadioButton("Path 3");
		path3.setBackground(Color.RED);
		group.add(path3);
		side.add(path3);
		
	}

}
