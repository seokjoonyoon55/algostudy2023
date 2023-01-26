package baekjoon_02_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> numStack = new Stack<>();
		String order;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			order = st.nextToken();
			
			if (order.equals("push")) {
				numStack.push(Integer.parseInt(st.nextToken()));
			} else if (order.equals("pop")) {
				if (numStack.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(numStack.pop()).append("\n");
				}
			} else if (order.equals("size")) {
				sb.append(numStack.size()).append("\n");
			} else if (order.equals("empty")) {
				if (numStack.empty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (order.equals("top")) {
				if (numStack.size() == 0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(numStack.get(numStack.size()-1)).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
