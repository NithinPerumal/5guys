import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;


public class topBar {
	JMenuBar menubar;
	
	public topBar(ActionListener listener){
		menubar = new JMenuBar();
		menubar.setBackground(Color.BLACK);
		Border border1 = BorderFactory.createLineBorder(Color.red);
		menubar.setBorder(border1);
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
		JMenuItem itemm3 = new JMenuItem("Search");
		itemm3.setBackground(Color.BLACK);
		itemm3.setForeground(Color.RED);
		
		menu.addActionListener(listener);
		menu2.addActionListener(listener);
		item.addActionListener(listener);
		itemt.addActionListener(listener);
		itemm3.addActionListener(listener);
		
		menu.add(item);
		menu2.add(itemt);
		menu3.add(itemm3);
		menubar.add(menu);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.setPreferredSize(new Dimension(1200, 20));
		
		
	}

}
