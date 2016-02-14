import java.lang.Math;

public class Calculator
{
	//Hold a result of computing
	private int result;
	//Hold a result of previous computing
	private int prevResult;
	
	
	public void compute(int first, int second, String sing)
	{
		if(sing.equalsIgnoreCase("+")) add(first, second);
		else if(sing.equalsIgnoreCase("-")) substract(first, second);
		else if(sing.equalsIgnoreCase("*")) multiply(first, second);
		else if(sing.equalsIgnoreCase("/")) divide(first, second);
		//this.prevResult = result;
	}
	/*
	* @param 
	* int param - numbers from user
	*/
	private void add(int first, int second)
	{
		
		this.result = first + second;
	}
	
	/*
	* @param: first - number from user
	*         second - number from user
	*/
	private void multiply(int first, int second)
	{
		this.result = first * second;
	}
	
	/*
	* @param:first - number from user
	*		 second - number from user
	*/
	private void divide(int first, int second)
	{
		this.result = first/second;
	}
	
	/*
	* @param: first - number from user
	*         second - number from user
	*/
	private void substract(int first, int second)
	{
		this.result = first - second;
	}
	
	/*
	* @param: first - number from user
	*		  second - number from user
	*/
	private void pow(int first, int second)
	{
		this.result = (int)Math.pow((double)first,(double)second);
	}
	
	/*
	* @return result of computing
	*/
	public int getResult()
	{
		return this.result;
	}
	
	public void setPrevResult(int value)
	{
		this.prevResult = value;
	}
	
	public int getPrevResult()
	{
		return this.prevResult;
	}
	
	/*
	* Clean a result
	*/
	public void cleanResult()
	{
		this.result = 0;
	}
	
}