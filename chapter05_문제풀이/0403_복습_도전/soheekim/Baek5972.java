package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Baek5972 {
	// 간선 클래스
	static class Edge {
		// 시작점, 끝점, 가중치
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

	}

	// 노드 클래스
	static class Node implements Comparable<Node> {
		// 노드 번호, 그 노드까지의 거리
		int num, dist;

		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}

		@Override
		public String toString() {
			return "[" + num + ", " + dist + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		// 다익스트라용 우선순위큐
		PriorityQueue<Node> pq = new PriorityQueue<>();

		// NM 입력받기
		String[] tempS = bfr.readLine().split(" ");
		int N = Integer.parseInt(tempS[0]);// 정점 갯수
		int M = Integer.parseInt(tempS[1]);// 간선 갯수

		// 방문여부 저장 배열, 최소 거리 저장 배열 할당 및 초기화
		boolean[] visit = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		List<Edge>[] eList = new ArrayList[N + 1];

		int start, end, weight;

		// M개 간선에 대해 간선 정보 입력 받기
		for (int i = 0; i < M; i++) {
			tempS = bfr.readLine().split(" ");
			start = Integer.parseInt(tempS[0]);
			end = Integer.parseInt(tempS[1]);
			weight = Integer.parseInt(tempS[2]);

			// 할당 안돼있으면 하기
			if (eList[start] == null)
				eList[start] = new ArrayList<Edge>();

			if (eList[end] == null)
				eList[end] = new ArrayList<Edge>();

			// 간선 저장
			eList[start].add(new Edge(start, end, weight));
			eList[end].add(new Edge(end, start, weight));
		}

		// 다익스트라용 임시 변수
		Node tempN;

		// Dijkstra용, 1번노드 우선큐에 넣기
		pq.add(new Node(1, 0));

		// Dijkstra 돌리기
		while (true) {
			// 큐에서 꺼냄
			tempN = pq.poll();

			// 이미 방문된 정점이면 continue;
			if (visit[tempN.num])
				continue;

			// 꺼내진 거리와 현재 거리중 작은 것 저장
			dist[tempN.num] = Math.min(dist[tempN.num], tempN.dist);

			// 방문 표시
			visit[tempN.num] = true;

			// 현재 정점에서 갈 수 있는 노드들에 대해
			for (int i = 0; i < eList[tempN.num].size(); i++) {
				// 현재 정점 최소거리 + 넘어가는데 드는 가중치(거리) 해서 우선큐에 넣기
				pq.add(new Node(eList[tempN.num].get(i).end, dist[tempN.num] + eList[tempN.num].get(i).weight));
			}

			// N번 정점에 도착하거나, 우선큐가 비어있으면 반복 종료
			if (tempN.num == N)
				break;
			if (pq.isEmpty())
				break;
		}

		// 출력
		System.out.println(dist[N]);

	}
}
