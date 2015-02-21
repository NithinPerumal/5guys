
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
		int width = 1000;
		int height = 500;
		final JFrame background = new JFrame();
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
		
		homePanel home = new homePanel(cities);
		sidePanel.add(home.side);
		back.add(sidePanel, BorderLayout.LINE_END);
		
		ActionListener topBarListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JMenuItem topBarName = (JMenuItem) e.getSource();
				String name = topBarName.getText();
				if (name == "Trip Planner"){
					tripPlannerPanel trip = new tripPlannerPanel();
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(trip.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
				if (name == "City"){
					search1Panel search1 = new search1Panel();
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(search1.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
				if (name == "Home"){
					homePanel home = new homePanel(cities);
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(home.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
				if (name == "Path"){
					search2panel search2 = new search2panel();
					back.remove(sidePanel);
					sidePanel.removeAll();
					sidePanel.add(search2.side);
					back.add(sidePanel, BorderLayout.LINE_END);
					back.validate();
				}
			}
		};
		
		
		mapPanel mapP = new mapPanel(cities, neighborMap);
		mapP.setBackground(Color.GREEN);
		back.add(mapP, BorderLayout.CENTER);
		
//		search2panel search2 = new search2panel();
//		back.add(search2.side, BorderLayout.LINE_END);
		
		
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
