package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BAEK1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			// index와 중요도 삽입
			for (int j = 0; j < N; j++) {
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			
			// 3 1 2 4
			while(!q.isEmpty()) {
				// 맨 앞 index와 중요도 추출
				// 3
				int[] front = q.poll();
				boolean maxNum = true;
				
				for (int k = 0; k<q.size(); k++) {
					// 다음 인덱스들의 중요도보다 추출된 중요도가 작으면
					if(front[1]<q.get(k)[1]) {
						
						// 4 제외 나머지 다 뒤로 보냄
						q.offer(front);
						
						for(int x = 0; x<k; x++) {
							q.offer(q.poll());
						}
						
						maxNum = false;
						break;
					}
				}
				
				// 3이 가장 큰 수가 아니었으므로 반복
				if(maxNum == false) continue;
				
				// 가장 큰 수였을 때 count해주고 제거
				cnt++;
				
				// 인덱스가 같으면 stop
				if (front[0] == M) break;
			}
			
			sb.append(cnt).append('\n');
			
		}
		System.out.println(sb);
	}
}
