package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2623 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// NM 입력받기
		String[] NM = bfr.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);// 가수 수
		int M = Integer.parseInt(NM[1]);// 보조PD 수

		int[] inDegree = new int[N + 1];// 진입 차수

		// 연결리스트 선언 및 할당
		ArrayList<Integer>[] singer = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			singer[i] = new ArrayList<>();
		}

		// 가수 순서 정보 입력받기
		for (int PD = 0; PD < M; PD++) {
			//PD 라인 입력받음
			String[] tempS = bfr.readLine().split(" ");
			
			// 현재 PD가 담당한 가수 숫자
			int people = Integer.parseInt(tempS[0]);

			// 담당 가수들에 대해 연결리스트 입력 및 진입차수++
			for (int j = 1; j < people; j++) {
				int from = Integer.parseInt(tempS[j]);
				int to = Integer.parseInt(tempS[j + 1]);

				singer[from].add(to);
				inDegree[to]++;
			}
		}

		//위상정렬용 큐
		Queue<Integer> quu = new LinkedList<>();

		//진입 0인 가수 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				quu.add(i);
		}

		int curSing = 0;//현재 고려중인 가수 번호
		int printCnt = 0;//위상정렬로 sb에 저장된 가수 숫자
		
		//큐가 비기 전까지 반복
		while (!quu.isEmpty()) {
			//큐에서 꺼내기
			curSing = quu.poll();

			//꺼낸 가수 sb에 입력 후 cnt++
			sb.append(curSing).append("\n");
			printCnt++;
			
			//꺼낸 가수에서 연결된 가수들에 대해
			for (int i = 0; i < singer[curSing].size(); i++) {
				int next = singer[curSing].get(i);
				
				//진입차수 --
				inDegree[next]--;
				
				//진입차수==0이 되면 큐에 넣음
				if (inDegree[next] == 0)
					quu.add(next);
			}

		}

		//그래프에 사이클이 있어서 전체 탐색이 안됐다면 0출력
		if (printCnt != N)
			System.out.println(0);
		//전체 탐색 했다면 sb 출력
		else
			System.out.println(sb);

	}
}
