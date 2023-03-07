package study0227;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Baek2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 노드 갯수
		int lines = sc.nextInt();// 간선 갯수

		Node[] nodes = new Node[N];// 노드들의 배열
		Queue<Node> quu = new LinkedList<Node>();// 탐색후보 노드 담아놓을 큐
		Node temp;// BFS 탐색용 임시 변수
		int tempIdx;// BFS 탐색용 임시 변수
		int cnt = 0;// 노드1과 연결된 노드 갯수(노드1 포함)

		// 새 노드들 만들어서 배열에 넣어주기
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}

		// 두 노드의 간선 정보 저장
		for (int i = 0; i < lines; i++) {
			linkAB(nodes[sc.nextInt() - 1], nodes[sc.nextInt() - 1]);
		}

		// 탐색 시작점인 노드1을 큐에 추가
		quu.add(nodes[0]);

		// 큐가 빌 때까지 탐색
		while (!quu.isEmpty()) {
			// 큐의 첫번째 원소 꺼내기
			temp = quu.poll();
			// 꺼낸 원소를 방문한 적 없다면 표시하고 갯수++
			if (temp.visited == false) {
				temp.visited = true;
				cnt++;
			}
			// 꺼낸 원소에 연결된 노드들에 대해
			for (int i = 0; i < temp.linked.size(); i++) {
				// 연결된 노드의 인덱스
				tempIdx = temp.linked.get(i);
				// 꺼낸 노드가 방문된 적이 없다면 탐색 후보 큐에 넣음
				if (!nodes[tempIdx].visited)
					quu.add(nodes[tempIdx]);
			}
		}
		//자기 자신인 노드1을 제외한 뒤 노드1에 연결된 갯수 출력
		System.out.println(cnt - 1);
		sc.close();
	}

	//노드 A와 B의 간선 정보에 서로를 추가하기
	public static void linkAB(Node nodeA, Node nodeB) {
		nodeA.linked.add(nodeB.num);
		nodeB.linked.add(nodeA.num);
	}
}

class Node {
	int num;//노드 번호(인덱스 사용을 위해 -1씩 하여 저장함)
	boolean visited;//방문 여부
	ArrayList<Integer> linked;//연결된 노드들의 배열인덱스

	Node(int num) {
		super();
		this.num = num;
		this.visited = false;
		this.linked = new ArrayList<Integer>();
	}
}