package study0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baek1647_2 {
	static class Edge {
		int start, end, weight;

		public Edge() {
		}

		public Edge(int start, int end, int weight) {
			this.weight = weight;
			this.start = start;
			this.end = end;
		}

		// test
		@Override
		public String toString() {
			return this.start + " " + this.end + " " + this.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = bfr.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);// 노드 수 입력받기
		int M = Integer.parseInt(NM[1]);// 간선 수 입력받기

		boolean[] visited = new boolean[N + 1];// 방문여부 저장
		int cntNode = 0;// 방문한 노드 갯수
		int cost = 0;// 비용 합
		int maxWeight = Integer.MIN_VALUE;// 최대 비용
		Edge tempE = null;// 임시변수

		// 노드 1001개 선언. 0번노드 사용안함
		LinkedList<Edge>[] graph = new LinkedList[1000 + 1];

		// M개 간선에 대해
		for (int i = 0; i < M; i++) {
			// A B C입력받기
			String[] ABC = bfr.readLine().split(" ");
			tempE = new Edge(Integer.parseInt(ABC[0]), Integer.parseInt(ABC[1]), Integer.parseInt(ABC[2]));

			// weight 리스트 null이면 생성하기
			if (graph[tempE.weight] == null)
				graph[tempE.weight] = new LinkedList<Edge>();
			// weight리스트에 더해주기
			graph[tempE.weight].add(tempE);
		}

		int curWeight = 1;// 현재 고려중인 가중치
		int cntEdge = 1;// 간선 더해진 수

		// N개노드 선택 전까지 반복
		while (cntNode < N) {
			// N개 노드 선택됐으면 탈출
			if (cntNode == N)
				break;

			// N-1개 간선 선택됐으면 탈출
			if (cntEdge == N - 1)
				break;

			// [가중치]리스트 비어있으면 다음 가중치로 넘어감
			if (graph[curWeight] == null) {
				curWeight++;
				continue;
			}

			// 비어있지 않은 가중치 리스트 탐색
			for (int i = 0; i < graph[curWeight].size(); i++) {
				// 탐색중 선택된 노드 N개이면 탈출
				if (cntNode == N)
					break;

				// 탐색 중 선택된 간선 N-1개이면 탈출
				if (cntEdge == N - 1)
					break;

				// 리스트에서 i번째에 있는 간선
				tempE = graph[curWeight].get(i);

				// 간선 양옆 다 방문했으면 다음 간선 탐색
				if (visited[tempE.start] && visited[tempE.end])
					continue;

				// start 정점 방문 안됐으면 방문표시하고 노드수++, 간선 가중치 cost에 더함, 최대 가중치 갱신
				if (!visited[tempE.start]) {
					visited[tempE.start] = true;
					cntNode++;
					cost += tempE.weight;
					if (maxWeight < tempE.weight)
						maxWeight = tempE.weight;
				}

				// end 정점 방문 안됐으면 방문표시하고 노드수++, 간선 가중치 cost에 더함, 최대 가중치 갱신
				if (!visited[tempE.end]) {
					visited[tempE.end] = true;
					cntNode++;
					cost += tempE.weight;
					if (maxWeight < tempE.weight)
						maxWeight = tempE.weight;
				}
				// 선택된 간선 수++
				cntEdge++;
			}
			// 다음 가중치로 ++
			curWeight++;
		}

		// 정점 선택 전에 간선 다 선택돼서 나온거면 cost만
		if (cntEdge < N - 1)
			System.out.println(cost);
		// 정점 다 선택돼서 나온 경우 cost-더해진 최대 가중치
		else
			System.out.println(cost - maxWeight);

	}

}
