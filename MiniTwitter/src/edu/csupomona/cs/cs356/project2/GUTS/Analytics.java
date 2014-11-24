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

//implements the Visitor interface and gets the different sums of these 
//statistics for the admin
public class Analytics implements IVisitor {

	@Override
	public void sum(User userTot) {
		System.out.println("User total: " + userTot.getUserCount());
	}

	@Override
	public void sum(Group groupTot) {
		System.out.println("Group total: " + groupTot.getGroupCount());
	}

	@Override
	public void sum(Message msgTot) {
		System.out.println("Message total: " + msgTot.getMsgTot());
	}

	@Override
	public void sum(Positive percentTot) {
		System.out.println("Positive message percent: "
				+ percentTot.getPercent());
	}

}
