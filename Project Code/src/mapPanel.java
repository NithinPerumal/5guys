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

	public mapPanel(ArrayList<Node> cities) {
		mouseListener mouse = new mouseListener();
		list = cities;
		this.addMouseListener(mouse);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int i=0; i<list.size(); i++){
			list.get(i).draw(g2, 15);
		}
	}

	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			int x = e.getLocationOnScreen().x;
			int y = e.getLocationOnScreen().y;
			for (int i=0; i<list.size(); i++){
			if (list.get(i).getXCoord() + 30 > x
					&& list.get(i).getXCoord()  < x
					&& list.get(i).getYCoord() + 70 > y
					&& list.get(i).getYCoord() +50 < y) {
				list.get(i).setColor(g2, Color.BLUE);
			}
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
