package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon15500 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	// 1번 막대기
	static Stack<Integer> one = new Stack<>();
	// 2번 막대기
	static Stack<Integer> two = new Stack<>();
	// 3번 박대기
	static Stack<Integer> three = new Stack<>();
	static int max = 0;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 탑의 개수
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1번 막대기에 탑 쌓기
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			one.push(num);
		}
		// 제일 큰 탑의 크기
		max = N;
		// 재귀 시작
		move(max);
		// 만들어진 StringBuiler의 맨 앞에 엔터 추가
		sb.insert(0, "\n");
		// 맨 앞에 몇번 재귀 돌았는지 추가(몇번 옮겼는지)
		sb.insert(0, cnt - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void move(int max) {
		// 재귀 돌때마다 cnt ++
		// 주석 쓰다가 든 생각인데 아래 return 아래에다가 cnt++ 했으면
		// 위에 출력할때 cnt-1로 안해도 됐겠다.
		cnt++;
		if (max == 0) {
			return;
		}
		// max가 1번 막대기에 있을 경우
		if (one.contains(max)) {
			// 1번 막대기의 맨 위에가 max 일때까지 pop해서 2번막대기로 옮기고
			if (one.peek() != max) {
				sb.append(1).append(" ").append(2).append("\n");
				two.push(one.pop());
			} else { // 1번 막대기의 맨 위가 max면 pop해서 3번 막대기로 옮기기
				sb.append(1).append(" ").append(3).append("\n");
				three.push(one.pop());
				max--;
			}
			// 3번 막대기로 max 옮겼으니 max 한개 줄이고 재귀 ㄱㄱ
			move(max);
			// 아래는 위와 동일
		} else if (two.contains(max)) { // max가 2번 막대기에 있을 경우
			if (two.peek() != max) {
				sb.append(2).append(" ").append(1).append("\n");
				one.push(two.pop());
			} else {
				sb.append(2).append(" ").append(3).append("\n");
				three.push(two.pop());
				max--;
			}
			move(max);
		}
	}
}
