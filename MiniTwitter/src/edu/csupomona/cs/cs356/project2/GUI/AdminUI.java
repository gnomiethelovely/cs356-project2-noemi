package edu.csupomona.cs.cs356.project2.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AdminUI {

	//triggers the admin UI to display 
	public AdminUI(){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new MainFrameAdminUI("Mini Twitter - Admin UI Panel");
				frame.setSize(600, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
