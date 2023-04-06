package baekjoon_03_Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2623 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가수 수
		int N = Integer.parseInt(st.nextToken());
		// 보조 PD 수
		int M = Integer.parseInt(st.nextToken());
		// 가수들 다음 순서 정보 나타낼 인접 리스트
		List<Integer>[] nextSeq = new ArrayList[N + 1];
		// 들어오는 간선 개수 표시할 배열
		int[] indegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			nextSeq[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 보조 pd가 넣은 가수의 수
			int num = Integer.parseInt(st.nextToken());
			// 인접 리스트에 순서 정보 넣기 위해 만든 배열
			int[] seq = new int[num];
			for (int j = 0; j < num; j++) {
				seq[j] = Integer.parseInt(st.nextToken());
			}
			// 앞에 가수 뒤에 다음 가수 하므로 그 순서 이용해서 각각 인접리스트에 넣어주기
			for (int j = 0; j < num - 1; j++) {
				// 근데 중복할수도 있으므로 중복되는 애들 생략
				if (!nextSeq[seq[j]].contains(seq[j + 1])) {
					nextSeq[seq[j]].add(seq[j + 1]);
				}
			}
		}
		// 인접리스트 보고 indegree 수 채워주기
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < nextSeq[i].size(); j++) {
				indegree[nextSeq[i].get(j)]++;
			}
		}
		// 위상 정렬에 이용할 큐
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.remove();
			if (indegree[cur] == 0) {
				sb.append(cur).append("\n");
			}
			for (int next : nextSeq[cur]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		boolean possible = true;
		// indegree가 모두 0이라면 각 pd들이 요청한대로 출연이 가능한것 아니라면 불가 => 0 출력
		for(int i = 1; i<=N; i++) {
			if(indegree[i] != 0) {
				possible = false;
				break;
			}
		}
		if(possible) {
			System.out.println(sb);
		} else {
			System.out.println(0);
		}

	}

}
