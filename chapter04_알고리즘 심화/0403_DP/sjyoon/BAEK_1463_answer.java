import java.util.Scanner;

public class BAEK_1463_answer {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		arr[0] = 1;
		
		for (int i=1;i<N;i++) {
			arr[i] = arr[i-1] +1;
			if (i%2==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1); 
			}
			if (i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
		}
		
		System.out.println(arr[N-1]);
		
		sc.close();
	}
	
	/*
	static cal(int n) {
		if (n==1) return 1;
		
		
		if (N%3==0) {
			N = N/3;
		}
		else if (N%2==0) {
			N = N/2;
		}
		else N = N-1;
	}
	*/
}
