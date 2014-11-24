package edu.csupomona.cs.cs356.project2.GUTS;

import java.util.ArrayList;
import java.util.List;

//handles calculating the total amount of messages 
public class Message {
	
	private int msgTot;
	private List<IComponent> people;
	private List<String> news;
	
	public Message(List<IComponent> users){
		setMsgTot(0);
		people = new ArrayList<>(users);
	}

	public int getMsgTot() {
		for(IComponent us : people){
			news = ((User) us).getNewsFeed(us);
			for(String n : news){
				msgTot++;
			}
		}
		return msgTot;
	}

	public void setMsgTot(int msgTot) {
		this.msgTot = msgTot;
	}
}
