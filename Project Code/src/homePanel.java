import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class homePanel {
	JPanel side;
	ArrayList<Node> list;
	mapPanel citySelects;
	JTextArea textArea = new JTextArea(5, 10);
	
	public homePanel(ArrayList<Node> cities, mapPanel selects){
		mouseListener mouse = new mouseListener();
		list = cities;
		citySelects = selects;
		side = new JPanel();
		side.addMouseListener(mouse);
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,1000));
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		Border border1 = BorderFactory.createLineBorder(Color.red);
		textArea.setBorder(border1);
		side.add(textArea);
		String paths = "This is a test here \n is a path a whole new \n path maybe another";
		final JTextArea textArea1 = new JTextArea(paths, 10, 10);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea1.setEditable(false);
		textArea1.setBackground(Color.BLACK);
		textArea1.setForeground(Color.WHITE);
		Border border2 = BorderFactory.createLineBorder(Color.red);
		textArea1.setBorder(border2);
		side.add(textArea1);
		ActionListener buttonListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<Node> sel = citySelects.getSelect();
				System.out.println("City Selects: " + sel.get(0).name);
				Node node1 = sel.get(0);
				Node node2 = sel.get(1);
				System.out.println("hey");
				if (node1 != null && node2 != null){
					System.out.println("got here");
					Graph finder = new Graph(node1, node1, node2);
					ArrayList<Node> visited = new ArrayList<Node>();
					ArrayList<Node> route = new ArrayList<Node>();
//					finder.findRoute(visited, node1, route);
					route = finder.bestPath();
//					Route r = new Route(node1,node2);
//					route=r.createPaths();
					String temp = "";
					for (int j=0; j<route.size(); j++){
						temp = temp + route.get(j) +"\n";
					}
					textArea1.setText(temp);
				}
			}
			
		};
		JButton button = new JButton("Get Path");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.RED);
		button.addActionListener(buttonListener);
		side.add(button);
	}
	
	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			ArrayList<Node> sel = citySelects.getSelect();
			if (sel.get(0) != null && sel.get(1) == null){
				textArea.setText(sel.get(0).name);
			}

		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}
	}
}
