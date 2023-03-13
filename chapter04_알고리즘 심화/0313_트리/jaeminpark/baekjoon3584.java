package baekjoon_03_Gold;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon3584 {

	static point[] points;
	static boolean[] visited;

	// points 배열 안에 넣을 각각의 정점 정보
	public static class point {
		int no;
		int parent;
		List<Integer> to = new ArrayList<>();

		public point(int no, int parent) {
			this.no = no;
			this.parent = parent;
		}
	}

	// PiorityQueue에 간선 정보 묶어서 넣기 위한 클래스
	public static class line {
		int from;
		int to;

		public line(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			// 정점 개수
			int V = sc.nextInt();
			// 정점들의 배열 할당
			points = new point[V + 1];
			// 나중에 bfs 실행하기 위한 방문 여부 판단 배열
			visited = new boolean[V + 1];
			// 오름차순으로 정보 넣기 위한 Priority Queue
			PriorityQueue<line> pq = new PriorityQueue<>(new Comparator<line>() {
				@Override
				public int compare(line o1, line o2) {
					int from1 = o1.from;
					int to1 = o1.to;
					int from2 = o2.from;
					int to2 = o2.to;
					if (from1 > from2) {
						return 1;
					} else
						return -1;
				}
			});
			// pq에 간선 정보들 다 넣기
			for (int i = 1; i < V; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				pq.offer(new line(from, to));
			}
			// 공통 부모 찾을 정점1
			int A = sc.nextInt();
			// 공통 부모 찾을 정점2
			int B = sc.nextInt();
//			System.out.println(A);
//			System.out.println(B);
			// points 배열 초기화
			for (int i = 1; i <= V; i++) {
				points[i] = new point(0, 0);
			}
			// points 배열에 정점들의 정보 담기
			for (int i = 1; i < V; i++) {
				line l = pq.remove();
				int no = l.from;
				int to = l.to;
				points[no].no = no;
				points[no].to.add(to);
				points[to].parent = no;
				points[to].no = to;
			}
			// A의 모든 부모
			List<Integer> aParents = new ArrayList<>();
			// B의 모든 부모
			List<Integer> bParents = new ArrayList<>();
			while (points[A].parent != 0) {
				aParents.add(A);
				A = points[A].parent;
			}
			while (points[B].parent != 0) {
				bParents.add(B);
				B = points[B].parent;
			}
			// 맨 위는 어차피 공통 부모인 1임 그러니 1로 초기화
			int sameParent = 1;
			loop: for (int i = 0; i < aParents.size(); i++) {
				int aParent = aParents.get(i);
				for (int j = 0; j < bParents.size(); j++) {
					int bParent = bParents.get(j);
					// A와 B각 각각 먼저 만난 부모부터 비교했을 때 일치하면 그게 가장 가까운 공통조상임
					if (aParent == bParent) {
						sameParent = aParent;
						break loop;
					}
				}
			}
			// 서브 트리의 크기
			int cnt = 0;
			// 아래는 그냥 bfs 돌린것
			Queue<point> q = new LinkedList<>();
			q.offer(points[sameParent]);
			visited[sameParent] = true;
			while (!q.isEmpty()) {
				cnt++;
				point P = q.remove();
				for (int i = 0; i < P.to.size(); i++) {
					point nextP = points[P.to.get(i)];
					if (!visited[nextP.no]) {
						visited[nextP.no] = true;
						q.offer(nextP);
					}
				}
			}
			// 출력 형식
			sb.append(sameParent).append("\n");
		}
		// 출력
		System.out.println(sb);
	}

}
