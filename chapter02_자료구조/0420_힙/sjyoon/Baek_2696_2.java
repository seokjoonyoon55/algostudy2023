import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Baek_2696_2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1;t<=T;t++) {
			// 수열의 크기
			int M = sc.nextInt();
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			StringBuilder sb = new StringBuilder();
			int N = (M+1) / 2;
			sb.append(N);
			
			for (int m=1;m<=M;m++) {
				pq.add(sc.nextInt());
				
				if (m % 2 == 1) {
					int[] temp = pq.stream().mapToInt(Integer::intValue).toArray();
					
					
					int midN = (int) temp[temp.length/2];
					
					if ((m-1)%10 == 0) {
						sb.append("\n" + midN + " ");
					}
					else {
						sb.append(midN + " ");
					}
				}
			}
			
			System.out.println(sb);
			
			
			
		}
	}
}
