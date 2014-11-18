package edu.csupomona.cs.cs356.project2.GUTS;

import java.util.ArrayList;

public class User implements IObserver, ISubject{
	private String id;
	private ArrayList<User> followers;
	private ArrayList<User> following;
	private ArrayList<String> newsFeed;
	
	public User(String name){
		setName(name);
		followers = new ArrayList<>();
		following = new ArrayList<>();
		newsFeed = new ArrayList<>();
	}

	@Override
	public void attach(User observer) {
		followers.add(observer);
		notifyUsers(observer);
	}

	@Override
	public void notifyUsers(User observer) {
		update(observer.getName());
	}

	@Override
	public void update(String name) {
		System.out.println(name + " is now following you!");
	}
	
	public void tweet(String tweet){
		newsFeed.add(tweet);
	}
	
	public void displayTweets(){
		for(String tweet : newsFeed){
			System.out.println(tweet);
		}
	}
	
	public void follow(User observer){
		following.add(observer);
		notifyUsers(observer);
	}
	
	public void seeFollowing(){
		int i = 1;
		for(User obs : following){
			System.out.println(i + " " + obs.getName());
			i++;
		}
	}
	
	public void seeFollowers(){
		int i = 1;
		for(User obs : followers){
			System.out.println(i + " " + obs.getName());
			i++;
		}
	}
	
	public void setName(String name){		
		this.id = name;
	}
	
	public String getName(){
		return id;
	}
}
