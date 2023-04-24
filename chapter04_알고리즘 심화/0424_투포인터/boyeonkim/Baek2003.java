package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2003 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		int sum = 0, cnt = 0;
		
		while(true) {
			// 더한 값이 M과 같거나 커진다면 숫자 빼주기
			if(sum >= M) sum -= num[start++];
			// end 포인터가 배열의 끝에 가면 break
			else if(end == N) break;
			// 더한 값이 M보다 작으면 end 포인터 늘려주면서 sum 변수에 더해주기
			else sum += num[end++];
			
			// 입력받은 M과 더한 값이 일치하면 경우의 수 증가시키기
			if(sum == M) cnt++;
		}
		
		System.out.println(cnt);
	}
}
