package oops;

public class Car extends Vehicle {
	
	int noOfGears;
	boolean isConvertible;
	
	public Car(int numOfGears, int maxSpeed) {
		super(maxSpeed);
		this.noOfGears = numOfGears;
		System.out.println("Car constructor");
	}
	 
	public void print() {
		super.print();
		System.out.println("noOfGears : " + noOfGears);
		System.out.println("isConvertible : " + isConvertible);
	}

}
