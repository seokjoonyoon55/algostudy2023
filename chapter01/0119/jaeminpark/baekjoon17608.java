package baekjoonPractice;

import java.util.Scanner;

public class baekjoon17608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//블록의 개수 저장할 변수
		int[] blockArr = new int[N];	//각 블록의 높이를 저장할 배열 
		int cnt = 1;	// 보이는 블록의 개수 -> 첫 블록은 무조건 보이므로 1부터 시작
		int max_height;	// 블록 중 가장 높은 블록의 높이

		for (int i = 0; i < N; i++) {	// 블록의 개수를 blockArr[0]부터 차례대로 넣어줌
			blockArr[i] = sc.nextInt();
		}
		
		max_height = blockArr[blockArr.length-1];	// 블록이 보이려면 맨 앞보다는 무조건 커야 되므로 max_height을 배열의 맨 오른쪽 값으로 초기화
		for (int i = blockArr.length - 1; i > 0; i--) {	//블록의 오른쪽부터 가면서 따지는 for문
			if (blockArr[i - 1] > blockArr[i] && blockArr[i-1] > max_height) {
				cnt++;
				max_height = blockArr[i-1];	
			}//if문 끝
		}//for문 끝
		System.out.println(cnt);
	}//main method 끝

}
