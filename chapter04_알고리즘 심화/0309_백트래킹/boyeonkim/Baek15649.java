package barkingdog;

import java.util.Scanner;

public class BOJ15649 {
	static int n, m;
	static int[] arr = new int[9];
	static boolean[] visited = new boolean[9];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		bt(0);
	}
	// 현재 선택한 k개까지의 수
	static void bt(int k) {
		// 끝까지 탐색했다면 출력하기
		if(m == k) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			// 한칸 위로 올라가기
			return;
		}
		// 1부터 n까지의 수
		for(int i = 1; i <= n; i++) {
			// 숫자 i가 사용되지 않았다면
			if(!visited[i]) {
				arr[k] = i; // 배열에 i를 저장하고 
				visited[i] = true; // 사용했다고 표시해주기
				bt(k + 1); // 사용한 i빼고 재귀
				visited[i] = false; // 사용했던거 다시 false로 바꿔주고 다른 i탐색
			}
		}

	}
}
