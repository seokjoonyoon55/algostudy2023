import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek10816 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		// 큐에 상근이가 가지고 있는 카드 넣기
		for(int i = 0; i < N; i++) {
			q.offer(sc.nextInt());
		}
		
		int M = sc.nextInt();
		int[] card = new int[M];
		// 몇 개 있는지 알아봐야할 카드 배열
		for(int i = 0 ; i < M; i++) {
			card[i] = sc.nextInt();
		}
		
		// 큐에서 상근이 카드 한장 빼서 카드 배열과 일치하는 값이 있으면 카운트
		int[] result = new int[M];
		while(!q.isEmpty()) {
			int find = q.poll();
			for(int i = 0; i < M; i++) {
				if(find == card[i]) {
					result[i]++;
					break;
				}
			}
		}
		for(int i = 0; i < M; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
