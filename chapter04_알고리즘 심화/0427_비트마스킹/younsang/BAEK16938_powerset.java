package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK16938_powerset {
	static int N, L, R, X;
	static int result = 0;
	static int[] diff;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 문제의 개수
		N = Integer.parseInt(st.nextToken());
		diff = new int[N];
		visit = new boolean[N];
		// 문제의 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
		// L <= 난이도의 합 <= R
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		// 가장 어려운 문제의 난이도 - 가장 쉬운 문제의 난이도 >= X
		X= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken());
		}
		
		powerset(0);
		System.out.println(result);
	}
	
	public static void powerset(int idx) {
		// base case
		if (idx == N) {
			// 사용한 문제의 개수 담을 변수
			int cnt = 0;
			// 난이도의 합
			int sum = 0;
			// 제일 낮은 난이도
			int min = Integer.MAX_VALUE;
			// 제일 높은 난이도
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					cnt++;
					sum += diff[i];
					min = Math.min(min, diff[i]);
					max = Math.max(max, diff[i]);
				}
			}
			// 사용한 문제의 개수가 2개 미만이면 pass
			if (cnt < 2) return;
			// 조건에 부합한다면 count
			if (sum <= R && sum >= L && max - min >= X) result++;
			return;
		}
		// recur case
		// 해당 난이도의 문제 사용
		visit[idx] = true;
		powerset(idx + 1);
		
		// 해당 난이도의 문제 미사용
		visit[idx] = false;
		powerset(idx + 1);
	}
}
