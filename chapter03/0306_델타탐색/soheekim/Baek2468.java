package study0306;

import java.util.Scanner;

public class Baek2468 {
	// 현재 탐색 상황에서 방문 되지 않은 상태로 판단할 변수
	static boolean notVisited = false;

	// 상하좌우. 델타탐색용 변수
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());// 2차원 배열 한변 길이

		int[][] land = new int[N][N];// 땅 높이
		boolean[][] visited = new boolean[N][N];// 방문 여부
		int cntSpace = 0;// 공간 갯수

		String[] tempS;// 땅높이 입력받을 때 쓰는 임시변수
		int maxHeight = 0;// 최대 땅높이
		int maxSpace = 0;// 공간 갯수 최대

		// 땅 높이 입력받기
		for (int i = 0; i < N; i++) {
			tempS = sc.nextLine().split(" ");
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(tempS[j]);
				// 입력받으면서 최대 높이 갱신
				if (maxHeight < land[i][j])
					maxHeight = land[i][j];
			}
		}

		// 비의 높이에 따라 반복
		// 물 높이 = 최대높이-1 까지만 반복. 최대높이이면 모든 땅이 잠기므로.
		for (int water = 0; water < maxHeight; water++) {
			// 공간 갯수 초기화
			cntSpace = 0;
			
			//모든 땅 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//현재 땅이 물보다 높고 방문되지 않았으면
					if (land[i][j] > water && visited[i][j] == notVisited) {
						//공간갯수++ 후 dfs돌려서 인접 방문처리
						cntSpace++;
						dfs(land, visited, i, j, N, water);
					}
				}
			}
			//최대 공간갯수 갱신
			if (maxSpace < cntSpace)
				maxSpace = cntSpace;
			//방문 되지 않은 상태를 반대로 변경
			notVisited = !notVisited;
		}

		//출력
		System.out.println(maxSpace);
		sc.close();
	}

	//방문 표시용 dfs
	//낮은 높이의 칸은 높이로 인해 탐색되지 않으므로 visited값 고려하지 않음
	public static void dfs(int[][] land, boolean[][] visited, int i, int j, int N, int water) {
		//방문되지 않았으면 방문 표시
		if (visited[i][j] == notVisited) {
			visited[i][j] = !visited[i][j];
		}

		//4방 델타탐색
		for (int d = 0; d < 4; d++) {
			// 경계조건
			if (i + dx[d] < 0 || i + dx[d] >= N || j + dy[d] < 0 || j + dy[d] >= N)
				continue;
			
			//탐색좌표의 땅이 물보다 높고, 방문된 적 없을 때
			if (land[i + dx[d]][j + dy[d]] > water && visited[i + dx[d]][j + dy[d]] == notVisited) {
				{
					//방문처리 후 dfs로 인접 탐색
					visited[i + dx[d]][j + dy[d]] = !visited[i + dx[d]][j + dy[d]];
					dfs(land, visited, i + dx[d], j + dy[d], N, water);
				}
			}
		}
	}
}
