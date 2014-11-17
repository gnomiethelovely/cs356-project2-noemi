package edu.csupomona.cs.cs356.project2.GUTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable implements Observer{
	private String id;
	private List<User> followers;
	private List<User> following;
	private List<String> newsFeed;

	public User(){
		id = null;
		followers = new ArrayList<>();
		following = new ArrayList<>();
		newsFeed = new ArrayList<>();
	}
	
	public User(String name){
		this.id = name;
		followers = new ArrayList<>();
		following = new ArrayList<>();
		newsFeed = new ArrayList<>();
	}
	
	public void attach(User observer){
		following.add(observer);
		setChanged();
		notifyObservers(observer.getId());
	}
	
	@Override
	public void update(Observable subject, Object observer) {
		if (!id.equals(subject.toString())){
			System.out.println("New name is: " + id);
		}
		System.out.println("Following " + observer.toString());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		setChanged();
		notifyObservers(id);
	}
}
