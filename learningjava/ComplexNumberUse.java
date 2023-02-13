package learningjava;

public class ComplexNumberUse {
	
	public static void main(String[] args) {
		
		ComplexNumber c1 = new ComplexNumber(2,3);
		c1.print();
		
		c1.setReal(10);
		c1.setImg(30);
		c1.print();
		
		ComplexNumber c2 = new ComplexNumber(1,5);
		c1.add(c2);
		c1.print();
		c2.print();
		
		c1.multiply(c2);
		c1.print();
		c2.print();
		
		ComplexNumber c3 = ComplexNumber.addTwoComplex(c1, c2);
		c3.print();
		
		ComplexNumber c4 = c3.conjugate();
		c4.print();
	
	}

}	
