import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] res;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = new int[M];		
		visited = new boolean[N];

		perm(0, 0);
		System.out.println(sb);
	}
	private static void perm(int idx, int s) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = s; i < N; i++) {
			visited[i] = true;
			res[idx] = i + 1;
			perm(idx + 1, i);
			visited[i] = false;
		}
	}
}
