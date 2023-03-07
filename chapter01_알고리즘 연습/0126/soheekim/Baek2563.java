package study0126;

import java.util.Scanner;

public class Baek2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int black = sc.nextInt();// 검은 종이 수
		int[][] paper = new int[100][100];// 큰 종이 배열로 구현
		int xstart;// 종이 x시작점
		int ystart;// 종이 y시작점

		int overCnt = 0; // 겹친 부분 카운트

		for (int i = 0; i < black; i++) {
			xstart = sc.nextInt();
			ystart = sc.nextInt();
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {//검은종이 크기만큼 이중 for문
					switch (paper[xstart + x][ystart + y]) {
					case 0:
						paper[xstart + x][ystart + y] = 1;
						break; // 안겹치는 부분이면 1로 표시
					case 1:
						overCnt++;
						break;// 겹치면 ++
					}
				}
			}
		}

		System.out.println(black * 100 - overCnt);//총 검은 면적 = 검은종이 수 * 100 - 겹친부분
		sc.close();
	}
}
