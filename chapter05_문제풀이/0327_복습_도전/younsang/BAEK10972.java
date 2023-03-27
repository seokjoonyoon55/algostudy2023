package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK10972 {
	static int[] check;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		check = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		nextPerm();
		System.out.println(sb.toString());
	}
	
	public static void nextPerm() {
		boolean flag1 = false;
		// 뒤에서부터 탐색할 때 값이 작아지는 index 변수
		int peak = 0;
		
		for (int i = N - 1; i >= 1; i--) {
			if (check[i] > check[i-1]) {
				peak = i;
				flag1 = true;
				break;
			}
		}
		
		// 위의 반복문 안의 조건문에 해당하는 경우가 없으면 순열 상 제일 마지막이므로 -1을 sb에 담고 바로 return
		if (!flag1) {
			sb.append(-1);
			return;
		}
		
		// peak - 1 index에 해당하는 값과 뒤부터 탐색했을 때 peak - 1보다 큰 값이 있으면 swap해주고 바로 break
		for (int i = N - 1; i > peak - 1; i--) {
			if (check[i] > check[peak - 1]) {
				int temp = check[i];
				check[i] = check[peak - 1];
				check[peak - 1] = temp;
				break;
			}
		}
		
		// peak 부터 N-1까지 오름차순으로 정렬 (선택 정렬 사용)
		for (int i = peak; i < N-1; i++) {
			int min = i;
			for (int l = i + 1; l < N; l++) {
				if(check[min] > check[l]) min = l;
			}
			int tempo = check[i];
			check[i] = check[min];
			check[min] = tempo;
		}
		
		// sb에 담아주기
		for (int x : check) {
			sb.append(x).append(" ");
		}
	}
}