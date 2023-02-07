package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> num = new LinkedList<>();
		String order;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			if(order.equals("push_back")) {
				num.addLast(Integer.parseInt(st.nextToken()));
			} else if(order.equals("push_front")) {
				num.addFirst(Integer.parseInt(st.nextToken()));
			} else if(order.equals("pop_front")) {
				if(num.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(num.pollFirst()).append("\n");
				}
			} else if(order.equals("pop_back")) {
				if(num.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(num.pollLast()).append("\n");
				}
			} else if(order.equals("size")) {
				sb.append(num.size()).append("\n");
			} else if(order.equals("empty")) {
				if(num.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if(order.equals("front")) {
				if(num.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(num.peekFirst()).append("\n");
				}
			} else if(order.equals("back")) {
				if(num.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(num.peekLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
