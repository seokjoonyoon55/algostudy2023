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
			//push 입력 들어오면
			if (order.contains("push")) {
				//쪼개서 숫자부분을 스택 push 수행
				String[] data = order.split(" ");
				st.push(Integer.parseInt(data[1]));
			}
			//pop 입력 들어오면
			else if (order.equals("pop")) {
				//비어있으면 -1 출력, 안비어있으면 스택 pop 수행
				if (st.empty())
					bfw.write("-1\n");
				else
					bfw.write(String.valueOf(st.pop())+"\n");
			}
			//size 입력 들어오면
			else if (order.equals("size")) {
				//스택 size 수행 해서 출력
				bfw.write(String.valueOf(st.size())+"\n");
			}
			//empty 입력 들어오면
			else if (order.equals("empty")) {
				//비어있으면 1, 안비어있으면 0 출력
				if (st.empty())
					bfw.write("1\n");
				else
					bfw.write("0\n");
			}
			//top 입력 들어오면
			else if (order.equals("top")) {
				//비어있으면 -1, 안비어있으면 맨 위꺼 스택 peek 수행해서 출력
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

//스캐너 시간초과 난 코드

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
