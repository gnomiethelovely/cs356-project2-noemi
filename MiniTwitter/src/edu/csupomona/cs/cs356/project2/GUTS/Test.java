package edu.csupomona.cs.cs356.project2.GUTS;

import java.util.ArrayList;
import java.util.List;

import edu.csupomona.cs.cs356.project2.GUI.*;

public class Test {

	public static void main(String[] args) {
		MiniTwitter.getInstance();
		User me = new User("gnomiethelovely");
		User follower = new User("follower");
		User follower1 = new User("follower1");
		User follower2 = new User("follower2");
		User follower3 = new User("follower3");
		Group root = new Group("Root");
		Group cs356 = new Group("CS356");
		
		List<IComponent> users = new ArrayList<IComponent>();
		List<Group> groups = new ArrayList<Group>();

		users.add(follower3);
		users.add(follower2);
		users.add(follower1);
		users.add(follower);
		users.add(me);
		
		groups.add(cs356);
		groups.add(root);
		
		Message m = new Message(users);

		me.attach(follower);
		me.attach(follower1);
		me.attach(follower2);
		me.attach(follower3);
		
		me.follow(follower);
		
		me.tweet("Hello!");
		me.tweet("Another one!");
		follower.tweet("Hi there!");
		me.tweet("Another one!");
		follower1.tweet("Hi there!");

		me.displayTweets(me.getFollowing());
		
		root.add(me);
		root.add(follower3);
		root.add(cs356);
		cs356.add(follower2);
		cs356.add(follower);
		
		me.display();
		
		System.out.println(root.getName() + " members.");
		root.display();
		System.out.println(cs356.getName() + " members.");
		cs356.display();
		
		Analytics ana = new Analytics();
		ana.sum(root);
		ana.sum(me);
		ana.sum(m);
		Positive p = new Positive(users);
		ana.sum(p);
		
	}

}
