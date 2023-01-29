package study0130;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek10828 {
	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bfr.readLine());
		Stack<Integer> st = new Stack<Integer>();
		String order;
		
		for (int tc = 0; tc < N; tc++) {
			
			order = bfr.readLine();
			if (order.contains("push")) {
				String[] data = order.split(" ");
				st.push(Integer.parseInt(data[1]));
			} else if (order.equals("pop")) {
				if (st.empty())
					bfw.write("-1\n");
				else
					bfw.write(String.valueOf(st.pop())+"\n");
			} else if (order.equals("size")) {
				bfw.write(String.valueOf(st.size())+"\n");
			} else if (order.equals("empty")) {
				if (st.empty())
					bfw.write("1\n");
				else
					bfw.write("0\n");
			} else if (order.equals("top")) {
				if (st.empty())
					bfw.write("-1\n");
				else
					bfw.write(String.valueOf(st.peek()+"\n"));
			}
		}
		bfw.flush();
		bfw.close();
	}
}

//public class Baek10828 {
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		Stack<Integer> st = new Stack<Integer>();
//
//		String order;
//		int data = 0;
//
//		for (int tc = 0; tc < N; tc++) {
//			order = sc.next();
//			if (order.equals("push")) {
//				data = sc.nextInt();
//				st.push(data);
//			} else if (order.equals("pop")) {
//				if (st.empty())
//					System.out.println("-1");
//				else
//					System.out.println(st.pop());
//			} else if (order.equals("size")) {
//				System.out.println(st.size());
//			} else if (order.equals("empty")) {
//				if (st.empty())
//					System.out.println("1");
//				else
//					System.out.println("0");
//			} else if (order.equals("top")) {
//				if (st.empty())
//					System.out.println("-1");
//				else
//					System.out.println(st.peek());
//			}
//		}
//	}
//}
