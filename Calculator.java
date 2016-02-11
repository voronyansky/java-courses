import java.lang.Math;

public class Calculator
{
	//Hold a result of computing
	private int result;
	
	
	/*
	* @param 
	* int param - numbers from user
	*/
	public void add(int ... param)
	{
		for(int p:param)
			result+=p;
	}
	
	/*
	* @param: first - number from user
	*         second - number from user
	*/
	public void multiply(int first, int second)
	{
		this.result = first * second;
	}
	
	/*
	* @param:first - number from user
	*		 second - number from user
	*/
	public void divide(int first, int second)
	{
		this.result = first/second;
	}
	
	/*
	* @param: first - number from user
	*         second - number from user
	*/
	public void substract(int first, int second)
	{
		this.result = first - second;
	}
	
	/*
	* @param: first - number from user
	*		  second - number from user
	*/
	public void pow(int first, int second)
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
	
	/*
	* Clean a result
	*/
	public void cleanResult()
	{
		this.result = 0;
	}
}