/*
 * Noemi Zamarripa 
 * 
 * CS356: Object Oriented Design 
 * Prof. Sun
 * 11-23-2014
 * 
 * Project 2: Mini Twitter
 */
package edu.csupomona.cs.cs356.project2.GUTS;

import java.util.ArrayList;
import java.util.List;

public class Group implements IComponent {

	// list to hold multiple users, or a group
	private List<IComponent> group;
	// holds the name of the group
	private String groupName;
	private static int groupCount = 0;
	private long creationTime = 0;
	
	// creates a new group, assigning it a name and
	// an empty list
	public Group(String name) {
		this.setName(name);
		group = new ArrayList<>();
		groupCount++;
		creationTime = System.currentTimeMillis();
		System.out.println("Creation time of " + name + " " + creationTime);
	}

	// adds a component, in this case a user to the list
	@Override
	public void add(IComponent user) {
		group.add(user);
	}

	// displays the names of the users in that group
	@Override
	public void display() {
		for (IComponent u : group) {
			System.out.println(u.getName());
		}
	}

	// gets the group name
	@Override
	public String getName() {
		return groupName;
	}

	// sets the group name
	@Override
	public void setName(String groupName) {
		this.groupName = groupName;
	}

	// gets the count of the amount of groups
	public int getGroupCount() {
		return groupCount;
	}

}
