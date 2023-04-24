package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK2470 {
	static int N;
	static int[] sol;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		sol = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) sol[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sol);
		
		int[] result = new int[2];
		
		int start = 0;
		int end = N - 1;
		int min = INF;
		
		while(start < end) {
			// 제일 작은 값과 제일 큰 값을 더해준다. (제일 처음)
			int sum = sol[start] + sol[end];
			
			// 두 합의 절댓값보다 min 값이 클 경우
			if (min > Math.abs(sum)) {
				// 갱신
				min = Math.abs(sum);
				// 결과 저장
				result[0] = sol[start];
				result[1] = sol[end];
				
				// 0일 경우 이보다 작은 경우는 없으므로  while문 종료
				if (sum == 0) break;
			}
			
			// 음수가 양수보다 더 크므로 start를 뒤로 민다.
			if (sum < 0) start++; 
			// 양수가 음수보다 더 크므로 end를 앞으로 당긴다.
			else end--;
		}
		System.out.println(result[0] + " " + result[1]);
	}
}