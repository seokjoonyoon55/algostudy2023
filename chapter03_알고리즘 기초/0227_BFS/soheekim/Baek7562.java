package study0227;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek7562 {
	//8방 델타탐색용 배열
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 갯수
		int N = -1;// 보드 길이

		int Xcur = -1;// 나이트 현재 행
		int Ycur = -1;// 나이트 현재 열

		int Xtarget = -1;// 목적지 행
		int Ytarget = -1;// 목적지 열

		for (int tc = 1; tc <= T; tc++) {
			// 값 입력받기
			N = sc.nextInt();
			Xcur = sc.nextInt();// 나이트 현재 행
			Ycur = sc.nextInt();// 나이트 현재 열
			Xtarget = sc.nextInt();// 목적지 행
			Ytarget = sc.nextInt();// 목적지 열

			int[][] board = new int[N][N];// 보드판
			Queue<Integer> quuX = new LinkedList<>();// 탐색 대상의 행 저장 큐
			Queue<Integer> quuY = new LinkedList<>();// 탐색 대상의 열 저장 큐

			// 큐에 시작점 넣기
			quuX.add(Xcur);
			quuY.add(Ycur);

			// 현재 위치가 목적지와 같지 않으면 계속 반복
			while (Xcur != Xtarget || Ycur != Ytarget) {
				// 큐에서 탐색대상 꺼내기
				Xcur = quuX.poll();
				Ycur = quuY.poll();

				// 8방 델타탐색
				for (int i = 0; i < 8; i++) {
					// 탐색 시 보드판 범위 벗어나면 현재 방향 탐색 종료
					if (Xcur + dx[i] < 0 || Xcur + dx[i] > N - 1 || Ycur + dy[i] < 0 || Ycur + dy[i] > N - 1)
						continue;

					// 아직 방문한 적 없는 칸이면
					if (board[Xcur + dx[i]][Ycur + dy[i]] == 0) {
						// 최소 이동을 표시함. 현재칸 값+1
						board[Xcur + dx[i]][Ycur + dy[i]] = board[Xcur][Ycur] + 1;
						// 현재 방향 탐색지를 다음 탐색 대상 후보로 큐에 넣음
						quuX.add(Xcur + dx[i]);
						quuY.add(Ycur + dy[i]);
					}
				}
			}
			//출력
			System.out.println(board[Xcur][Ycur]);
		}
		sc.close();
	}
}
