package algo;

import java.util.Scanner;
import java.util.Stack;

public class BAEK1874 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// [8,7,6,5,4,3,2,1]
		Stack<Integer> nums = new Stack<>();
		for (int i=n;i>0;i--) {
			nums.push(i);
		}
		
		Stack<Integer> stk = new Stack<>();
		
		
		for (int i=0;i<n;i++) {
			int num = sc.nextInt();
			System.out.println(num);
			
			if (num>=nums.peek()) {
				while (num>=nums.peek()) {
					stk.push(nums.pop());
					System.out.println("+");
				}
				stk.pop();
				System.out.println("-");
			}
			
			
			else if (num<nums.peek()) {
					stk.pop();
					System.out.println("-");	
			}
			
			// [8 7 6 5 4 3 2 1]
			// [               ]
			
			// [8 7 6 5      ]
			// [1 2 3 4         ]
			
			
			
		}
		
	}
}
