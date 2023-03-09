package study0309;

import java.util.Scanner;

public class Baek14888 {
	static int min = Integer.MAX_VALUE;//최소값
	static int max = Integer.MIN_VALUE;//최대값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//숫자 갯수
		sc.nextLine();//개행문자 버림
		
		//숫자, 연산자 String으로 입력받기
		String[] numsS = sc.nextLine().split(" ");
		String[] operatorS = sc.nextLine().split(" ");
		
		//숫자, 연산자 int로 저장할 배열
		int[] nums = new int[N];
		int[] operator = new int[4];//연산자 + - * /

		//숫자 int로 변환
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(numsS[i]);
		}

		//연산자 갯수 int로 변환
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(operatorS[i]);
		}

		//숫자 계산. 백트래킹
		calc(nums, operator, N, 0, 0);

		//출력
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}

	//식 계산하는 메서드
	public static void calc(int[] nums, int[] operator, int N, int res, int depth) {
		//메서드 시작 시의 연산결과 저장
		int resOrigin = res;

		//식 완성하면 최대 최소 갱신 후 메서드 종료
		if (depth == N) {
			if (min > res)
				min = res;
			if (max < res)
				max = res;
			return;
		}

		//0숫 |1연 숫 |2연 숫|3 연 숫  으로 구분
		if (depth == 0) {
				//연산자가 없으므로 바로 숫자 저장
				res = nums[depth];
				//백트래킹 재귀
				calc(nums, operator, N, res, depth + 1);
				//결과 되돌림
				res = resOrigin;
		}
		// depth>0일 때 
		else {
			//연산자 4개에 대해 백트래킹
			for (int j = 0; j < 4; j++) {
				//사용할 연산자가 남았으면
				if ((operator[j]) != 0) {
					//연산자 사용
					operator[j]--;

					//연산자에 따른 계산 진행
					switch (j) {
					case 0:
						res += nums[depth];
						break;
					case 1:
						res -= nums[depth];
						break;
					case 2:
						res *= nums[depth];
						break;
					case 3:
						res /= nums[depth];
						break;
					default:
						break;
					}

					//다음 단계 백트래킹 재귀
					calc(nums, operator, N, res, depth + 1);

					//연산 결과 되돌림
					res = resOrigin;
					
					//연산자 사용 되돌림
					operator[j]++;
				}
			}

		}

	}
}
