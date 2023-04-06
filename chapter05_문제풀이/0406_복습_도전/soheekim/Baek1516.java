package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1516 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// 건물 갯수
		int N = Integer.parseInt(bfr.readLine());

		int[] time = new int[N + 1];// 건물 짓는 시간
		int[] needTime = new int[N + 1];// 건물 짓기 전 필요 시간
		int[] inDegree = new int[N + 1];// 진입 차수
		ArrayList<Integer>[] need = new ArrayList[N + 1];// 진출 노드

		// 진출 노드 리스트 할당
		for (int i = 1; i <= N; i++) {
			need[i] = new ArrayList<>();
		}

		// 위상정렬 용 큐
		Queue<Integer> quu = new LinkedList<>();

		// 건물 정보 입력받기
		String[] tempS;
		for (int line = 1; line <= N; line++) {
			// line번째 건물 짓는데 걸리는 시간 받기
			tempS = bfr.readLine().split(" ");
			time[line] = Integer.parseInt(tempS[0]);

			// 건물번호 저장하기
			for (int i = 1; i < tempS.length - 1; i++) {
				// 두번째 숫자부터 저장, 진입 차수++
				int from = Integer.parseInt(tempS[i]);
				need[from].add(line);
				inDegree[line]++;
			}
		}

		// 진입 차수 0 건물 큐에 추가
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				quu.add(i);
		}

		// 현재 고려중인 건물 번호
		int cur = -1;

		// 큐가 빌 때까지 반복
		while (!quu.isEmpty()) {
			// 큐에서 꺼냄
			cur = quu.poll();

			// 갈 수 있는 건물들에 대해
			for (int i = 0; i < need[cur].size(); i++) {
				// 다음 건물 번호
				int next = need[cur].get(i);

				// 필요한 대기시간 = 직전에 연결된 건물들 짓는데 걸리는 시간 중 최대
				needTime[next] = Math.max(needTime[next], time[cur]);

				inDegree[next]--;// 진입차수--

				// 진입차수가 0이 되면
				if (inDegree[next] == 0) {
					// 이전 건물들이 전부 고려되었으므로
					// 현재 건물 건설시간 + 이전 건물 시간 중 최대
					time[next] += needTime[next];

					// 큐에 진입차수가 0이 된 건물 넣음
					quu.add(next);
				}
			}
		}

		// 출력
		for (int i = 1; i <= N; i++) {
			System.out.println(time[i]);
		}

	}
}
