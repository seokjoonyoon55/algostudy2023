import java.util.Scanner;

public class BOJ15650 {
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		visited = new boolean[m + 1];
		
		bt(0);
		System.out.println(sb);
		sc.close();
	}
	// 오름차순 정렬이기 때문에
	// m개만큼 숫자를 골랐을 때 고른 숫자들이 오름차순이 아닐 경우, 종료
	// 오름차순일 경우 스트링빌더에 저장
	static void bt(int num) {
		if(num == m) {
			for(int i = 0; i < m - 1; i++) {
				if(arr[i] > arr[i + 1])
					return;
			}
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[num] = i;
				bt(num + 1);
				visited[i] = false;
			}
		}
	}
}
