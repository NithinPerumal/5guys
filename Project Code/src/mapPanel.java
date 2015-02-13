import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class mapPanel extends JComponent {
	ArrayList<Node> list;
	Graphics2D g2;

	public mapPanel() {
		mouseListener mouse = new mouseListener();
		list = new ArrayList<Node>();
		this.addMouseListener(mouse);
		Node city2 = new Node("testCity", new ArrayList<Node>(), 200, 200);
		list.add(city2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		list.get(0).draw(g2, 15);
		
	}

	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			int x = e.getLocationOnScreen().x;
			int y = e.getLocationOnScreen().y;
			if (list.get(0).getXCoord() + 30 > x
					&& list.get(0).getXCoord()  < x
					&& list.get(0).getYCoord() + 70 > y
					&& list.get(0).getYCoord() +50 < y) {
				list.get(0).setColor(g2, Color.BLUE);
			}
			repaint();

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
