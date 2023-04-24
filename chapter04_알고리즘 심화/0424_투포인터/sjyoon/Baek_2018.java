import java.util.Scanner;

public class Baek_2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum,cnt;
		cnt = 0;
		
		// 연속된 자연수를 큰 수부터(N부터) 더하기 (?)
		// i가 시작점
		for (int i=N;i>0;i--) {
			// 합 초기화
			sum = 0;
			
			// 시작점인 i부터 시작해서 하나씩 작은 수를 합계에 더해줌
			for (int j=i;j>0;j--) {
				sum += j;
				
				// 합계가 N을 초과하면 시작점을 옯기기 위해 탈출
				if (sum > N) break;
				// 합계가 N이면 cnt를 더해주고 시작점 옮기기
				else if (sum == N) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
