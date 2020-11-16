package DemoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DuplicateArray {

	public static void main(String[] args) {
		
		int [] arr = {2,2,5,5,6,2};
		
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		
//		for(int i = 0 ; i < arr.length; i++)
//		{
//			
//			al.add(arr[i]);
//		}
//		
//		System.out.println(al);
//		
//		
//		HashSet<Integer> hs = new HashSet<Integer>(al);
//		
//		System.out.println(hs);
		
		Arrays.sort(arr);  //222556
				
		ArrayList<Integer> al = new ArrayList<Integer>();

		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i]==arr[i+1])
			{
				continue;
			}
			else
			{
				al.add(arr[i]);
			}
		}
		
		al.add(arr[arr.length-1]);
		
		System.out.println(al);

	}

}
