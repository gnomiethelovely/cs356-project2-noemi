package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ListUserUI extends JPanel {

	// create the constraints object for placement details
	private GridBagConstraints gc = new GridBagConstraints();
	//provides the framework for the list
	private DefaultListModel<String> defListModel = new DefaultListModel<>();
	private DefaultListModel<String> defListModel1 = new DefaultListModel<>();
	private static String[] news = new String[100];
	private static String[] follow = new String[100];
	private static int i = 0;
	private static int j = 0;
	private static JScrollPane scrollBox = null;
	private static JScrollPane scrollBox1 = null;
	
	public ListUserUI() {
		createDetails();
	}

	public void createDetails() {
		//sets new layout 
		setLayout(new GridBagLayout());

		//creates a list object
		JList<String> newsFeed = null;
		newsFeed = addAList(newsFeed, 15, 15, 8, defListModel);
		
		JList<String> following = null;
		following = addAList(following, 15, 15, 8, defListModel1);

		//adds the scroll box 
		setInsets(5, 10, 5, 10);
		scrollBox = addAScrollBox(scrollBox, newsFeed, 260, 280, 0, 0);
		
		setInsets(5, 10, 5, 10);
		scrollBox1 = addAScrollBox(scrollBox1, following, 260, 280, 1, 0);

		//populates the list with strings
		populateList(news, defListModel);
		populateList(follow, defListModel1);
		
	}

	public static void addToNews(String item){
		news[i] = item;
		i++;
		scrollBox.repaint();
		scrollBox.revalidate();
	}
	
	public static void addToFollow(String item){
		follow[j] = item;
		j++;
		scrollBox1.repaint();
		scrollBox1.revalidate();
	}
	
	//walks through the provided array and inserts the items into the list
	private void populateList(String[] stuff, DefaultListModel<String> model) {
		for (String thing : stuff) {
			model.addElement(thing);
		}
	}

	//creates a new JList, gives the option to specify dimension of the cells 
	//and how many of them can be viewed at a time
	private JList<String> addAList(JList<String> list, int cellHeight,
			int cellWidth, int rows, DefaultListModel<String> model) {
		list = new JList<String>(model);
		list.setVisibleRowCount(rows);
		list.setFixedCellHeight(cellHeight);
		list.setFixedCellWidth(cellWidth);

		return list;
	}

	//creates a new scroll pane, that adds scroll bars and allows specification
	//of the dimensions
	private JScrollPane addAScrollBox(JScrollPane box, JList<String> list,
			int width, int height, int x, int y) {
		box = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		Dimension size = box.getPreferredSize();
		size.width = width;
		size.height = height;
		box.setPreferredSize(size);
		gc.gridx = x;
		gc.gridy = y;
		add(box, gc);

		return box;
	}

	//sets the insets to for formatting 
	private void setInsets(int top, int left, int bottom, int right) {
		gc.insets = new Insets(top, left, bottom, right);
	}
}
