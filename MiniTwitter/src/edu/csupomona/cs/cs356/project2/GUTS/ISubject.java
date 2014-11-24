package edu.csupomona.cs.cs356.project2.GUTS;

//Subject interface that allows observers to observer the subject, 
//and notify the users when information changes 
public interface ISubject {
	public void attach(IComponent observer);
	public void notifyUsers(IComponent observer);
}
