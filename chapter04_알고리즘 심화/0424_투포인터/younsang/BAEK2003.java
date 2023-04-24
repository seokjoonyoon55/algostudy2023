package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
	
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int endPoint = 0;
		int sum = 0;
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			// endPoint까지 더해준다.
			while(sum < M && endPoint <= N) {
				sum += arr[endPoint];
				endPoint++;
			}
			
			// sum이 M과 같아지면 count해준다.
			if (sum == M) cnt++;
			
			// start point를 빼준다.
			sum -= arr[i];
		}
		
		System.out.println(cnt);
	}
}
