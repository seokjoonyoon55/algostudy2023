package study0302;

import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Baek24479_2 {
	static int cntOrder = 1;//방문 순서

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] NMR = bfr.readLine().split(" ");
		int N = Integer.parseInt(NMR[0]);//정점 갯수
		int M = Integer.parseInt(NMR[1]);//간선 갯수
		int R = Integer.parseInt(NMR[2]);//시작 정점 번호

		Stack<Integer> st = new Stack<>();

		//임시변수들
		String[] tempS = new String[2];
		int tempA;
		int tempB;
		
		//노드의 배열로 그래프 만들기
		Node2[] graph = new Node2[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new Node2();
		}

		//간선 정보 저장
		for (int i = 0; i < M; i++) {
			tempS = bfr.readLine().split(" ");
			tempA = Integer.parseInt(tempS[0]);
			tempB = Integer.parseInt(tempS[1]);
			graph[tempA].linked.add(tempB);
			graph[tempB].linked.add(tempA);
		}

		//간선 정보 오름차순 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i].linked);
		}

		//DFS 시작
		//스택에 시작정점 넣기
		st.add(R);

		//스택이 빌 때까지 계속 반복하며 탐색
		while (!st.isEmpty()) {
			//스택에서 정점 꺼내기
			tempA = st.pop();
			//꺼낸 정점이 0이어서 방문된 적 없으면 방문순서 표기
			if (graph[tempA].order == 0) {
				graph[tempA].order = cntOrder++;

				//스택이고 오름차순으로 방문해야 하므로 높은 숫자부터 스택에 넣음
				//연결된 노드들 중, 방문하지 않은 노드를 스택에 넣음
				for (int i = graph[tempA].linked.size() - 1; i >= 0; i--) {
					tempB = graph[tempA].linked.get(i);
					if (graph[tempB].order == 0)
						st.push(tempB);
				}
			}
		}

		//방문 순서 출력
		for (int i = 1; i < N + 1; i++) {
			System.out.println(graph[i].order);
		}
	}
}

//노드
class Node2 {
	int order;//방문순서. 방문된적 없으면 0
	ArrayList<Integer> linked;//연결된 정점 정보

	Node2() {
		this.order = 0;
		this.linked = new ArrayList<Integer>();
	}
}