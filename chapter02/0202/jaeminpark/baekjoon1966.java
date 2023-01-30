package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> q = new LinkedList<>();
		// 문서 중요도 Set(중복 허용 안함)
		Set<Integer> docSet = new HashSet<>();
		List<Integer> docList = new ArrayList<>();
		int docIndex = 0;
		StringTokenizer st1;
		StringTokenizer st2;
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 개수
		int t = Integer.parseInt(br.readLine());
		// 문서의 개수
		int N;
		// 몇번째로 인쇄되는지 궁금하 문서의 Index
		int M;
		// 출력한 문서의 개수
		int cnt;
		// 문서들 중 가장 중요도가 높은 문서의 중요도
		int max;
		// 궁금한 문서의 중요도
		int doc;
		boolean flag;
		for (int i = 0; i < t; i++) {
			// 테스트 케이스 돌릴떄마다 초기화 해줘야 함
			docList.clear();
			docSet.clear();
			q.clear();
			docIndex = 0;
			max = 0;
			cnt = 0;
			doc = 0;
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());

			// 문서 중요도 숫자들 q에 넣기
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st2.nextToken());
				// M번째 문서의 중요도 저장
				if (j == M) {
					doc = a;
				}
				q.offer(a);
				docSet.add(a);
			}
			// 메소드 사용을 위해 Set을 List로 전환
			docList.addAll(docSet);
			// List 오름차순 정렬
			Collections.sort(docList);
			// List 순서 뒤집기
			Collections.reverse(docList);
			// 위에서 docIndex 0으로 초기화함
			max = docList.get(docIndex);

			flag = true;
			while (flag) {
				// q의 head가 최댓값이면
				if (q.peek() == max) {
					// 출력
					q.poll();
					// 출력한 횟수 증가
					cnt++;
					// 출력해서 문서 하나 빠지니까 순서 앞으로 옴
					M--;
					// m이 빠졌는데 max가 doc이면 주시하던 문서가 출력된것
					if (max == doc && M == -1) {
						break;
					}
				} else {
					// q의 head가 최댓값이 아니면 뒤로 보내기
					q.offer(q.poll());
					// 앞으로 계속 땡겨져 오니까 m(주시 문서의 순서)도 앞으로 땡겨져옴
					M--;
					// m(주시 문서의 순서)가 0보다 작아지면 맨 뒤로 간거니까 맨뒤 인덱스 부여
					if (M == -1) {
						M = q.size() - 1;
					}
				}
				// q에 max가 없으면 그 다음 최댓값 출력해야 함
				if (!q.contains(max)) {
					docIndex++;
					max = docList.get(docIndex);
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
