package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK11729 {
	
public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 원판의 개수 N
		int N = Integer.parseInt(br.readLine());
		// 총 옮긴 횟수는 2^N - 1 번
		int cnt = (int) (Math.pow(2, N) -1);
		System.out.println(cnt);
		
		Hanoi(N, 1, 2, 3);
		
		System.out.print(sb);
	}
	
	// 원판의 개수, 시작 지점, 중간 지점, 끝 지점 매개변수로 설정
	static void Hanoi(int N, int start, int mid, int end) {
		// 원판의 개수가 1개일 때
		if (N == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		
		// N번째 크기보다 1 작은 탑 전체를 중간 지점으로 전부 이동
		Hanoi(N-1, start, end, mid);
		
		// N번째 크기인 탑 1개를 끝 지점으로 이동
		sb.append(start).append(" ").append(end).append("\n");
		
		// 중간 지점에 있는 탑 전부를 끝 지점으로 이동
		Hanoi(N-1, mid, start, end);

	}
}
