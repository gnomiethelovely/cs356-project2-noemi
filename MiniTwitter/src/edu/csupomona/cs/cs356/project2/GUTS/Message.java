package edu.csupomona.cs.cs356.project2.GUTS;

//handles calculating the total amount of messages 
public class Message {
	
	private static int msgTot;
	
	public Message(){
		setMsgTot(0);
	}

	public int getMsgTot() {
		return msgTot;
	}

	public static void setMsgTot(int msgTot) {
		Message.msgTot = msgTot;
	}
}
