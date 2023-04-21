import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//
		PriorityQueue<Integer> posi = new PriorityQueue<>();
		PriorityQueue<Integer> nega = new PriorityQueue<>();
		
//		StringBuilder sb = new StringBuilder();
		
		//
		for (int n=0;n<N;n++) {
			int x = Integer.parseInt(br.readLine());
			
			// x가 0보다 크면 posi에 추가
			// x가 0보다 작으면 nega에 절댓값 추가
			if (x>0) posi.add(x);
			else if (x<0) nega.add(Math.abs(x));
			// x가 0일 때
			else {
				// posi, nega 둘 다 비어있으면 0 출력
				if (posi.isEmpty() && nega.isEmpty()) {
					System.out.println(0);
				}
				// posi만 비어있으면
				else if (posi.isEmpty()) {
					System.out.println(nega.poll() * (-1));
				}
				// nega만 비어있으면
				else if (nega.isEmpty()) {
					System.out.println(posi.poll());
				}
				// posi,nega 둘 다 있을 때
				else {
					if (posi.peek() < nega.peek()) {
						System.out.println(posi.poll());
					}
					else {
						System.out.println(nega.poll() * (-1));
					}
				}
			}
		}
		
		br.close();
		
	}
}
