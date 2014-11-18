package edu.csupomona.cs.cs356.project2.GUTS;

public interface ISubject {
	public void attach(User observer);
	public void notifyUsers(User observer);
}
