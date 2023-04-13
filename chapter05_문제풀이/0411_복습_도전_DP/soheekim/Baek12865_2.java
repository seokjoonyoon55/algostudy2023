package study0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek12865_2 {
	static int[] W, V;// 무게, 가치 배열
	static int[][] maxV;// [idx][w]에서 최대 가치 저장 배열
	static int N, K;// 물건 갯수, 최대 무게

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// NK입력받기
		String[] tempS = bfr.readLine().split(" ");

		N = Integer.parseInt(tempS[0]);// 물건 갯수
		K = Integer.parseInt(tempS[1]);// 최대 무게

		W = new int[N + 1];// 무게 배열
		V = new int[N + 1];// 가치 배열
		maxV = new int[N + 1][K + 1];// [물건 갯수][무게]별 최대 가치 배열. [][0], [0][] 사용 안함

		for (int i = 1; i <= N; i++) {
			tempS = bfr.readLine().split(" ");
			W[i] = Integer.parseInt(tempS[0]);
			V[i] = Integer.parseInt(tempS[1]);
		}

		// N,K 계산
		System.out.println(knapsack(N, K));
		// print(maxV);
	}

	// 배낭 알고리즘 구현
	private static int knapsack(int idx, int curw) {
		// 무게 0되면 0리턴
		if (curw == 0)
			return 0;
		// 인덱스0되면 고를 물건 없으므로 0 리턴
		if (idx == 0)
			return 0;

		// 최대 가치 배열에 이미 저장되어있으면 꺼내서 반환
		if (maxV[idx][curw] != 0)
			return maxV[idx][curw];

		// 가능한 무게보다 남은 무게가 더 크면 제외하고 계산
		if (curw < W[idx])
			maxV[idx][curw] = knapsack(idx - 1, curw);

		// 남은 무게가 충분하면 포함했을때와 포함하지 않았을 때 가치 비교해서 큰 거 저장
		else
			maxV[idx][curw] = Math.max(knapsack(idx - 1, curw - W[idx]) + V[idx], knapsack(idx - 1, curw));

		return maxV[idx][curw];
	}

	// 테스트용 출력 메서드
	private static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}