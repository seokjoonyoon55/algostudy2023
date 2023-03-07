package study0302;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baek2210 {
	//탐색용 델타 변수
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	//완성된 숫자 저장할 셋
	static Set<String> stringSet = new HashSet<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//5*5 숫자보드 선언
		int[][] board = new int[5][5];

		//숫자보드 입력받음
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				board[i][j] = sc.nextInt();
		}

		//각 칸을 시작점으로 탐색
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++)
				search(board, i, j, "");
		}

		//출력
		System.out.println(stringSet.size());
		sc.close();
	}

	//탐색하면서 문자열 늘리는 메서드
	public static void search(int[][] board, int i, int j, String str) {
		//전달된 문자열 길이가 6이면
		if (str.length() == 6) {
			//셋에 추가하고 함수 종료
			stringSet.add(str);
			return;
		}
		//전달된 문자열 길이가 6보다 작으면
		else {
			//4방 델타탐색
			for (int k = 0; k < 4; k++) {
				//숫자보드 밖으로 나가면 그 방향 종료
				if (i + dx[k] < 0 || i + dx[k] >= 5 || j + dy[k] < 0 || j + dy[k] >= 5)
					continue;
				//현재 문자열 덧붙여서 델타이동 후 탐색
				search(board, i + dx[k], j + dy[k], str + board[i][j]);
			}
		}
		return;
	}

}
