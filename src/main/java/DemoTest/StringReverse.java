package DemoTest;

import java.util.Arrays;

public class StringReverse {

	public static void main(String[] args) {
		
		String s = "Hi Today is my interview";
		
		//output : interview my is today hi
		
		reverse(s);
	}
	
	
	public static void reverse(String a)
	{
		
		String[] s1 = a.split(" ");
		
		for(int i = 0 ; i < s1.length/2; i++)
		{
			String temp = s1[i];
			s1[i] = s1[s1.length-i-1];
			s1[s1.length-i-1] = temp;
		}
		
		for(String x : s1 )
		{
			System.out.print(x+" " );
		}
		
		//System.out.print(Arrays.toString(s1));
		
		
	}

}
