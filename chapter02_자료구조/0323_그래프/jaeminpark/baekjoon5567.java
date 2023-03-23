package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon5567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 동기 수
		int N = Integer.parseInt(br.readLine());
		// 친구 관계 수
		int M = Integer.parseInt(br.readLine());
		// 관계들(간선들)
		List<Integer>[] friendship = new ArrayList[N + 1];
		// 간선 초기화
		for (int i = 1; i <= N; i++) {
			friendship[i] = new ArrayList<>();
		}
		// 관계 저장
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			friendship[friend1].add(friend2);
			friendship[friend2].add(friend1);
		}
		List<Integer> list = new ArrayList<>();
		// 1의 친구들 list에 담기
		for (int i = 0; i < friendship[1].size(); i++) {
			list.add(friendship[1].get(i));
		}
		// 중복 제거를 위한 set
		Set<Integer> set = new HashSet<>();
		// 1의 친구의 친구들 set에 담기(여기엔 1도 들어감)
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < friendship[list.get(i)].size(); j++) {
				set.add(friendship[list.get(i)].get(j));
			}
		}
		// list의 값 set에 넣기
		set.addAll(list);
		if (set.size() == 0) { // set의 size가 0이면 1은 친구가 없다는 것 => 자기 자신도 set에 들어가지 못함
			System.out.println(set.size());
		} else { // set의 size가 0이 아니면 자기 자신도 무조건 포함됨 그러므로 1 빼서 출력
			System.out.println(set.size() - 1);
		}
	}
}
