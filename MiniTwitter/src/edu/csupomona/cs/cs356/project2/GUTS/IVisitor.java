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

//Visitor interface that calculates the sum of different analytical 
//measures for the admin to see 
public interface IVisitor {
	public void sum(User userAnalytics);

	public void sum(Group groupTot);

	public void sum(Message msgTot);

	public void sum(Positive percentTot);
}
