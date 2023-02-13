package oops;

public class VehicleUse {
	
	public static void main(String[] args) {
		
//		Vehicle v = new Vehicle(100);
//		v.print();
		
		Vehicle v = new Car(4,120);
		
		v.print();
		
		
		Car c = new Car(5, 100);
		
		c.color = "Black";
		c.noOfGears = 10;
		c.setMaxSpeed(100);
		
//		c.print();  //Car print function has overided Vehicle print function
	}

}
