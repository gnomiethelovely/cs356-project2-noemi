package edu.csupomona.cs.cs356.project2.GUTS;

import edu.csupomona.cs.cs356.project2.GUI.*;

public class MiniTwitter {
	
	private static AdminUI instance = null;
	
	private MiniTwitter(){}
	
	public static AdminUI getInstance(){
		if(instance == null){
			instance = new AdminUI();
		}
		return instance;
	}
}
