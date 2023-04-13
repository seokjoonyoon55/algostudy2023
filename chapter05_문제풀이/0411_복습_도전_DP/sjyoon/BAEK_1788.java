import java.util.Arrays;
import java.util.Scanner;

public class BAEK_1788 {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();		
		arr = new int[Math.abs(n) + 1];
		Arrays.fill(arr, -2);
		
		
		if (n == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}
		
		arr[0] = 0;
		arr[1] = 1;
		
		
		for (int i=2;i<arr.length;i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000000;
		}
		
		
		if (n > 0) {
			System.out.println(1);
			System.out.println(arr[n]);
		}
		else if (n < 0) {
			if (n % (-2) == 0) {
				System.out.println(-1);
				System.out.println(Math.abs(arr[Math.abs(n)]));
			}else {
				System.out.println(1);
				System.out.println(arr[Math.abs(n)]);
			}
		}
		
		
		sc.close();
	}
}
