package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK7562 {
	static LinkedList<int[]> q;
	// 8방향 이동
	static int I;
	static int[][] arr;
	static int[] knight;
	static int[] dest;
	static int[] moveX = {-1,-2,-2,-1,1,2,2,1};
	static int[] moveY = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			st = new StringTokenizer(br.readLine());
			
			// 나이트 위치 담을 배열 선언
			knight = new int[2];
			
			// 목적지 위치 담을 배열 선언
			dest = new int[2];
			
			// 나이트 위치
			knight[0] = Integer.parseInt(st.nextToken());
			knight[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			// 목적지 위치
			dest[0] = Integer.parseInt(st.nextToken());
			dest[1] = Integer.parseInt(st.nextToken());
			
			// 안움직여도 될 때
			if (knight[0] == dest[0] && knight[1] == dest[1]) System.out.println(0);
			else bfs(knight);
		}
	}
	
	public static void bfs(int[] knight) {
		q = new LinkedList<>();
		// 초기값 설정
		arr[knight[0]][knight[1]] = 1;
		
		// 큐에 삽입
		q.add(knight);
		while(!q.isEmpty()) {
			int[] ele = q.poll();
			// 8방향 탐색
			for (int i = 0; i < 8; i++) {
				int x = ele[0] + moveX[i];
				int y = ele[1] + moveY[i];
				
				// 배열 범위 벗어나면 continue
				if (x < 0 || x >= I || y < 0 || y >= I) continue;
				// 목적지에 도달하면 출력
				if (x == dest[0] && y == dest[1]) {
					System.out.println(arr[ele[0]][ele[1]]);
					return;
				}
				// 초기값 + 1 된 값으로 초기화 후
				// 큐에 삽입
				if (arr[x][y] == 0) {
					arr[x][y] = arr[ele[0]][ele[1]] + 1;
					q.add(new int[] {x,y});
				}
			}
		} 
	}
}
