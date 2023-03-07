package study0126;

import java.util.Scanner;

public class Baek4948new {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = 0;//입력받아서 저장할 변수
		int stopif0 = 1;//0되면 while문 탈출용 변수
		int primecnt = 0;//소수 카운트

		while (stopif0 == 1) {
			N = sc.nextInt();
			
			//입력이 0이면 탈출
			if (N == 0)
				stopif0 = 0;
			//입력이 0이 아니면 판정 진행
			else {
				int[] numArr = new int[2 * N];//입력받은 수의 2배만큼 배열 만듦. 소수가 아니면 1로 표기
				numArr[0] = 1;//1은 소수가 아니므로 1표기
				primecnt = 0;//소수 갯수 리셋
				
				//2부터 루트(2N)까지 탐색
				for (int i = 2; i < Math.sqrt(2 * N) + 1; i++) {
					if (numArr[i - 1] != 1) {//탐색할 수가 소거되지 않았을 때
						if (isPrime(i)) {//탐색할 수가 소수면
							for (int j = 2 * i; j <= 2 * N; j += i)//2i부터 i간격으로 1로 바꾸면서 소거
								numArr[j - 1] = 1;
						} else
							numArr[i - 1] = 1;//탐색할 수가 소수가 아니면 1로 바꾸고 소거
					}
				}
				
				//[0]에 1을 저장했으므로 N<=i<2N이면 수의 범위는 N-1부터 2N까지
				for (int i = N; i < 2 * N; i++) {
					if (numArr[i] == 0)
						primecnt++;
				}//소수 카운트하기
				
				System.out.println(primecnt);//출력
			}
		}
		sc.close();
	}

	//소수 판별 클래스
	public static boolean isPrime(int num) {
		if (num == 1)
			return false;
		else {
			for (int i = 2; i < num; i++)//2부터 숫자 사이에 나눠지는 수가 1개라도 있으면 false
				if (num % i == 0)
					return false;
		}
		return true;
	}
}
