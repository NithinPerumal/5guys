import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class homePanel {
	JPanel side;
	ArrayList<Node> list;
	ArrayList<Node> route;
	mapPanel citySelects;
	JTextArea textArea = new JTextArea(5, 10);

	public homePanel(ArrayList<Node> cities, mapPanel selects) {
		mouseListener mouse = new mouseListener();
		list = cities;
		citySelects = selects;
		side = new JPanel();
		side.addMouseListener(mouse);
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150, 1000));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		Border border1 = BorderFactory.createLineBorder(Color.red);
		textArea.setBorder(border1);
		side.add(textArea);
		String paths = "";
		final JTextArea textArea1 = new JTextArea(paths, 10, 10);
		textArea1.setEditable(false);
		textArea1.setBackground(Color.BLACK);
		textArea1.setForeground(Color.WHITE);
		Border border2 = BorderFactory.createLineBorder(Color.red);
		textArea1.setBorder(border2);
		side.add(textArea1);
		ActionListener buttonListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Node> sel = citySelects.getSelect();
				Node node1 = sel.get(0);
				Node node2 = sel.get(1);
				JButton button = (JButton) e.getSource();
				if (button.getText().equals("Get Path by Distance")) {
					if (node1 != null && node2 != null) {
						Graph finder = new Graph(node1, node1, node2);
						ArrayList<Node> route = finder.bestPath();
						String temp = "";
						for (int j = 0; j < route.size(); j++) {
							temp = temp + route.get(j) + "\n";
						}
						textArea1.setText(temp);
					}
				}
				if (button.getText().equals("Get Path by Interest")) {
					if (node1 != null && node2 != null) {
						Graph finder = new Graph(node1, node1, node2);
						ArrayList<Node> route = finder.mostInteresting();
						String temp = "";
						for (int j = 0; j < route.size(); j++) {
							temp = temp + route.get(j) + "\n";
						}
						textArea1.setText(temp);
					}
				}
			}

		};
		JButton button1 = new JButton("Get Path by Distance");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.RED);
		button1.addActionListener(buttonListener);
		side.add(button1);
		JButton button2 = new JButton("Get Path by Interest");
		button2.setBackground(Color.BLACK);
		button2.setForeground(Color.RED);
		button2.addActionListener(buttonListener);
		side.add(button2);
	}

	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			ArrayList<Node> sel = citySelects.getSelect();
			if (sel.get(0) != null && sel.get(1) == null) {
				String info = "City: " + "\n" + sel.get(0).name;
				info = info + "\n" + "Landmarks: ";
				for (int i = 0; i < sel.get(0).getLandmarks().size(); i++) {
					info += "\n" + sel.get(0).getLandmarks().get(i);
				}
				textArea.setText(info);
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
