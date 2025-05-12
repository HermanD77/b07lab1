
public class Polynomial {
	double[] coefficients;
	
	public Polynomial()
	{
		coefficients = new double[1];
		coefficients[0] = 0;
	}
	
	public Polynomial(double[] coefficients)
	{
		int length = coefficients.length;
		this.coefficients = new double[length];
		for(int i = 0; i < length; i++)
		{
			this.coefficients[i] = coefficients[i];
		}
	}
	
	Polynomial add(Polynomial p)
	{
		double[] newCoefficients;
		Polynomial newPolynomial;
		int length1 = this.coefficients.length, length2 = p.coefficients.length;
		int index = 0;
		
		if(length2 > length1)
		{
			newCoefficients = new double[length2];
		}
		else
		{
			newCoefficients = new double[length1];
		}
		
		for(int i = 0; i < Math.min(length1, length2); i++)
		{
			newCoefficients[i] = this.coefficients[i] + p.coefficients[i];
			index++;
		}
		for(int i = index; i < length1; i++)
		{
			newCoefficients[i] = this.coefficients[i];
			index++;
		}
		for(int i = index; i < length2; i++)
		{
			newCoefficients[i] = p.coefficients[i];
			index++;
		}
		newPolynomial = new Polynomial(newCoefficients);
		return newPolynomial;
	}
	
	double evaluate(double x)
	{
		double result = 0.0;
		for(int i = 0; i < coefficients.length; i++)
		{
			result += (coefficients[i] * Math.pow(x, i));
		}
		return result;
	}
	
	boolean hasRoot(double x)
	{
		return (this.evaluate(x) == 0.0);
	}
}
