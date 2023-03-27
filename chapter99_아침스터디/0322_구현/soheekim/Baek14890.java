package study0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14890 {
	static int[][] land;//땅 높이 저장 배열
	static int N; //땅 변 길이
	static int L; //경사로 길이
	static int cnt = 0;//지날 수 있는 길 카운트
	
	// 우 하 좌 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NL = bfr.readLine().split(" ");
		N = Integer.parseInt(NL[0]);//땅 변 길이
		L = Integer.parseInt(NL[1]);//경사로 길이

		land = new int[N][N];//땅 배열 할당
		
		//땅 String으로 입력받기
		String[][] tempS = new String[N][N];
		for (int i = 0; i < N; i++) {
			tempS[i] = bfr.readLine().split(" ");
		}

		// 땅 int로 변환해서 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(tempS[i][j]);
			}
		}

		//시작점이 맨 왼쪽줄일 때
		for (int r = 0; r < N; r++) {
			calSmooth(r, 0, 0);// headDown 0 우향
		}

		//시작점이 맨 윗줄일 때
		for (int c = 0; c < N; c++) {
			calSmooth(0, c, 1);// headDown 1 하향
		}
		
		//출력
		System.out.println(cnt);

	}

	//r,c 부터 시작해서 1칸씩 옮겨가며 1차이일 경우 경사로 놓는 메서드
	// headDown 0이면 우향, 1이면 하향
	public static void calSmooth(int r, int c, int headDown) {
		boolean smooth = true;//지나갈 수 있는지 여부
		boolean[] ramp = new boolean[N];//경사로 놓은 곳 표시 배열

		int curR = r;//현재 열
		int curC = c;//현재 행

		int diff = 0;//땅높이 차이
		boolean success = true;//경사로 놓기 성공 여부

		// 위>아래 / 왼>오로 가면서 1낮은 or 1높은 곳 찾아서 경사로 놓기
		for (int line = 0; line < N - 1; line++) {
			success = true;//초기화

			//땅 높이차 계산
			diff = land[curR][curC] - land[curR + dr[headDown]][curC + dc[headDown]];
			
			// -_이면
			if (diff == 1) {
				//다음 위치부터 진행하던 방향으로 경사로 놓기. 실패하면 메서드 종료
				success = installRamp(curR + dr[headDown], curC + dc[headDown], headDown, ramp);
				if (!success)
					return;
			}
			// _-이면
			else if (diff == -1) {
				//현재 위치부터 진행하던 방향과 반대로 경사로 놓기. 실패하면 메서드 종료
				success = installRamp(curR, curC, headDown + 2, ramp);
				if (!success)
					return;
			}
			//높이차가 1보다 크면 크면
			else if (diff < -1 || diff > 1)
				return;
			//높이차 0은 아무 것도 안하고 넘어감

			//다음칸으로 포인터 옮김
			curR += dr[headDown];
			curC += dc[headDown];
		}

		//중간 종료 안됐으므로 지나갈 수 있는 길 카운트 ++
		cnt++;

	}

	//경사로 놓는 메서드
	public static boolean installRamp(int r, int c, int direction, boolean[] ramp) {
		//현재 위치와 현재 높이
		int curR = r;
		int curC = c;
		int height = land[r][c];

		//진행 방향에 따라 경사로 설치 여부  가리키는 인덱스 계산
		int curB = direction % 2 == 0 ? c : r;
		int idx = curB;
		int add = direction < 2 ? 1 : -1;

		//경사로 길이만큼 평지 판단
		for (int i = 0; i < L; i++) {
			// 경계조건
			if (curR < 0 || curR >= N || curC < 0 || curC >= N)
				return false;

			// 이미 경사로 있으면 종료
			if (ramp[curB])
				return false;

			// 높이 유지 안되면 종료
			if (land[curR][curC] != height)
				return false;
			// 높이 유지되면
			else {
				//포인터를 다음 칸으로 진행
				curR += dr[direction];
				curC += dc[direction];
				
				//현재 진행방향에 따른 경사로 설치여부 배열의 인덱스 계산
				curB = direction % 2 == 0 ? curC : curR;
			}
		}
		
		//경사로 놓는데 최종 결과로 성공했으므로, 경사로 설치를 true로 표시하고, 
		for (int i = 0; i < L; i++) {
			ramp[idx] = true;
			idx += add;
		}

		return true;
	}

}
