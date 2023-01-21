package algorithm;
import java.util.Scanner;

public class BaekJoon2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0; // 최댓값
		int a = 0; // 행 인덱스
		int b = 0; // 열 인덱스
		int[][] map = new int[9][9];
		
		for(int i = 0; i < map.length; i++) { 
			for(int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt(); // 격자판에 숫자 넣기
				
				if(map[i][j] > max) {
					max = map[i][j];
					a = i;
					b = j;
				}
			}
		}
		sc.close();
		
		System.out.println(max);
		System.out.printf(a+1 + " " + b+1); // 제시된 화면에 1행부터 시작이라 +1
	}
}
