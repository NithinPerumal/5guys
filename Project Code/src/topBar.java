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
		JMenu menu = new JMenu();
		JMenuItem item = new JMenuItem("hello");
		menu.add(item);
		menu.add(item);
		menubar.add(menu);
		menubar.setPreferredSize(new Dimension(1000, 20));
	}

}
