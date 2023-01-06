package oopEx1;

public abstract class Terran extends Object{
	private String theUnit;

	public Terran() {
		super();
		
	}
	public Terran(String theUnit) {
		this.theUnit = theUnit;
	}
	
	public abstract void sound();
	
	public String toString() {
		return "이 유닛은 " + theUnit;
	}
	
	public String getTheUnit() {
		return theUnit.substring(theUnit.lastIndexOf(""));
	}
	
	
	
	
	
	
	
	
	
	
	
}
