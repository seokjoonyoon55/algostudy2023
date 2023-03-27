import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num, sel;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		sel = new int[M];
		sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			num[i] = i;
		}
		combination(1, 0);
		System.out.println(sb.toString());
	}
	
	private static void combination(int idx, int sidx) {
		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			sel[sidx] = num[i];
			combination(idx + 1, sidx + 1);
		}
	}
}