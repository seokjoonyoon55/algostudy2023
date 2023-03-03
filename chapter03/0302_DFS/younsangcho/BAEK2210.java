package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK2210 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static String[][] arr = new String[5][5];
	static int[][] visit = new int[5][5];
	static List<String> list = new ArrayList<>();
	static int cnt;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				
				arr[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 각각의 원소에서 dfs 메소드
				dfs(i, j, 0, arr[i][j]);
			}
		}
		System.out.println(list.size());
	}
	
	public static void dfs(int x, int y, int cnt, String tmp) {
		// 5번 이동했으면
		if(cnt == 5) {
			// 리스트에 존재하지 않으면 추가해주기
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
			// 종료
			return;
		}
		// 4방향 탐색
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			// 범위 안이면
			if((0 <= nx & nx < 5)&&(0 <= ny && ny < 5)) {
				// 카운트 + 1, 문자열 더해주기
				dfs(nx, ny, cnt+1, tmp+arr[nx][ny]);
			}
		}
	}
}