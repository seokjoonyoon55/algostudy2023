package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] HW = br.readLine().split(" ");
		int H = Integer.parseInt(HW[0]);
		int W = Integer.parseInt(HW[1]);
		
		int[] arr = new int[W];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			
			for (int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}
			
			for (int j = i + 1; j < W; j++) {
				right = Math.max(arr[j], right);
			}
			
			if (arr[i] < left && arr[i] < right) cnt += Math.min(left, right) - arr[i];
		}
		System.out.println(cnt);
		
	}
}
