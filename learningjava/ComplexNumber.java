package learningjava;

public class ComplexNumber {
	
	private int real;
	private int img;
	
	public ComplexNumber(int real, int img) {
		this.real = real;
		this.img = img;
	}
	
	public void setReal(int real) {
		this.real = real;
	}
	
	public int getReal() {
		return real;
	}
	
	public void setImg(int img) {
		this.img = img;
	}
	
	public int getImg() {
		return img;
	}
	
	public void print() {
		if(img >= 0) System.out.println(real + "+" + img + "i");
		else System.out.println(real + "" + img + "i");
	}
	
	public void add(ComplexNumber c) {
		this.real = this.real + c.real;
		this.img = this.img + c.img;
	}
	
	public void multiply(ComplexNumber c) {
		int newReal = (this.real * c.real) - (this.img * c.img);
		int newImg = (this.real * c.img) + (this.img * c.real);
		
		this.real = newReal;
		this.img = newImg;
	}
	
	public static ComplexNumber addTwoComplex(ComplexNumber c1, ComplexNumber c2) {
		int newReal = c1.real + c2.real;
		int newImg = c1.img + c2.img;
		
		ComplexNumber c3 = new ComplexNumber(newReal, newImg);
		return c3;
	}
	
	public ComplexNumber conjugate() {
		int newReal = this.real;
		int newImg = this.img * (-1);
		
		ComplexNumber c4 = new ComplexNumber(newReal, newImg);
		return c4;
		
	}
	
	

}
