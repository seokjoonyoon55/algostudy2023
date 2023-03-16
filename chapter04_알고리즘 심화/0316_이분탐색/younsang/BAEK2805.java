package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int[] arr = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// end 값 초기화
			if (max < arr[i]) max = arr[i];
		}
		// 이분 탐색 시작
		int start = 0; int end = max;
		while (start < end) {
			long trees = 0;
			int mid = (start + end) / 2;
			
			// 요소에서 mid 뺀만큼 trees에 더해준다
			for (int i : arr) {
				if (i > mid) trees += (i - mid);
			}
			
			// M보다 작을 경우 i - mid를 더 크게만들어야 하므로
			// end값을 작게해줌으로써
			// mid값이 감소된다.
			if (trees < M) end = mid;
			else start = mid + 1;
		}
		System.out.println(end-1);
	}
}
