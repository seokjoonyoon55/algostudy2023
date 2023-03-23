package study0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek11403 {
	static int[][] visit;// 방문 가능여부 저장배열
	static Queue<Integer> quu = new LinkedList<>();
	static List<Integer>[] comeInto;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bfr.readLine());

		visit = new int[N][N];//방문 여부 저장
		String[] tempS;//입력받는 용 임시변수

		// 연결리스트 선언
		comeInto = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			comeInto[i] = new ArrayList<Integer>();
		}

		// 간선 입력. i로 들어오는 노드 입력
		for (int i = 0; i < N; i++) {
			tempS = bfr.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(tempS[j]) == 1)
					comeInto[j].add(i);
			}
		}

		//N개 노드에 대해 판단 메서드 돌림
		for (int i = 0; i < N; i++)
			canVisit(i);

		//출력
		for (int i = 0; i < N; i++) {
			for(int j=0;j<N;j++) {
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
	}

	//startIdx로 올 수 있는 노드 거슬러 올라가면서 표시하는 메서드
	public static void canVisit(int startIdx) {

		int curr = -1;//현재 판단부분
		int last = -1;//거슬러 올라갈 노드
		quu.add(startIdx);//BFS를 위해 큐에 시작점 넣기

		//BFS
		while (quu.size() != 0) {
			curr = quu.poll();//큐에서 꺼내기

			//curr로 들어오는 노드들에 대해
			for (int i = 0; i < comeInto[curr].size(); i++) {
				last = comeInto[curr].get(i);//들어오는 노드

				//들어오는 노드에서 시작점 올 수 있음이 표시돼 있으면 continue;
				if (visit[last][startIdx] != 0)
					continue;

				//방문 표시
				visit[last][startIdx] = 1;
				// visit[last][curr]=1;

				//큐에 다음 BFS 후보 넣기
				quu.add(last);
			}

		}
	}

}
