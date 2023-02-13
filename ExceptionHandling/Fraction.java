package ExceptionHandling;

public class Fraction {
	
	private int num;
	private int den;
	
	public Fraction(int num, int den) {
		this.num = num;
		
		if(den == 0) {
			//Error Out
		}
		this.den = den;
		simplify();
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
		simplify();
	}
	
	public int getDen() {
		return den;
	}
	
	public void setDen(int den) throws ZeroDenominatorException{
		if(den == 0) {
			ZeroDenominatorException e = new ZeroDenominatorException();
			throw e;
		}
		
		this.den = den;
		simplify();
	}
	
	private void simplify() {
		
		int min = num <= den ? num : den;
		
		//1 is the factor of each and every number
		
		int hcf = 1;
		
		for(int i=2; i<=min; i++) {
			if(num%i==0 && den%i==0) hcf = i;
		}
		
		num = num/hcf;
		den = den/hcf;
		
	}
	
	public void print() {
		
		if(den == 1) System.out.println(num);
		else System.out.println(num + "/" + den);
	}
	
	public void add(Fraction f) {
		this.num = (this.num * f.den) + (this.den * f.num);
		this.den = this.den * f.den;
		
		simplify();
	}
	
	public void multiply(Fraction f) {
		this.num = this.num * f.num;
		this.den = this.den * f.den;
		
		simplify();
	}
	
	
	public static Fraction addTwoFraction(Fraction f1, Fraction f2) {
		int num = (f1.num * f2.den) + (f2.num * f1.den);
		int den = f1.den * f2.den;
		
		Fraction f3 = new Fraction(num, den);
		
		return f3;
	}

}
