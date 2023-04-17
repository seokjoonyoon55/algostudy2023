import java.util.Scanner;

public class BAEK_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 봉지는 3키로, 5키로 두 종류
		// 5키로 봉지의 개수는 최대값인 N/5 부터 하나씩 차감하며 계산해 나갈 것
		
		int val = 0;	// 봉지 총 개수(출력값) 
		int fiveCnt = N / 5;	// 5키로 봉지 수
		
		// 반복 연산 시작
		while (true) {
			// 임시 변수에 N 담아주고
			int temp = N;
			// 5키로 봉지 개수 세어주고
			val = fiveCnt;
			
			// 만약 5키로로 아예 나누어 떨어지면 반복문 탈출
			if (temp % 5 == 0) break;
			
			// 아니라면, temp를 5키로 봉지로 담고 남은 무게로 만들어주기
			temp -= fiveCnt * 5;
			
			// 남은 무게에서 3키로 봉지로 담을 수 있는 개수 val에 더하기
			val += temp/3;
			
			// 만약 남은 무게가 3키로로 나누어 떨어지는거면 반복문 탈출
			if (temp % 3 == 0) break;
			
			// 아니라면 , 5키로 봉지 수 하나 차감
			fiveCnt -= 1;
			
			// 이떄, 5키로 봉지 수가 -1이 되어버리면 깔끔히 담을 수 없는 것이므로
			// 출력값 -1로 하고 반복문 탈출
			if (fiveCnt < 0) {
				val = -1;
				break;
			}
			
		}
		
		sc.close();
		System.out.println(val);
		
	}
}
