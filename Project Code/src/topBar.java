import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class topBar {
	JMenuBar menubar;
	
	public topBar(){
		menubar = new JMenuBar();
		//menubar.setBackground(Color.BLUE);
		JMenu menu = new JMenu("Home");
		JMenu menu2 = new JMenu("Trip Planner");
		JMenu menu3 = new JMenu("Search");
		JMenuItem item = new JMenuItem("hello");
		JMenuItem itemm3 = new JMenuItem("City");
		JMenuItem itemm32 = new JMenuItem("Path");
		
		ActionListener menuListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add the home sidebar to the frame and redraw
				System.out.println("Home");
			}
		};
		
		ActionListener menu2Listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add the trip planner sidebar to the frame and redraw
				System.out.println("TripPlanner");
			}
		};
		
		ActionListener itemListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add the hello sidebar to the frame and redraw
				System.out.println("Hello");
			}
		};
		
		ActionListener itemm3Listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add the city sidebar to the frame and redraw
				System.out.println("City");
			}
		};
		
		ActionListener itemm32Listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//add the path sidebar to the frame and redraw
				System.out.println("Path");
			}
		};
		
		menu.addActionListener(menuListener);
		menu2.addActionListener(menu2Listener);
		item.addActionListener(itemListener);
		itemm3.addActionListener(itemm3Listener);
		itemm32.addActionListener(itemm32Listener);
		
		menu.add(item);
		menu3.add(itemm3);
		menu3.add(itemm32);
		menubar.add(menu);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.setPreferredSize(new Dimension(1000, 20));
		
		
	}

}
