import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class homePanel {
	JPanel side;
	
	public homePanel(){
		side = new JPanel();
		side.setBackground(Color.RED);
		side.setPreferredSize(new Dimension(150,500));
		String cost = "City 1 to City 2 60 miles";
		JTextArea textArea = new JTextArea(cost, 5, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		side.add(textArea);
		String paths = "This is a test here \n is a path a whole new \n path maybe another";
		JTextArea textArea1 = new JTextArea(paths, 10, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		side.add(textArea1);
	}
}
