import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_23630 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/////////////////////////////////////////////////////
		// 입력받고 배열에 저장 ////////////////////////////////////
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		/////////////////////////////////////////////////////
		
		
//		for (int i=(int) Math.pow(2, N-1) ; i<1<<N ; i++) {
//			System.out.println(Integer.toBinaryString(i));
//		}
		
		// N+1자리 이진수 큰 수부터 구하기
		for (int i=(1<<N+1)-1 ; i>=(int) Math.pow(2, N) ; i--) {
			// N+1자리 이진수
			String temp = Integer.toBinaryString(i);
			System.out.println(temp);
			int val = 0;	// 비트연산 계산값
			int cnt = 0;	// 수열의 길이
			
			// 제일 왼쪽의 1은 무시하기 위해 j의 시작점은 1
			for (int j=1;j<=N;j++) {
				// N자리 이진수에서 1이 나오면, 배열에서 그 인덱스에 해당하는 숫자 선택
				if (temp.charAt(j) == '1') {
					System.out.println(arr[j-1]);
					if (cnt == 0) {
						val = arr[j-1];
						cnt++;
					}
					else {
						val = val & arr[j-1];
						cnt++;
					}
				}
			}
			System.out.println(val);

			
			// 비트연산 결과가 0이 아니면 종료
			if (val != 0) {
				System.out.println(cnt);
				return;
			}
			
		}

	}
}
