import java.lang.Math;

public class Calculate
{
	public static void main(String[] args)
	{
		int result = 0;
		int first = Integer.valueOf(args[0]);
		int second = Integer.valueOf(args[1]);
		char sign = args[2].toCharArray()[0];
		System.out.println(sign);
		char flag = args[3].toCharArray()[0];
		System.out.println(flag);
		
		switch(sign)
		{
			case '+':
				result = first + second;
				break;
			case '-':
				result = first - second;
				break;
			case 'x':
				result = first * second;
				break;
			case '/':
				result = first / second;
				break;
			case '^':
				result = (int)Math.pow((double)first,(double)second);
				break;
		}
		
		if (flag == 'i') 
		System.out.println("Result = " + result);
		else if (flag == 'd')
		{
			double dblResult = (double)result;
			System.out.println("Result = " + dblResult);
		}
		else if (flag == 'f')
		{
			float FlResult = (float)result;
			System.out.println("Result = " + FlResult);
		}
	}
	
}