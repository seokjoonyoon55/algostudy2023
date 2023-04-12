import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coins = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 동전 종류 입력받기
			for(int i = 1; i <= N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			// 얼마 만들건지?
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M + 1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					// ex. 동전이 5원일 때 1~4원은 어차피 못만드니까 확인할 필요 X
					// 그래서 차이가 0보다 크거나 같을 때의 경우만 진행
					// X원을 만드는 개수 = 이전 동전으로 만든 개수 + (X-현재동전)의 개수를 추가
					if(j - coins[i] > 0) {
						dp[j] = dp[j] + dp[j - coins[i]];
					} else if(j - coins[i] == 0) {
						dp[j]++;
					}
				}
			}
			sb.append(dp[M] + "\n");
		}
		System.out.println(sb);
	}
}
