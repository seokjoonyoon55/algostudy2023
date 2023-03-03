package study0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(bfr.readLine());//명령 갯수
		Queue<Integer> quu = new LinkedList<>();//숫자 저장할 큐

		String order;//명령 저장할 변수
		int recent=-2;//push 할 정수 저장. 

		for (int tc = 0; tc < N; tc++) {
			order = bfr.readLine();

			//push면 order 쪼개서 정수 부분 큐에 넣기. 이때 recent에도 정수 저장
			if (order.contains("push")) {
				String[] data = order.split(" ");
				quu.add(recent=Integer.parseInt(data[1]));
			}
			//pop 큐 비어있으면 -1, 차있으면 꺼내고 꺼낸거 sb에 보내기
			else if (order.equals("pop")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(String.valueOf(quu.poll()) + "\n");
			}
			//size 리턴
			else if (order.equals("size")) {
				sb.append(quu.size() + "\n");
			}
			//empty 비어있으면 1, 차있으면 0
			else if (order.equals("empty")) {
				if (quu.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			//front 비어있으면 -1, 차있으면 맨앞 수 peek
			else if (order.equals("front")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(quu.peek()+"\n");
			}
			//back 비어있으면 -1, 차있으면 recent
			//pop은 무조건 맨 앞에서 꺼내고, push는 뒤로만 들어가기 때문에 가장 최근 넣은 recent가 제일 뒤 숫자가 됨
			else if (order.equals("back")) {
				if (quu.isEmpty())
					sb.append("-1\n");
				else
					sb.append(recent+"\n");
			} 
		}
		System.out.println(sb);
	}
}
