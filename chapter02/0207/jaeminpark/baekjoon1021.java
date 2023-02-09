package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		int pollCnt = 0;
		int num;
		st = new StringTokenizer(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		Deque<Integer> pick = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			dq.offer(i);
			list.add(i);
		}
		for (int i = 0; i < cnt; i++) {
			pick.offer(Integer.parseInt(st.nextToken()));
		}
		pollCnt = 0;
//		System.out.println(dq);
		int max = dq.peekLast();

		while (!pick.isEmpty()) {
			num = pick.peekFirst();
//			System.out.println(num);
//			System.out.println("dq: " + dq);
//			System.out.println("list: " + list);
//			System.out.println("pick: " + pick);
			if (num == dq.peekFirst()) {
				pick.remove();
				dq.remove();
				list.remove(0);
			} else {
				if(list.indexOf(num) > list.size()/2) {
					dq.addFirst(dq.removeLast());
					list.add(0, list.get(list.size()-1));
					list.remove(list.size()-1);
					pollCnt++;
				} else {
					dq.addLast(dq.removeFirst());
					list.add(list.get(0));
					list.remove(0);
					pollCnt++;
				}
				
			}
//			System.out.println("=========");
		}
		System.out.println(pollCnt);
	}

}
