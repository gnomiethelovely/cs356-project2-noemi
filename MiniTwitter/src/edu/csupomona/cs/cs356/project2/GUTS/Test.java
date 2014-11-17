package edu.csupomona.cs.cs356.project2.GUTS;

import edu.csupomona.cs.cs356.project2.GUI.*;

public class Test {

	public static void main(String[] args) {
		//MiniTwitter.getInstance();
		User me = new User("gnomiethelovely");
		User another = new User();
		User follower = new User();
		
		me.addObserver(another);
		me.addObserver(follower);
		
		me.setId("thelovely");
	}

}
