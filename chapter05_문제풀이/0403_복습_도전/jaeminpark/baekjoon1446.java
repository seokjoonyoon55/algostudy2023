package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1446 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 지름길 개수
		int N = Integer.parseInt(st.nextToken());
		// 총 고속도로 거리
		int D = Integer.parseInt(st.nextToken());
		// 최소 거리 테이블
		int[] minDist = new int[D + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		// 지름길 및 도로(간선) 저장할 리스트
		List<line>[] roads = new ArrayList[D + 1];
		for (int i = 0; i <= D; i++) {
			roads[i] = new ArrayList<>();
			// D를 제외하곤 다음 도로지점(정점)과 이어줌(D는 다음 정점이 없으므로)
			if (i != D)
				roads[i].add(new line(i + 1, 1));
		}
		// 지름길 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			// 역주행 안된다 했으므로 지름길의 끝 지점이 D보다 클 경우 포함시키지 않음
			if (to <= D) {
				roads[from].add(new line(to, distance));
			}
		}
		PriorityQueue<line> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[D + 1];
		// 처음부터 시작
		pq.offer(new line(0, 0));
		// 시작하는 지점 0으로 초기화
		minDist[0] = 0;
		while (!pq.isEmpty()) {
			line L = pq.remove();
			int cur = L.to;
			if (visited[cur])
				continue;
			visited[cur] = true;
			for (line l : roads[cur]) {
				if (minDist[l.to] > minDist[cur] + l.distance) {
					minDist[l.to] = minDist[cur] + l.distance;
					pq.offer(new line(l.to, minDist[l.to]));
				}
			}
		}
		// 마지막 지점에 최소한으로 도달할 때 거리 출력
		System.out.println(minDist[D]);
	}

	static class line implements Comparable<line> {
		int to;
		int distance;

		line(int to, int distance) {
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(line o) {
			return distance - o.distance;
		}
	}
}
