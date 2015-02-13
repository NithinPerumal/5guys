import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;


public class homePanel {
	JPanel side;
	
	public homePanel(){
		side = new JPanel();
		side.setBackground(Color.RED);
		side.setPreferredSize(new Dimension(100,500));
		//JButton button = new JButton("Test");
		//side.add(button);
	}
}
