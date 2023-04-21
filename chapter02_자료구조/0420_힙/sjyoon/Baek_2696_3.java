import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek_2696_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1;t<=T;t++) {
			// 수열의 크기
			int M = Integer.parseInt(br.readLine());
			
			// 한 줄에 10개씩 입력되는거 고려한 코드
			String nums = "";
			
			for (int i=0;i<M/10+1;i++) {
				nums += br.readLine() + " ";
			}
			
			String[] arr = nums.split(" ");
			
			// 출력하는 중앙값
			StringBuilder sb = new StringBuilder();
			
			int N = (arr.length+1) / 2;
			sb.append(N);
			
			PriorityQueue<Integer> pq;
			
			
			for (int n=0;n<N;n++) {
				
				pq = new PriorityQueue<>();
				
				for (int i=0;i<n*2+1;i++) {
//					System.out.println(arr[i]);
					pq.add(Integer.parseInt(arr[i]));
				}
				
				int[] temp = new int[pq.size()];
				
				for (int i=0;i<pq.size();i++) {
					temp[i] = pq.poll();
				}
				
				
				
				
//				System.out.println(Arrays.toString(temp));
				
				int midN = (int) temp[temp.length/2];
				
				if (n%10 == 0) {
					sb.append("\n" + midN + " ");
				}
				else {
					sb.append(midN + " ");
				}
			}
			
			System.out.println(sb);
			
		}
	}
}
