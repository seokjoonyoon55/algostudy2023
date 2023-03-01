package study0302;

import java.util.Scanner;
import java.util.Stack;

public class Baek4963 {
	//8방  델타탐색용 변수
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = -1;//섬 너비
		int H = -1;//섬 높이

		//0 0 이 입력되기 전까지 반복
		while (W != 0 && H != 0) {
			//섬 너비, 섬 높이 입력받기
			String[] WH = sc.nextLine().split(" ");
			W = Integer.parseInt(WH[0]);
			H = Integer.parseInt(WH[1]);
			
			//0 0 입력시 반복 종료
			if(W == 0 && H == 0) break;

			//전체 지형 저장용 이차원배열
			int[][] land = new int[H][W];

			//전체 지형 입력받기
			for (int i = 0; i < H; i++) {
				String[] tempS = sc.nextLine().split(" ");
				for (int j = 0; j < W; j++) {
					land[i][j] = Integer.parseInt(tempS[j]);
				}
			}

			//탐색대상 좌표 저장할 스택
			Stack<Integer> sti = new Stack<>();
			Stack<Integer> stj = new Stack<>();
			
			int curi;//탐색 중인 행
			int curj;//탐색 중인 열
			int island = 0;//섬갯수

			//모든 칸에 대하여 탐색 시작
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					//좌표의 값이 1이어서 땅이면
					if (land[i][j] == 1) {
						//-1로 방문 표기하고 섬 갯수++
						land[i][j] = -1;
						island++;

						//스택에 현재 좌표 넣음
						sti.push(i);
						stj.push(j);

						//현재 좌표와 연결되는 곳들 DFS시작
						//연결된 땅 좌표를 전부 방문해야 스택이 빔
						while (!sti.isEmpty()) {
							curi = sti.pop();
							curj = stj.pop();

							//8방 델타탐색
							for (int k = 0; k < 8; k++) {
								//배열 밖으로 나가면 그 방향 탐색 종료
								if (curi + dx[k] < 0 || curi + dx[k] >= H || curj + dy[k] < 0 || curj + dy[k] >= W)
									continue;
								//이동한 좌표의 값이 1이어서 땅이면
								if (land[curi + dx[k]][curj + dy[k]] == 1) {
									//-1로 방문표기
									land[curi + dx[k]][curj + dy[k]] = -1;
									//이동한 좌표를 스택에 저장
									sti.push(curi + dx[k]);
									stj.push(curj + dy[k]);
								}
							}
						}
					}
				}

			}
			//섬 갯수 출력
			System.out.println(island);
		}
		sc.close();
	}
}
