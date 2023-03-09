package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon15650 {

	// 1부터 자연수 N
	static int N;
	// M개를 고른 수열
	static int M;
	// 1부터 N까지 자연수의 배열
	static int[] num;
	// 그 배열 중에 사용한 숫자 사용 여부 체크 배열
	static boolean[] isUsed;
	// M개를 고른 수열 중 조건을 만족하는 수열
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
		bt(0);
	}

	static void bt(int depth) throws IOException {
		if (depth == M) {
			int cnt = 0;
			for (int i = 0; i < ans.length; i++) {
				if (i > 0 && ans[i - 1] < ans[i]) {
					cnt++;
				}
			}
			// cnt가 두 수중 오름차순인 수들의 개수고 그 수가 length(M)보다 1이 작으면 모두가 오름차순인거니까 아래 if문으로 진입하는건데
			// 지금 보니 이렇게 하지 말고 애초에 아래 백트레킹 돌릴때 오른차순을 만족하지 않으면 백트레킹에 진입하지 못하게 했어야 더 효율적이었을듯
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
