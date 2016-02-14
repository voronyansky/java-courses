import java.io.*;

public class InteractRunner
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int first = 0, second = 0;
		String response = "";
		String sign = "-";
		String answer = "";
		Calculator calc = new Calculator();
		while(!response.equalsIgnoreCase("yes"))
		{
			/* Computing */
			System.out.println("Enter first number>>");
			first = Integer.valueOf(reader.readLine());
			System.out.println("Enter second number>>");
			second = Integer.valueOf(reader.readLine());
			System.out.println("Enter sign>>");
			sign = reader.readLine();
			calc.compute(first, second, sign);
			calc.setPrevResult(calc.getResult());
			System.out.println("Result = " + calc.getResult());
			System.out.println("Use previous value?");
			answer = reader.readLine();
			if(answer.equalsIgnoreCase("yes"))
			{
				System.out.println(calc.getPrevResult());
				System.out.println("Enter sign>>");
				sign = reader.readLine();
				System.out.println("Enter second number>>");
				second = Integer.parseInt(reader.readLine());
				calc.compute(calc.getPrevResult(), second, sign);
				System.out.println("Result = " + calc.getResult());
				calc.cleanResult();
			}
			else {
				System.out.println("Type yes for exit, type no for continue");
				calc.cleanResult();
				response = reader.readLine();
			}
			
		}
		
	}
}