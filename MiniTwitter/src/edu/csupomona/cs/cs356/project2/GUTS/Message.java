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

//handles calculating the total amount of messages 
public class Message {

	private static int msgTot;

	public Message() {
		setMsgTot(0);
	}

	public int getMsgTot() {
		return msgTot;
	}

	public static void setMsgTot(int msgTot) {
		Message.msgTot = msgTot;
	}
}
