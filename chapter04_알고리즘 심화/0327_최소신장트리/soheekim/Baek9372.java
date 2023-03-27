package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek9372 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> quu = new LinkedList<>();
		int T = Integer.parseInt(bfr.readLine());// 테스트 케이스 수

		// T개 케이스에 대해
		for (int tc = 1; tc <= T; tc++) {
			// NM 입력받기
			String[] NM = bfr.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);// 노드 수
			int M = Integer.parseInt(NM[1]);// 간선 수

			boolean[] visited = new boolean[N + 1];// 방문 여부 저장 배열
			int cnt = 0;// 사용한 간선 수
			int temp = -1;// 임시 변수

			// 간선 입력받을 배열
			List<Integer>[] linked = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				linked[i] = new ArrayList<Integer>();

			// 간선 입력
			for (int i = 0; i < M; i++) {
				String[] tempS = bfr.readLine().split(" ");
				int nodeA = Integer.parseInt(tempS[0]);
				int nodeB = Integer.parseInt(tempS[1]);

				linked[nodeA].add(nodeB);
				linked[nodeB].add(nodeA);
			}

			// 1번 노드 방문 표시 후 큐에 넣기
			visited[1] = true;
			quu.add(1);

			// 큐가 비어있기 전까지
			while (!quu.isEmpty()) {
				// 큐에서 꺼냄
				temp = quu.poll();

				// 현재 노드에 연결된 노드들에 대해
				for (int i = 0; i < linked[temp].size(); i++) {
					// 이미 방문했으면 continue
					if (visited[linked[temp].get(i)])
						continue;

					// 아직 방문하지 않았으면
					visited[linked[temp].get(i)] = true;// 방문 표시
					cnt++;// 사용 간선 수 ++
					quu.add(linked[temp].get(i));// 큐에 다음 탐색 후보로 넣음
				}
			}

			//출력
			System.out.println(cnt);

		}

	}
}
