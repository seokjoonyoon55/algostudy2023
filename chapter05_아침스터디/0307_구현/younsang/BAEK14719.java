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
		// 양 끝은 어차피 물 안고임
		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			
			// 첫 칸 부터 해당 칸보다 바로 왼쪽 칸 사이에서 가장 큰 값
			for (int j = 0; j < i; j++) {
				left = Math.max(arr[j], left);
			}
			
			// 해당 칸보다 바로 오른쪽 칸부터 끝 칸 사이에서 가장 큰 값
			for (int j = i + 1; j < W; j++) {
				right = Math.max(arr[j], right);
			}
			
			// 두 left, right 변수보다 크기가 작으면 물이 코이므로 빼준 값 만큼 cnt에 더해준다.
			if (arr[i] < left && arr[i] < right) cnt += Math.min(left, right) - arr[i];
		}
		System.out.println(cnt);
		
	}
}
