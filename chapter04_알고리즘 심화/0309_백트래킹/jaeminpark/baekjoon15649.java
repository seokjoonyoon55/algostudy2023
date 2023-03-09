package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon15649 {

	// 1부터 N까지 자연수
	static int N;
	// M개의 수를 뽑아서 배열 만들어야 됨
	static int M;
	// 1부터 N까지 자연수로 만든 배열
	static int[] num;
	// 그 배열 중 사용한 자연수를 표시할 배열
	static boolean[] isUsed;
	// 조건을 만족하는 수열
	static int[] ans;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		isUsed = new boolean[N];
		ans = new int[M];
		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		// 일반적인 백트레킹
		bt(0);
	}

	static void bt(int depth) throws IOException {
		if (depth == M) {
			for (int i = 0; i < ans.length; i++) {
				bw.write(Integer.toString(ans[i]));
				bw.write(" ");
				bw.flush();
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				ans[depth] = num[i];
				bt(depth + 1);
				isUsed[i] = false;
			}
		}
	}
}
