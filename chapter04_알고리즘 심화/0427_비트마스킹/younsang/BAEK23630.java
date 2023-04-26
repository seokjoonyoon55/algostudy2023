package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK23630 {
	static int N, ans;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MIN_VALUE;
		
		bitmasking();
		
		System.out.println(ans);
	}
	
	public static void bitmasking() {
		for (int i = 1; i < (1 << N); i++) {
			int num = 0;
			int bit = 0;
			int len = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					if (num == 0) {
						num = arr[j];
						bit = arr[j];
					} else {
						if (num > arr[j]) break;
						else num = arr[j];
						
						if ((bit & arr[j]) == 0) break;
						else bit = (bit & arr[j]);
					}
					len++;
				}
			}
			ans = Math.max(len, ans);
		}
	}
}
