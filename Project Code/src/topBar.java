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
	
	public topBar(ActionListener listener){
		menubar = new JMenuBar();
		menubar.setBackground(Color.BLACK);
		//menubar.setBackground(Color.BLUE);
		JMenu menu = new JMenu("Home");
		menu.setForeground(Color.RED);
		JMenu menu2 = new JMenu("Trip Planner");
		menu2.setForeground(Color.RED);
		JMenu menu3 = new JMenu("Search");
		menu3.setForeground(Color.RED);
		JMenuItem item = new JMenuItem("Home");
		item.setBackground(Color.BLACK);
		item.setForeground(Color.RED);
		JMenuItem itemt = new JMenuItem("Trip Planner");
		itemt.setBackground(Color.BLACK);
		itemt.setForeground(Color.RED);
		JMenuItem itemm3 = new JMenuItem("City");
		itemm3.setBackground(Color.BLACK);
		itemm3.setForeground(Color.RED);
		JMenuItem itemm32 = new JMenuItem("Path");
		itemm32.setBackground(Color.BLACK);
		itemm32.setForeground(Color.RED);
		
		menu.addActionListener(listener);
		menu2.addActionListener(listener);
		item.addActionListener(listener);
		itemt.addActionListener(listener);
		itemm3.addActionListener(listener);
		itemm32.addActionListener(listener);
		
		menu.add(item);
		menu2.add(itemt);
		menu3.add(itemm3);
		menu3.add(itemm32);
		menubar.add(menu);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.setPreferredSize(new Dimension(1000, 20));
		
		
	}

}
