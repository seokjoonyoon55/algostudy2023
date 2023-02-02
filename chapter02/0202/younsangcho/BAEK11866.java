package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK11866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		for (int i = 1; i <= N; i++ ) {
			queue.add(i);
		}
		
		int num = 0;
		
		// N명의 사람이 모두 제거될 때까지 계속 반복
		while (queue.size() != 0) {
			num++;
			// K번째 사람일 떄 제거
			if (num % K == 0) {
				sb.append(queue.remove()+", ");
			} else queue.add(queue.poll());
		}
		
		// 맨 뒤에 있는 comma와 공백 제거한 후 > append
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
