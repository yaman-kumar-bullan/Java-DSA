package learningjava;

public class FractionUse {
	
	public static void main(String[] args){
		
		Fraction f1 = new Fraction(20,30);
		f1.print();
		
		Fraction f2 = new Fraction(3,4);
		f1.add(f2);
		f1.print();
		f2.print();
		
		f1.multiply(f2);
		f1.print();
		f2.print();
		
		Fraction f3 = Fraction.addTwoFraction(f1, f2);
		
		f3.print();
	}

}
