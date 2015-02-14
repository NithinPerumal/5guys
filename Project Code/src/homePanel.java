import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class homePanel {
	JPanel side;
	
	public homePanel(){
		side = new JPanel();
		side.setBackground(Color.RED);
		side.setPreferredSize(new Dimension(100,500));
		String cost = "City 1 to City 2 60 miles";
		JLabel distance = new JLabel(cost);
		side.add(distance);
		String paths = "This is a test /n here is a path /n a whole new path /n maybe another";
		JLabel path = new JLabel(paths);
		side.add(path);
	}
}
