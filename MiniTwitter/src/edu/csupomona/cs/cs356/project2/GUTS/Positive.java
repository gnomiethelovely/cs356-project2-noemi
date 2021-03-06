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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

//handles calculating the positive percentage of messages 
public class Positive {

	private double percent;
	private int total;
	private int pos;
	private List<String> news;
	private List<IComponent> people;
	private CharSequence cs = "hello";

	public Positive(List<IComponent> user) {
		setPercent(0.0);
		setPos(0);
		people = new ArrayList<>(user);
	}

	// returns the positive comment percentage
	public String getPercent() {
		isPositive();
		DecimalFormat df = new DecimalFormat("#.##");
		percent = (double) pos / total;
		return df.format(percent);
	}

	// sets the percentage
	public void setPercent(double percent) {
		this.percent = percent;
	}

	// finds if a tweet is positive
	public void isPositive() {
		for (IComponent us : people) {
			news = ((User) us).getNewsFeed(us);
			for (String n : news) {
				total++;
				if (n.contains(cs)) {
					pos++;
				}
			}
		}
	}

	// gets the positive amount of tweets
	public double getPos() {
		return pos;
	}

	// sets the positive amount of tweets
	public void setPos(int pos) {
		this.pos = pos;
	}
}
