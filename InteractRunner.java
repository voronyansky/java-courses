import java.io.*;

public class InteractRunner
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int first = 0, second = 0;
		String response = "";
		String sign = "-";
		while(!response.equalsIgnoreCase("yes"))
		{
			/* Computing */
			System.out.println("Enter first number>>");
			first = Integer.valueOf(reader.readLine());
			System.out.println("Enter second number>>");
			second = Integer.valueOf(reader.readLine());
			System.out.println("Enter sign>>");
			sign = reader.readLine();
			System.out.println("Result = " + compute(first, second, sign));
			System.out.println("Type yes for exit, type no for continue");
			response = reader.readLine();
		}
		
	}
	
	public static int compute(int first, int second, String sing)
	{
		Calculator calc = new Calculator();
		if(sing.equalsIgnoreCase("+")) calc.add(first, second);
		else if(sing.equalsIgnoreCase("-")) calc.substract(first, second);
		else if(sing.equalsIgnoreCase("*")) calc.multiply(first, second);
		else if(sing.equalsIgnoreCase("/")) calc.divide(first, second);
		
		return calc.getResult();
	}
}