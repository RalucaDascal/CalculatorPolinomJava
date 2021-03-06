package PT2020.polinom.PolinomProject;


public class Monom {
	private int coef;
	private int pow;
	public Monom(int coef, int pow) {
		this.coef = coef;
		this.pow = pow;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

}

