package oops;

public class Vehicle {
	
	protected String color;
	private int maxSpeed;
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("vehicle constructor");
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void print() {
		System.out.println("Color : " + color);
		System.out.println("Speed : " + maxSpeed);
	}

}
