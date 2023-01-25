package study0126;

import java.util.Scanner;

//시간초과뜸
public class Baek4948TimeOver {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int stopif0 = 1;// while문 빠져나오기 위한 상태변수
		int N = 0;// 입력받을 변수
		int pcnt = 0;// 2N까지 소수 카운트
		int pcntN = 0;// N까지 소수 카운트
		int inif1 = 1;// 1이면 소수로 판단하고 소수배열에 넣음

		while (stopif0 == 1) {
			N = sc.nextInt();
			pcnt = 0;// 소수카운트 초기화
			pcntN = 0;// 소수카운트 초기화

			int[] primeArr = new int[N];//소수 저장 배열
			
			if (N == 0)
				stopif0 = 0;//0입력되면 while문 탈출
			else if (N >= 1) {//N이 2이상이면
				//첫 소수 2 초기화
				primeArr[0] = 2;
				pcnt = 1;
				
				//소수 판별 반복문 돌리기
				for (int i = 3; i <= 2 * N; i += 2) {
					inif1 = 1;//소수라고 가정하고
					for (int j = 0; j < pcnt; j++) {
						if (i % primeArr[j] == 0) {//다른 소수로 1번이라도 나눠지면
							inif1 = 0;
							break;//소수 아니라고 표시하고 반복문 탈출
						}
					}
					if (inif1 == 1)
						primeArr[pcnt++] = i;//소수라면 소수 배열에 넣고 소수카운트++
					if (i == N || i == N - 1)
						pcntN = pcnt;//판별 계속하다가 N지점에 왔을 때 소수카운트 저장
				}
			}
			System.out.println(pcnt - pcntN);//출력
		}
		sc.close();
	}
}
