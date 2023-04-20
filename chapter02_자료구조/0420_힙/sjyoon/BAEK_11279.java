import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BAEK_11279 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int n=0;n<N;n++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) {
				if (q.isEmpty()) System.out.println(0);
				else {
					System.out.println(q.poll());
				}
			}
			else {
				q.add(x);
			}
		}

		br.close();
		
	}
}
