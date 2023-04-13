package day0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1149 {
	static final int red = 0;
	static final int green = 1;
	static final int blue = 2;

	static int cost[][];
	static int painted[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		//집 갯수
		int N = Integer.parseInt(bfr.readLine());

		cost = new int[N][3]; // 집 칠하는데 드는 비용
		painted = new int[N][3]; // 현재까지 칠하는 최소 비용

		//집 칠 비용 입력받기
		String[] tempS;
		for (int line = 0; line < N; line++) {
			tempS = bfr.readLine().split(" ");
			cost[line][red] = Integer.parseInt(tempS[0]);
			cost[line][green] = Integer.parseInt(tempS[1]);
			cost[line][blue] = Integer.parseInt(tempS[2]);
		}

		//초기 설정
		painted[0][red] = cost[0][red];
		painted[0][green] = cost[0][green];
		painted[0][blue] = cost[0][blue];

		System.out.println(Math.min(paint(N - 1, red), Math.min(paint(N - 1, green), paint(N - 1, blue))));
	}

	//칠하는 메서드
	static int paint(int num, int color) {
		//아직 계산되지 않았으면
		if (painted[num][color] == 0) {
			//색깔에 따라
			switch (color) {
			//칠 최소비용 = 이전꺼 다른색 칠 비용 2개 중 작은 것
			case red:
				painted[num][color] = Math.min(paint(num - 1, green)+cost[num][color], paint(num - 1, blue)+cost[num][color]);
				break;
			case green:
				painted[num][color] = Math.min(paint(num - 1, red)+cost[num][color], paint(num - 1, blue)+cost[num][color]);
				break;
			case blue:
				painted[num][color] = Math.min(paint(num - 1, red)+cost[num][color], paint(num - 1, green)+cost[num][color]);
				break;
			}
		}
		//결과 반환
		return painted[num][color];
	}
}
