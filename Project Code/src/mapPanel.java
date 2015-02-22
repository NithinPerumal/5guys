import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class mapPanel extends JComponent {
	ArrayList<Node> list;
	HashMap<Node, ArrayList<Node>> neighborsMap;
	Graphics2D g2;
	Node select1;
	Node select2;
	homePanel routes = null;

	public mapPanel(ArrayList<Node> cities, HashMap<Node, ArrayList<Node>> neighborMap) {
		mouseListener mouse = new mouseListener();
		list = cities;
		neighborsMap = neighborMap;
		this.addMouseListener(mouse);
	}
	
	public ArrayList<Node> getSelect(){
		ArrayList<Node> selection = new ArrayList<Node>();
		selection.add(select1);
		selection.add(select2);
		return selection;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("mapOfIndia.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, null);
		for (int i=0; i<list.size(); i++){
			ArrayList<Node> neighbors = neighborsMap.get(list.get(i));
			for (int j=0; j<neighbors.size(); j++){
				g2.setColor(Color.BLACK);
				//Magic numbers for lining up the endpoints of the line
				//The circle's radius does adjust properly for these lines
				int x1 = (int)list.get(i).getXCoord()+7;
				int x2 = (int)neighbors.get(j).getXCoord()+7;
				int y1 = (int)list.get(i).getYCoord()+10;
				int y2 = (int)neighbors.get(j).getYCoord()+10;
				g.drawLine(x1,y1,x2,y2);
			}
			
		}
		for (int k=0; k<list.size(); k++){
			list.get(k).draw(g2, 15);
			g2.setColor(Color.WHITE);
			g.drawString(list.get(k).name, (int)list.get(k).getXCoord(), (int)list.get(k).getYCoord() + 30);
		}
	}
	
	public ArrayList<Node> getSelects(){
		ArrayList<Node> selects = new ArrayList<Node>();
		selects.add(select1);
		selects.add(select2);
		return selects;
	}
	
	public void addHomePanel(homePanel route){
		routes = route;
	}

	private class mouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			int x = e.getLocationOnScreen().x;
			int y = e.getLocationOnScreen().y;
			int unselect = 1;
			for (int i=0; i<list.size(); i++){
			if (list.get(i).getXCoord() + 30 > x
					&& list.get(i).getXCoord()  < x
					&& list.get(i).getYCoord() + 70 > y
					&& list.get(i).getYCoord() +50 < y) {
				if (select1 != null && list.get(i) == select1){
					select1 = null;
					list.get(i).setColor(g2, Color.BLACK);
					unselect = 0;
				}
				if (select2 != null && list.get(i) == select2){
					select2 = null;
					list.get(i).setColor(g2, Color.BLACK);
					unselect = 0;
				}
				if (select1 == null && unselect == 1){
					select1 = list.get(i);
					list.get(i).setColor(g2, Color.BLUE);
				}
				if (select2 == null && select1 != list.get(i)&& unselect == 1){
					select2 = list.get(i);
					list.get(i).setColor(g2, Color.YELLOW);
				}
			}
			}
			repaint();

		}

		public void mouseEntered(MouseEvent e) {
			//Nothing done

		}

		public void mouseExited(MouseEvent e) {
			//Nothing done

		}

		public void mousePressed(MouseEvent e) {
			//Nothing done
		}

		public void mouseReleased(MouseEvent e) {
			//Nothing done

		}

	}
}
