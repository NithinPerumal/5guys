import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class search2panel {
	JPanel side;
	
	public search2panel(){
		side = new JPanel();
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,500));
		ButtonGroup group = new ButtonGroup();
		JRadioButton distance = new JRadioButton("distance");
		distance.setBackground(Color.BLACK);
		distance.setForeground(Color.RED);
		group.add(distance);
		side.add(distance);
		JRadioButton time = new JRadioButton("Interestingness");
		time.setBackground(Color.BLACK);
		time.setForeground(Color.RED);
		group.add(time);
		side.add(time);
		
		JTextArea textArea = new JTextArea(8, 10);
		JScrollPane scrollPane = new JScrollPane(textArea);
		side.add(scrollPane);
		textArea.setEditable(false);
	}

}
