import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class searchPanel {
	JPanel side;
	ArrayList<Node> list;
	
	public searchPanel(ArrayList<Node> cities){
		//Setting up the pane;
		list = sort(cities);
		side = new JPanel();
		side.setBackground(Color.BLACK);
		side.setPreferredSize(new Dimension(150,500));
		
		//Putting a label
		JLabel interestingnessLabel = new JLabel("Interestingness");
		interestingnessLabel.setBackground(Color.BLACK);
		interestingnessLabel.setForeground(Color.RED);
		side.add(interestingnessLabel);
		
		//Setting up text area for info
		final JTextArea textArea = new JTextArea(8, 10);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		Border border = BorderFactory.createLineBorder(Color.red);
		textArea.setBorder(border);
		ActionListener buttonListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String name = e.getActionCommand();
				if (name.equals("Most to Least")){
					String temp = "";
					for (int i=list.size()-1; i>=0; i--){
						temp = temp + list.get(i) +"\n";
					}
					textArea.setText(temp);
				} else {
					String temp = "";
					for (int i=0; i<list.size(); i++){
						temp = temp + list.get(i) +"\n";
					}
					textArea.setText(temp);
				}
			}
			
		};
		//Setting up Radio buttons
		ButtonGroup group = new ButtonGroup();
		JRadioButton most = new JRadioButton("Most to Least");
		most.addActionListener(buttonListener);
		most.setBackground(Color.BLACK);
		most.setForeground(Color.RED);
		group.add(most);
		side.add(most);
		
		JRadioButton least = new JRadioButton("Least to Most");
		least.addActionListener(buttonListener);
		least.setBackground(Color.BLACK);
		least.setForeground(Color.RED);
		group.add(least);
		side.add(least);
		
		//Setting up initial list going from most interesting to least interesting
		String temp = "";
		for (int i=0; i<list.size(); i++){
			temp = temp + list.get(i) +"\n";
		}
		textArea.setText(temp);
		JScrollPane scrollPane = new JScrollPane(textArea);
		side.add(scrollPane);
		textArea.setEditable(false);
		
	}
	
	private ArrayList<Node> sort(ArrayList<Node> list){
		return mergeSort(list);
	}
	
	private ArrayList<Node> mergeSort(ArrayList<Node> whole){
		ArrayList<Node> left = new ArrayList<Node>();
		ArrayList<Node> right = new ArrayList<Node>();
		int middle = whole.size()/ 2;
		if (whole.size() ==1){
			return whole;
		}
		for (int i=0; i<middle; i++){
			left.add(whole.get(i));
		}
		for (int j=middle; j<whole.size(); j++){
			right.add(whole.get(j));
		}
		left = mergeSort(left);
		right = mergeSort(right);
		merge(left, right, whole);
		return whole;
	}
	
	private void merge(ArrayList<Node> left, ArrayList<Node> right, ArrayList<Node> whole){
		int leftIndex = 0;
		int rightIndex = 0;
		int wholeIndex = 0;
		
		while (leftIndex < left.size() && rightIndex < right.size()){
			if (left.get(leftIndex).interest < right.get(rightIndex).interest){
				whole.set(wholeIndex, left.get(leftIndex));
				leftIndex++;
			} else{
				whole.set(wholeIndex, right.get(rightIndex));
				rightIndex++;
			}
			wholeIndex++;
		}
		ArrayList<Node> temp;
		int tempIndex;
		if (leftIndex >= left.size()){
			temp = right;
			tempIndex = rightIndex;
		} else{
			temp = left;
			tempIndex = leftIndex;
		}
		for (int i=tempIndex; i<temp.size(); i++){
			whole.set(wholeIndex, temp.get(i));
			wholeIndex++;
		}
	}

}
