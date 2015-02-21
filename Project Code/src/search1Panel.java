import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class search1Panel {
	JPanel side;
	
	public search1Panel(){
		side = new JPanel();
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,500));
		ButtonGroup group = new ButtonGroup();
		JRadioButton most = new JRadioButton("Most to least");
		most.setBackground(Color.BLACK);
		most.setForeground(Color.RED);
		group.add(most);
		side.add(most);
		JRadioButton least = new JRadioButton("Least to Most");
		least.setBackground(Color.BLACK);
		least.setForeground(Color.RED);
		group.add(least);
		side.add(least);
		
		JTextArea textArea = new JTextArea(8, 10);
		JScrollPane scrollPane = new JScrollPane(textArea);
		side.add(scrollPane);
		textArea.setEditable(false);
	}

}
