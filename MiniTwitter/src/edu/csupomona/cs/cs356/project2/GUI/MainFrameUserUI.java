package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrameUserUI extends JFrame {

	private ButtonUserUI buttons;
	private ListUserUI list;

	public MainFrameUserUI(String title) {
		super(title);

		getContentPane().setLayout(new BorderLayout());

		buttons = new ButtonUserUI();
		list = new ListUserUI();

		Container window = getContentPane();

		window.add(buttons, BorderLayout.NORTH);
		window.add(list, BorderLayout.CENTER);
	}
}
