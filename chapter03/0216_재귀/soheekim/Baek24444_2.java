package study0216;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//성공. 배열 대신 리스트로 구현
public class Baek24444_2 {
	public static int vorder = 1;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int tempx;//현재 행
		int tempy;//현재 열

		ArrayList<Integer>[] lines = new ArrayList[N];//행에 연결된 간선 저장할 연결리스트

		//연결리스트 구현
		for (int i = 0; i < N; i++) {
			lines[i] = new ArrayList<Integer>();
		}

		int[] node = new int[N];//방문순서 저장
		boolean[] isadded = new boolean[N];//큐에 들어간적 있는지 판단용. true면 들어간 적 있음
		Queue<Integer> bfs = new LinkedList<Integer>();//bfs 구현용 큐

		//간선 입력받음
		for (int i = 0; i < M; i++) {
			tempx = sc.nextInt() - 1;
			tempy = sc.nextInt() - 1;
			lines[tempx].add(tempy);
			lines[tempy].add(tempx);
		}
		
		//연결리스트 내 정렬
		for (int i = 0; i < N; i++) {
			Collections.sort(lines[i]);
		}

		//탐색 시작
		visit(lines, node, isadded, bfs, N, R - 1);

		//방문순서 출력
		for (int i = 0; i < N; i++) {
			System.out.println(node[i]);
		}

	}

	public static void visit(ArrayList<Integer>[] lines, int[] node, boolean[] isadded, Queue<Integer> bfs, int N,
			int R) {
		//노드가 방문된 적 없으면
		if (node[R] == 0) {
			node[R] = vorder++;//방문순서 저장
			//연결된 간선들에 대해
			for (int i = 0; i < lines[R].size(); i++) {
				//연결된 간선이 방문된 적 없고 큐에 저장된 적 없으면
				if (node[lines[R].get(i)] == 0 && isadded[lines[R].get(i)] == false) {
					bfs.add(lines[R].get(i));//큐에 저장
					isadded[lines[R].get(i)] = true;//큐에 저장된 것 표시
				}
			}
			//큐에 뭔가 있으면
			if (!bfs.isEmpty()) {
				//다음 탐색대상 뽑아서 탐색 실행
				R = bfs.poll();
				visit(lines, node, isadded, bfs, N, R);
			}
		}
	}
}