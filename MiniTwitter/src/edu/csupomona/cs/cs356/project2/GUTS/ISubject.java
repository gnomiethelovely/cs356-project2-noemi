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

//Subject interface that allows observers to observer the subject, 
//and notify the users when information changes 
public interface ISubject {
	public void attach(IComponent observer);

	public void notifyUsers(IComponent observer);
}
