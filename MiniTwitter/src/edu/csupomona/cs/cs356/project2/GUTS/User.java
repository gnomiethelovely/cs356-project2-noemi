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

import java.util.ArrayList;
import java.util.List;

public class User implements IObserver, ISubject, IComponent {

	// name for the user
	private String id;
	// lists to hold users and the newsFeed
	private List<IComponent> followers;
	private List<IComponent> following;
	private List<String> newsFeed;
	private static int userCount = 0;
	private static int msgCount = 0;

	public User(String name) {
		this.setName(name);
		followers = new ArrayList<>();
		following = new ArrayList<>();
		newsFeed = new ArrayList<>();
		userCount++;
	}

	@Override
	// from ISubject
	public void attach(IComponent observer) {
		followers.add(observer);
		notifyUsers(observer);
	}

	@Override
	// from ISubject
	public void notifyUsers(IComponent observer) {
		update(observer.getName());
	}

	@Override
	// from IObserver
	public void update(String name) {
		System.out.println("You are now following: " + name);
	}

	public void follow(IComponent observer) {
		following.add(observer);
		notifyUsers(observer);
	}

	public void tweet(String tweet) {
		newsFeed.add(tweet);
		System.out.println(tweet);
		msgCount++;
		Message.setMsgTot(msgCount);
	}

	public void displayTweets(List<IComponent> follow) {
		for (String tweet : newsFeed) {
			System.out.println(tweet);
		}
		for (IComponent user : follow) {
			List<String> tweets = ((User) user).getNewsFeed(user);
			System.out.println(tweets + "\n");
		}
	}

	// returns the newsfeed
	public List<String> getNewsFeed(IComponent user) {
		return newsFeed;
	}

	// returns the list of the users that the subject is following
	public List<IComponent> getFollowing() {
		return following;
	}

	@Override
	// from IComponent
	public void setName(String name) {
		this.id = name;
	}

	@Override
	// from IComponent
	public String getName() {
		return id;
	}

	@Override
	// from IComponent
	public void add(IComponent user) {
		attach(user);
	}

	@Override
	// from IComponent
	public void display() {
		int i = 1;
		System.out.println("Followers: ");
		for (IComponent obs : followers) {
			System.out.println(i + " " + obs.getName());
			i++;
		}

		i = 1;
		System.out.println("\nFollowing: ");
		for (IComponent obs : following) {
			System.out.println(i + " " + obs.getName());
			i++;
		}
	}

	public int getUserCount() {
		return userCount;
	}
}
