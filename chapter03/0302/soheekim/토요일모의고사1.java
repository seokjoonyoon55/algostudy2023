import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 갯수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 신입사원 수
			int k_min = sc.nextInt();// 인원 최소조건
			int k_max = sc.nextInt();// 인원 최대조건
			int[] kCnt = new int[100];// 카운트배열
			int[] sumC = new int[N];// T1점수가 인덱스 일 때 C반 인원 합
			int[] sumA = new int[N];// T2점수가 인덱스 일 때 A반 인원 합

			int sumB = 0;// B반 인원합

			int minimum = Integer.MAX_VALUE;// 반 인원차 최소값
			int tempMin = -1;// 3반 인원 중 최소값
			int tempMax = -1;// 3반 인원 중 최대값

			// 카운트 배열 입력받기
			for (int i = 0; i < N; i++) 
				kCnt[sc.nextInt() - 1]++;

			// sumC계산
			sumC[0] = kCnt[0];
			for (int i = 1; i < N; i++) 
				sumC[i] = sumC[i - 1] + kCnt[i];
			
			// sumA계산
			sumA[N - 1] = kCnt[N - 1];
			for (int j = N - 2; j >= 0; j--) 
				sumA[j] = sumA[j + 1] + kCnt[j];
			
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					// sumB계산
					sumB = N - sumC[i] - sumA[j];

					// 최소인원 조건 거르기
					if (sumC[i] < k_min || sumB < k_min || sumA[j] < k_min)
						continue;
					// 최대인원 조건 거르기
					if (sumC[i] > k_max || sumB > k_max || sumA[j] > k_max)
						continue;

					// 인원 최소 계산
					if (sumC[i] < sumB)
						tempMin = sumC[i];
					else
						tempMin = sumB;

					if (tempMin > sumA[j])
						tempMin = sumA[j];

					// 인원 최대 계산
					if (sumC[i] < sumB)
						tempMax = sumB;
					else
						tempMax = sumC[i];

					if (tempMax < sumA[j])
						tempMax = sumA[j];

					// 차이 최소값 갱신
					if (minimum > tempMax - tempMin)
						minimum = tempMax - tempMin;
				}
			}
			// 조건 만족하는 경우가 없으면 -1 출력
			if (minimum == Integer.MAX_VALUE)
				minimum = -1;

			// 출력
			System.out.printf("#%d %d\n", tc, minimum);
		}
		sc.close();
	}
}