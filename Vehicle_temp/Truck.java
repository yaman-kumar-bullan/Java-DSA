package Vehicle_temp;

import oops.Vehicle;

public class Truck extends Vehicle {
	
		int maxLoadingCapacity;
		
		public Truck(int maxLoadingCapacity, int maxSpeed) {
			super(maxSpeed);
			this.maxLoadingCapacity = maxLoadingCapacity;
		}
		
		public void print() {
			System.out.println("Max Loading capacity : " + maxLoadingCapacity);
			System.out.println("color : " + color);
			System.out.println("max speed : " + getMaxSpeed());
		}

}
