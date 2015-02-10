
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlannerFrame {
	public static void main(String[] args) {
		int width = 1000;
		int height = 500;
		final JFrame background = new JFrame();
		background.setSize(width, height);
		JPanel back = new JPanel();
		back.setLayout(new BorderLayout());
		
		mapPanel mapP = new mapPanel();
		mapP.setBackground(Color.GREEN);
		back.add(mapP, BorderLayout.CENTER);
		
		homePanel home = new homePanel();
		back.add(home.side, BorderLayout.LINE_END);
		
		
		topBar menuBar = new topBar();
		back.add(menuBar.menubar, BorderLayout.NORTH);
		
		background.add(back);
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background.setVisible(true);
	}
}
