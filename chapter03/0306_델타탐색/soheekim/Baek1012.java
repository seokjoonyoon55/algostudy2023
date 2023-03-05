package study0306;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek1012 {
	// 상하좌우용 델타탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트 케이스 갯수

		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();// 가로 j c X
			int N = sc.nextInt();// 세로 i r Y
			int K = sc.nextInt();// 배추칸 갯수

			int X = -1;// 배추 가로 위치
			int Y = -1;// 배추 세로 위치
			int earthWorm = 0;// 지렁이 마리 수

			//bfs용 큐
			Queue<Integer> quuR = new LinkedList<>();
			Queue<Integer> quuC = new LinkedList<>();

			int[][] field = new int[N][M];//땅 상태
			
			//배추칸 입력받기
			for (int i = 0; i < K; i++) {
				X = sc.nextInt();
				Y = sc.nextInt();
				field[Y][X] = 1;
			}

			//모든 칸에 대해
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					//배추가 있다면
					if (field[r][c] == 1) {
						field[r][c] = -1;//방문표시
						earthWorm++;//지렁이 갯수++

						//bfs용 큐에 탐색 후보로 저장
						quuR.add(r);
						quuC.add(c);

						//큐가 빌 때까지 반복
						while (!quuC.isEmpty()) {
							//큐에서 탐색대상 꺼내기
							Y = quuR.poll();
							X = quuC.poll();

							//4방 델타탐색
							for (int k = 0; k < 4; k++) {
								//경계조건
								if (Y + dr[k] >= N || Y + dr[k] < 0 || X + dc[k] >= M || X + dc[k] < 0)
									continue;

								//방문된 적 없으면
								if (field[Y + dr[k]][X + dc[k]] == 1) {
									//큐에 넣고 -1로 방문 표기
									quuR.add(Y + dr[k]);
									quuC.add(X + dc[k]);
									field[Y + dr[k]][X + dc[k]] = -1;
								}
							}
						}

					}
				}
			}
			//출력
			System.out.println(earthWorm);
		}
		sc.close();
	}
}