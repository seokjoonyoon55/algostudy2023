package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK2583 {
	static int M,N,K;
	static int[][] arr;
	static int x1,y1,x2,y2;
	static int cnt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static LinkedList<int[]> q;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로
		M = Integer.parseInt(st.nextToken());
		// 세로
		N = Integer.parseInt(st.nextToken());
		// 직사각형 개수
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		
		list = new ArrayList<>();
		
		for (int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			// 직사각형 좌표 안이면 1로 초기화
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					arr[j][i] = 1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 0인 부분 bfs 돌리기
				if (arr[i][j] == 0) {
					bfs(new int[] {i, j});
				}
			}
		}
		// 영역의 개수 출력
		System.out.println(list.size());
		// 정렬
		Collections.sort(list);
		// 영역의 넓이 출력
		for (int i : list) {
			if (i > 1) System.out.printf("%d ", i-1);
			else System.out.printf("%d ", i);
		}
	}
	public static void bfs(int[] location) {
		q = new LinkedList<>();
		q.add(location);
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = ele[0] + dx[i];
				int y = ele[1] + dy[i];
				
				if (x < 0 || x >= M || y < 0 || y >= N) continue;
				// 0이면 cnt++ 해주고 q에 넣는다.
				if (arr[x][y] == 0) {
					cnt++;
					arr[x][y] = 1;
					q.add(new int[] {x,y});
				}
			}
		}
		list.add(cnt);
	}
	
}
