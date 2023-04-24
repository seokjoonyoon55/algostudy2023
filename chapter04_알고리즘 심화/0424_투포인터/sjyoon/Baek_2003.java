import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		////// 입력값 N,M,배열에 저장하기 ////////////////
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		/////////////////////////////////////////
		
		
		// sum은 수열에서 연속된 원소들의 합
		// cnt는 sum이 M이 되는 경우의 수
		int sum, cnt;
		cnt = 0; 
		
		// i는 연속된 원소들의 시작 인덱스
		// j는  끝 인덱스
		for (int i=0;i<N;i++) {
			// sum 초기화
			sum = 0;	
			
			for (int j=i;j<N;j++) {
				// sum에 원소를 쭉 더해주다가
				sum += arr[j];
				
				// sum이 M보다 커지면 시작 인덱스를 한칸 이동
				if (sum > M) break;
				// sum이 M과 같아지면 cnt를 더해주고 시작 인덱스를 한칸 이동
				else if (sum == M) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
