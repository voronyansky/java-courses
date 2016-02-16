package src.calculator;
import java.io.*;

/*
    This class handled user input
 */

public class InteractRunner
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //Read from the console
		int first = 0, second = 0;                                                    //Variables for user input value
		String response = "";                                                         //Continue Yes or NO?
		String sign = "-";                                                            //Sign of math operators
		String answer = "";                                                           //Answer about use previous value of previous computing
		Calculator calc = new Calculator();                                           //Create a instance of Calculator class


        //While user don't type yes for response
        while(!response.equalsIgnoreCase("yes"))
        {
			System.out.println("Enter first number>>");
			first = Integer.valueOf(reader.readLine());  /* Handled of user input and give result from Calculator.java */
			System.out.println("Enter second number>>"); /* Also remember this result of computing. For this call      */
			second = Integer.valueOf(reader.readLine()); /* method setPrevResult(int result).                          */
			System.out.println("Enter sign>>");
			sign = reader.readLine();
			calc.compute(first, second, sign);
			calc.setPrevResult(calc.getResult());
			System.out.println("Result = " + calc.getResult()); //See user result of computing to user
			System.out.println("Use previous value?");          //Ask user for use result of previous computing
			answer = reader.readLine();                         //Read from the
			if(answer.equalsIgnoreCase("yes"))
			{
				System.out.println(calc.getPrevResult());
				System.out.println("Enter sign>>");                // Computing with previous result of computing
				sign = reader.readLine();
				System.out.println("Enter second number>>");
				second = Integer.parseInt(reader.readLine());
				calc.compute(calc.getPrevResult(), second, sign);
				System.out.println("Result = " + calc.getResult());
				calc.cleanResult();
			}
			else {
				System.out.println("Type yes for exit, type no for continue");    //Ask user for exit
				calc.cleanResult();
				response = reader.readLine();
			}
			
		}
		
	}

}