package algorithm;
import java.util.Scanner;
public class BaekJoon1065_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1000) { // 1000은 등차수열x, 세자리수 맞추기 위해 -1
			N = 999;
		}
		
		int cnt = 0; // 한수 개수
		
		for(int i = 1; i <= N; i++) {
			if(i < 100) {// 1부터 100까지 등차수열 해당
				cnt++;
			}
			else {
				int first = i % 10; // 1의 자리
				int second = i / 10 % 10; // 10의 자리
				int third = i / 100; // 100의 자리
				if(third - second == second - first)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
