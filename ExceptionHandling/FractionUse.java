package ExceptionHandling;

public class FractionUse {
	
	public static void main(String[] args) {
		
		Fraction f1 = new Fraction(20,30);
		int i = 0; //I need to increase this i to 1 doesn't matter it shows exception or not
		
		try {
			f1.setDen(0);
		} catch(ZeroDenominatorException e) {
			System.out.println("Denominator cannot be zero");
		} finally {
			i++;
		}
		
		System.out.println(i);
		
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

