package study0306;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek2583 {
	// 상하좌우 델타탐색용 변수
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();// 행 j y
		int N = sc.nextInt();// 열 i x
		int K = sc.nextInt();// 종이 갯수

		boolean[][] board = new boolean[M][N];// 모눈종이 상태 저장
		int x1 = -1;// 왼쪽아래 x좌표
		int y1 = -1;// 왼쪽아래 y좌표
		int x2 = -1;// 오른쪽위 x좌표
		int y2 = -1;// 오른쪽위 y좌표

		// 공간너비 저장
		ArrayList<Integer> space = new ArrayList<>();
		int cntSpace = 0;// 공간 갯수 카운트
		int area = -1;// 공간너비 계산용 임시변수

		int temp = -1;

		// 종이 덮인 곳 입력받기
		for (int sq = 0; sq < K; sq++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();

			// 해당 칸 true 표시
			for (int j = y1; j < y2; j++) {
				for (int i = x1; i < x2; i++) {
					board[j][i] = true;
				}
			}

		}

		// 모든 칸에 대해 dfs탐색
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				// 방문되지 않았으면
				if (!board[j][i]) {
					cntSpace++;// 공간 갯수++
					area = dfs(board, j, i, M, N);// dfs 탐색돌면서 현재 너비 계산
					space.add(area);// 구한 너비 저장
				}
			}
		}

		// 너비들 정렬. 버블정렬 사용함.
		for (int i = 0; i < space.size(); i++) {
			for (int j = 0; j < space.size() - i - 1; j++) {
				if (space.get(j) > space.get(j + 1)) {
					temp = space.get(j + 1);
					space.set(j + 1, space.get(j));
					space.set(j, temp);
				}
			}
		}

		// 출력
		sb.append(cntSpace).append("\n");
		for (int i = 0; i < space.size(); i++) {
			sb.append(space.get(i)).append(" ");
		}
		sb.append("\n");

		System.out.println(sb);
		sc.close();
	}

	// dfs돌기. 칸에 표시하면 area++. 반환은 현재까지 dfs로 탐색한 칸 갯수
	public static int dfs(boolean[][] board, int y, int x, int M, int N) {
		int area = 0;// 탐색한 칸 수

		// 방문한 적 없으면 표시하고 area++
		if (!board[y][x]) {
			board[y][x] = true;
			area++;
		}

		// 4방 델타탐색
		for (int i = 0; i < 4; i++) {
			// 경계조건
			if (y + dy[i] < 0 || y + dy[i] >= M || x + dx[i] < 0 || x + dx[i] >= N) {
				continue;
			}

			// 다음칸이 방문되지 않았으면
			if (!board[y + dy[i]][x + dx[i]]) {
				// 방문 표시 후 area++
				board[y + dy[i]][x + dx[i]] = true;
				area++;

				// 방문하지 않은 칸 dfs돌은 후 탐색한 칸수 합하기
				area += dfs(board, y + dy[i], x + dx[i], M, N);
			}
		}
		// 탐색한 칸수 반환
		return area;
	}
}
