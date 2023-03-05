package study0306;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek2178 {
	// 상하좌우 델타탐색용 변수
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 미로 행
		int M = sc.nextInt();// 미로 열
		sc.nextLine();// 개행문자 버림

		//미로 선언. 인덱스 입력 편의를 위해 1줄씩 늘려서 씀
		int[][] maze = new int[N + 1][M + 1];
		String[] tempS;//미로 입력용 임시변수

		//미로 bfs용 큐
		Queue<Integer> xQuu = new LinkedList<>();
		Queue<Integer> yQuu = new LinkedList<>();
		int curx = -1;//탐색중인 행 변수
		int cury = -1;//탐색중인 열 변수

		//미로 입력받기
		for (int i = 1; i <= N; i++) {
			tempS = sc.nextLine().split("");
			for (int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(tempS[j - 1]);
			}
		}

		//bfs 시작할 1,1 큐에 넣기
		xQuu.add(1);
		yQuu.add(1);

		//bfs 시작
		while (!xQuu.isEmpty()) {
			//탐색지점 큐에서 꺼내기
			curx = xQuu.poll();
			cury = yQuu.poll();
			for (int d = 0; d < 4; d++) {
				// 경계조건
				if (curx + dx[d] < 1 || curx + dx[d] > N || cury + dy[d] < 1 || cury + dy[d] > M)
					continue;
				//방문하지 않은 칸이 있으면
				if (maze[curx + dx[d]][cury + dy[d]] == 1) {
					//이전칸+1로 깊이 표시
					maze[curx + dx[d]][cury + dy[d]] = maze[curx][cury] + 1;
					//큐에 넣어서 bfs 후보로 올림
					xQuu.add(curx + dx[d]);
					yQuu.add(cury + dy[d]);
				}
			}
		}
		//출력
		System.out.println(maze[N][M]);
		sc.close();
	}
}
