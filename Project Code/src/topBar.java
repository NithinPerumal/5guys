import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;

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
		menu.add(item);
		menu3.add(itemm3);
		menu3.add(itemm32);
		menubar.add(menu);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.setPreferredSize(new Dimension(1000, 20));
	}

}
