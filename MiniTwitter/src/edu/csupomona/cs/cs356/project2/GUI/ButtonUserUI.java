package edu.csupomona.cs.cs356.project2.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.csupomona.cs.cs356.project2.GUTS.*;

@SuppressWarnings("serial")
public class ButtonUserUI extends JPanel {

	// create the constraints object for placement details
	private GridBagConstraints gc = new GridBagConstraints();
	private User me = new User("gnomiethelovely");
	
	public ButtonUserUI() {
		createDetails();
	}

	public void createDetails() {
		// create text field objects
		JTextField userIdField = new JTextField(10);
		JTextField msgField = new JTextField(10);

		// create button objects with labels
		JButton followUserBtn = new JButton("Follow");
		JButton postTweet = new JButton("Tweet");

		// sets the layout to a GridBagLayout
		setLayout(new GridBagLayout());
		gc.weightx = 0.5;

		// //Row 1////
		setInsets(10, 10, 5, 10);
		addAField(userIdField, 2, 0);
		addAButton(followUserBtn, 3, 0);

		//listens for button press to follow another user
		followUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] name = { userIdField.getText() };
				User u = new User(name[0]);
				me.follow(u);
				ListUserUI.addToFollow(name[0]);
			}
		});

		//listens for button press to tweet a message 
		postTweet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] name = { msgField.getText() };
				me.tweet(name[0]);
				ListUserUI.addToNews(name[0]);
			}
		});

		setInsets(10, 10, 5, 10);
		addAField(msgField, 0, 0);
		addAButton(postTweet, 1, 0);
	}

	// creates a text field, coordinates x and y are used to control
	// the position of the field on the panel
	private void addAField(JTextField field, int x, int y) {
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = x;
		gc.gridy = y;
		add(field, gc);
	}

	// creates a button, coordinates x and y are used to control
	// the position of the field on the panel
	private void addAButton(JButton button, int x, int y) {
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = x;
		gc.gridy = y;
		add(button, gc);
	}

	// sets the insets for each of the components to create consistent
	// spacing
	private void setInsets(int top, int left, int bottom, int right) {
		gc.insets = new Insets(top, left, bottom, right);
	}
}

@SuppressWarnings("serial")
class DetailEvent extends EventObject {
	private String text;

	public DetailEvent(Object source, String text) {
		super(source);
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
