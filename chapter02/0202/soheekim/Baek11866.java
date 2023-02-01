package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(bfr.readLine());
		Queue<Integer> quu = new LinkedList<>();

		String order;
		int recent=-2;

		for (int tc = 0; tc < N; tc++) {
			order = bfr.readLine();

			if (order.contains("push")) {
				String[] data = order.split(" ");
				quu.add(recent=Integer.parseInt(data[1]));//구분 안해도 되나?
			} else if (order.equals("pop")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(String.valueOf(quu.poll()) + "\n");
			} else if (order.equals("size")) {
				sb.append(quu.size() + "\n");
			} else if (order.equals("empty")) {
				if (quu.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if (order.equals("front")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(quu.peek()+"\n");
			} else if (order.equals("back")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(recent+"\n");
			} 
		}
		System.out.println(sb);
	}
}
