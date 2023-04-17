import java.util.Scanner;

public class BAEK_26099 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		
		// 봉지는 3키로, 5키로 두 종류
		// 5키로 봉지의 개수는 최대값인 N/5 부터 하나씩 차감하며 계산해 나갈 것
		
		long val = 0;	// 봉지 총 개수(출력값) 
		long fiveCnt = N / 5;	// 5키로 봉지 수
		long remain = N % 5;	// 5키로 봉지로 담고 나머지
		
		if (remain == 0) {
			val = fiveCnt;
		}
		else {
			while (remain%3 != 0) {
				remain += 5;
				fiveCnt -= 1;
				
				if (fiveCnt < 0) {
					val = -1;
					break;
				}
			}
			
			if(val != -1) {
				val = fiveCnt + remain/3;
			}	
		}
		
		
		sc.close();
		System.out.println(val);
		
	}
}
