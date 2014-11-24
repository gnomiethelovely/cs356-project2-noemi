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

import edu.csupomona.cs.cs356.project2.GUI.*;

//Singleton implementation of the AdminUI panel using lazy instantiation
public class MiniTwitter {

	private static AdminUI instance = null;

	private MiniTwitter() {
	}

	public static AdminUI getInstance() {
		if (instance == null) {
			instance = new AdminUI();
		}
		return instance;
	}
}
