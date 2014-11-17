package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class TreeAdminUI extends JPanel {

	public TreeAdminUI() {
		createDetails();
	}

	private void createDetails() {
		// sets dimension of the area on the panel for the
		// objects to be displayed
		Dimension disp = getPreferredSize();
		disp.width = 275;
		setPreferredSize(disp);

		//creates a border to indicate what is being displayed
		setBorder(BorderFactory.createTitledBorder("Tree View"));

		//create a few nodes
		DefaultMutableTreeNode CS356;
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");

		//create a tree
		JTree tree = null;
		tree = addATree(tree, rootNode, 10);

		//add some files
		CS356 = addAFile("CS356", rootNode);
		addAFile("User", CS356);
		addAFile("AnotherUser", CS356);

		//add a scrollbox for the tree
		JScrollPane scrollBox = new JScrollPane(tree);
		addAScrollBox(scrollBox, 250, 320);
	}

	//creates a tree and its attributes
	private JTree addATree(JTree tree, DefaultMutableTreeNode root, int rows) {
		//insert the root into the tree
		tree = new JTree(root);

		//allows the user to select one object at a time 
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);

		//allow this many rows to visible at one time 
		tree.setVisibleRowCount(rows);

		return tree;
	}

	//creates a scroll box with dimensions 
	private void addAScrollBox(JScrollPane box, int width, int height) {
		Dimension size = box.getPreferredSize();
		size.width = width;
		size.height = height;
		box.setPreferredSize(size);
		add(box);
	}

	//adds a file to the tree structure 
	private DefaultMutableTreeNode addAFile(String filename,
			DefaultMutableTreeNode parent) {
		DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(filename);
		parent.add(newFile);

		return newFile;
	}
}
