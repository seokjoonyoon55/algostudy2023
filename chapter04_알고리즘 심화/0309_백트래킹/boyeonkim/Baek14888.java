package barkingdog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
	static int MAX = Integer.MAX_VALUE;
	static int MIN = Integer.MIN_VALUE;
	static int[] operator = new int[4];
	static int[] nums;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		// 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		
		}
		
		bt(nums[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void bt(int num, int idx) {
		if(idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if(operator[i] > 0) {
				// 해당연산자를 1 감소시킨다
				operator[i]--;
				
				switch(i) {
					case 0 :
						bt(num + nums[idx], idx + 1);
						break;
						
					case 1 :
						bt(num - nums[idx], idx + 1);
						break;
						
					case 2 :
						bt(num * nums[idx], idx + 1);
						break;
						
					case 3 :
						bt(num / nums[idx], idx + 1);
						break;
				}
				// 재귀 호출이 종료되면 다시 연산자 개수 복구
				operator[i]++;
			}
		}
	}
}
