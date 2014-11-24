package edu.csupomona.cs.cs356.project2.GUTS;

//component interface that supports the features to be used 
//by a the User and Group classes.
public interface IComponent {
	public void add(IComponent user);
	public String getName();
	public void setName(String name);
	public void display();
}
