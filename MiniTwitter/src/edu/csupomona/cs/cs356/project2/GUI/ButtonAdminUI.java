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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import edu.csupomona.cs.cs356.project2.GUTS.*;

@SuppressWarnings("serial")
public class ButtonAdminUI extends JPanel {

	// create the constraints object for placement details
	private GridBagConstraints gc = new GridBagConstraints();
	private User me = new User("gnomiethelovely");
	private Analytics ana = new Analytics();
	private Group g = new Group("theSquad");
	private List<IComponent> users = new ArrayList<IComponent>();
	private List<IComponent> groups = new ArrayList<IComponent>();
	private Message m = new Message();
	private Positive p = new Positive(users);

	public ButtonAdminUI() {
		createDetails();
		users.add(me);
	}

	// creates all objects and handles the creation of their
	// attributes
	private void createDetails() {
		// sets dimension of the area on the panel for the
		// objects to be displayed
		Dimension size = getPreferredSize();
		size.width = 300;
		size.height = 400;
		setPreferredSize(size);

		// create text field objects
		JTextField groupIdField = new JTextField(10);
		JTextField userIdField = new JTextField(10);

		// create button objects with labels
		JButton addUserBtn = new JButton("Add User");
		JButton addGroupBtn = new JButton("Add Group");
		JButton openUserViewBtn = new JButton("Open user view");
		JButton showTotUserBtn = new JButton("Total Users");
		JButton showTotGroupBtn = new JButton("Total Groups");
		JButton showTotMsgBtn = new JButton("Total Messages");
		JButton showPosPercentBtn = new JButton("Positive %");

		JButton idVerificationBtn = new JButton("Verify ID");
		JButton findLastUpdateBtn = new JButton("Last updated user");

		findLastUpdateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lastUpdated(users);
			}
		});

		idVerificationBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validID((ArrayList<IComponent>) users);
				validID((ArrayList<IComponent>) groups);
			}
		});

		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] name = { userIdField.getText() };
				User newUser = new User(name[0]);
				users.add(newUser);
			}
		});

		addGroupBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] name = { groupIdField.getText() };
				Group newGroup = new Group(name[0]);
				groups.add(newGroup);
			}
		});

		openUserViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserUI uui = new UserUI(me.getName(), me, users);
			}
		});

		showTotUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ana.sum(me);
			}
		});

		showTotGroupBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ana.sum(g);
			}
		});

		showTotMsgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ana.sum(m);
			}
		});

		showPosPercentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ana.sum(p);
			}
		});

		// sets the layout to a GridBagLayout
		setLayout(new GridBagLayout());
		gc.weightx = 0.5;

		// //Row 1////

		setInsets(5, 5, 5, 5);
		addAField(userIdField, 0, 0);
		addAButton(addUserBtn, 1, 0);

		// //Row 2////

		addAField(groupIdField, 0, 1);
		addAButton(addGroupBtn, 1, 1);

		// //Row 3////

		// long button, takes up 3 spaces
		gc.gridwidth = 3;
		setInsets(5, 5, 5, 5);
		addAButton(openUserViewBtn, 0, 2);

		// //Row 4////
		
		gc.gridwidth = 1;
		setInsets(5, 5, 70, 5);
		addAButton(idVerificationBtn, 0, 3);
		addAButton(findLastUpdateBtn, 1, 3);

		// //Row 5////

		// back to single length buttons
		gc.gridwidth = 1;
		setInsets(5, 5, 5, 5);
		addAButton(showTotUserBtn, 0, 4);
		addAButton(showTotMsgBtn, 1, 4);

		// //Row 6////
		addAButton(showTotGroupBtn, 0, 5);
		addAButton(showPosPercentBtn, 1, 5);
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

	private void validID(ArrayList<IComponent> users) {
		ArrayList<String> names = new ArrayList<>();
		for (IComponent c : users) {
			names.add(c.getName());
		}

		Set<String> unique = new HashSet<>(names);
		for (String temp : unique) {
			if (Collections.frequency(names, temp) > 1) {
				System.out.println("Duplicate id found! " + temp);
			} else if (temp.contains(" ")) {
				System.out.println("Invalid input! " + temp);
			}
		}
	}

	private void lastUpdated(List<IComponent> users) {
		ArrayList<Long> times = new ArrayList<>();
		long max = 0;
		int i = 0;

		for (IComponent c : users) {
			times.add(((User) c).getLastUpdateTime());
		}

		for (Long t : times) {
			if (t > max) {
				max = t;
				i = times.indexOf(t);
			}
		}

		System.out.println(users.get(i).getName());
	}
}
