
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PlannerFrame {	
	public static void main(String[] args) {
		int width = 1200;
		int height = 833;
		final JFrame background = new JFrame("India Trip Planner");
		background.setSize(width, height);
		final JPanel back = new JPanel();
		back.setLayout(new BorderLayout());
		
		Reader newReader = new Reader();
		try {
			newReader.TextReader();
		} catch (IOException e) {
			// Done Auto-generated catch block
			e.printStackTrace();
		}
		final ArrayList<Node> cities = newReader.cities;
		HashMap<Node, ArrayList<Node>> neighborMap = newReader.neighbormap;
		
		final JPanel sidePanel = new JPanel();
		sidePanel.setBackground(Color.BLACK);
		
		final mapPanel mapP = new mapPanel(cities, neighborMap);
		back.add(mapP, BorderLayout.CENTER);
		
		homePanel home = new homePanel(cities, mapP);
		sidePanel.add(home.side);
		back.add(sidePanel, BorderLayout.LINE_END);
		mapP.addHomePanel(home);
		
		ActionListener topBarListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JMenuItem topBarName = (JMenuItem) e.getSource();
				String name = topBarName.getText();
				if (name == "Trip Planner"){
					tripPlannerPanel trip = new tripPlannerPanel(cities);
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(trip.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
				if (name == "Search"){
					searchPanel search1 = new searchPanel(cities);
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(search1.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
				if (name == "Home"){
					homePanel home = new homePanel(cities, mapP);
					mapP.addHomePanel(home);
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(home.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
			}
		};
		
		topBar menuBar = new topBar(topBarListener);
		back.add(menuBar.menubar, BorderLayout.NORTH);
		back.setBackground(Color.BLACK);
		
		background.add(back);
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background.setVisible(true);
	}
	
	public static void changeSideToCity(){
		System.out.println("Change City");
	}
}
