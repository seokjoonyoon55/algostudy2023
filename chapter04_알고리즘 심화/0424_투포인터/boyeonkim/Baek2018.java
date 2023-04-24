import java.util.Scanner;

public class Baek2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N + 1];
		
		// 배열 칸마다 숫자 저장
		for(int i = 1; i <= N; i++) {
			num[i] = i;
		}
		
		int start = 0, end = 0;
		int cnt = 1, sum = 0;
		
		// 더한 값이 N이 되면 가능 횟수 증가, end 포인터 증가
		// 더한 값이 N보다 작으면 end 포인터 증가
		// 더한 값이 N보다 크면 start 포인터 증가 및 더했던 숫자 다시 빼주기
		while(end <= N - 1) {
			if(sum == N) {
				++cnt;
				++end;
				sum += num[end];
			} else if(sum < N) {
				++end;
				sum += num[end];
			} else if(sum > N) {
				sum -= num[start];
				++start;
			}
		}
		System.out.println(cnt);
	}
}
