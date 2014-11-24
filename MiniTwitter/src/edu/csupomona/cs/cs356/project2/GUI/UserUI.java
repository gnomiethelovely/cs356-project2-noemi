package edu.csupomona.cs.cs356.project2.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UserUI {

	//triggers the user UI to display 
	public UserUI(String name){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new MainFrameUserUI(name);
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
