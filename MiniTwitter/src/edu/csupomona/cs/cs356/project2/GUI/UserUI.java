/*
 * Noemi Zamarripa 
 * 
 * CS356: Object Oriented Design 
 * Prof. Sun
 * 11-23-2014
 * 
 * Project 2: Mini Twitter
 */
package edu.csupomona.cs.cs356.project2.GUI;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.csupomona.cs.cs356.project2.GUTS.IComponent;
import edu.csupomona.cs.cs356.project2.GUTS.User;

public class UserUI {

	// triggers the user UI to display
	public UserUI(String name, User u, List<IComponent> users) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new MainFrameUserUI(name, u, users);
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
