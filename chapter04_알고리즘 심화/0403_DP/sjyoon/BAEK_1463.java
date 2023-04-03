import java.util.Scanner;

public class BAEK_1463 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int cnt = 0;
		
		while (N!=1) {
			cal();
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
	
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
}
