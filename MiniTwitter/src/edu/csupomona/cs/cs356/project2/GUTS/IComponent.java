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

//component interface that supports the features to be used 
//by a the User and Group classes.
public interface IComponent {
	public void add(IComponent user);

	public String getName();

	public void setName(String name);

	public void display();
}
