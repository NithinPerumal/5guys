import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground());
		// g2.fill(new Rectangle(900, 500));
		Node city2 = new Node("testCity", new ArrayList<Node>(), 200, 200);
		list.add(city2);
		city2.draw(g2, 15);
	}

	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getLocationOnScreen().x + " "
					+ e.getLocationOnScreen().y);
			int x = e.getLocationOnScreen().x;
			int y = e.getLocationOnScreen().y;
			System.out.println(list.get(0).getXCoord());
			System.out.println(list.get(0).getYCoord());
			if (list.get(0).getXCoord() + 30 > x
					&& list.get(0).getXCoord()  < x
					&& list.get(0).getYCoord() + 70 > y
					&& list.get(0).getYCoord() +50 < y) {
				System.out.println("here");
				list.get(0).draw(g2,15);
			}

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
