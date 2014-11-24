package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;

import edu.csupomona.cs.cs356.project2.GUTS.IComponent;
import edu.csupomona.cs.cs356.project2.GUTS.User;

@SuppressWarnings("serial")
public class MainFrameUserUI extends JFrame {

	private ButtonUserUI buttons;
	private ListUserUI list;

	public MainFrameUserUI(String title, User u, List<IComponent> users) {
		super(title);

		getContentPane().setLayout(new BorderLayout());

		buttons = new ButtonUserUI(u, users);
		list = new ListUserUI();

		Container window = getContentPane();

		window.add(buttons, BorderLayout.NORTH);
		window.add(list, BorderLayout.CENTER);
	}
}
