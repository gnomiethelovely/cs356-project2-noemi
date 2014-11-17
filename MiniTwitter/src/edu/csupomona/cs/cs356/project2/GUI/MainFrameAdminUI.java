package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrameAdminUI extends JFrame{
	
	private ButtonAdminUI buttons;
	private TreeAdminUI treeView;
	
	public MainFrameAdminUI(String title){
		super(title);
		
		setLayout(new BorderLayout());
		
		buttons = new ButtonAdminUI();
		treeView = new TreeAdminUI();
		
		Container window = getContentPane();
		
		window.add(buttons, BorderLayout.EAST);
		window.add(treeView, BorderLayout.WEST);
	}
}
