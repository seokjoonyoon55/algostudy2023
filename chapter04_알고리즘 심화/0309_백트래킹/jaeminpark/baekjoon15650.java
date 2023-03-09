package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15650 {

	static int[] num;
	static boolean[] isUsed;
	static int[] ans;
	static int N;
	static int M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cnt = 0;

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
		bt(0);
	}

	static void bt(int depth) throws IOException {
		if (depth == M) {
			int cnt = 0;
			for (int i = 0; i < ans.length; i++) {
				if (i > 0 && ans[i - 1] < ans[i]) {
					cnt++;
				}
//				System.out.println("cnt: " + cnt);
			}
			if (cnt == M - 1) {
				for (int i = 0; i < ans.length; i++) {
					bw.write(Integer.toString(ans[i]));
					bw.write(" ");
					bw.flush();
				}
				System.out.println();
			}
			return;
		}
//		System.out.println(depth);
		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				ans[depth] = num[i];
				bt(depth + 1);
				isUsed[i] = false;
			}
		}
//		System.out.println(Arrays.toString(ans));
//		System.out.println("------------------------");
	}
}
