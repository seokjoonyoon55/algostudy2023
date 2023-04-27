import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_16938 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		int X = sc.nextInt();
		
		sc.nextLine();
		st = new StringTokenizer(sc.nextLine());
		int[] arr = new int[N];
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜
		
		
		int cnt = 0;	// 문제 조합의 경우의 수
		
		// N+1자리의 이진수 구하기
		for (int i=1<<N;i<(int)Math.pow(2, N+1);i++) {
			String bin = Integer.toBinaryString(i);
			System.out.println(bin);
			
			// 해당 이진수에 1의 개수가 문제의 개수를 의미하기 때문에 두 문제 미만 거르기
			if (Integer.bitCount(i) < 3) {
				System.out.println("두 문제 미만");
				continue;
			}
			
			int sum = 0;					// 난이도 합
			int max = Integer.MIN_VALUE;	// 최고 난이도
			int min = Integer.MAX_VALUE;	// 최저 난이도
			
			// 이진수에서 1인 자리의 문제를 고르기(?)
			for (int j=1;j<=N;j++) {
				if (bin.charAt(j) == '1') {
					int temp = arr[j-1];
					System.out.println(temp + " 추가");
					sum += temp;
					// 최대최소 갱신
					if (temp>max) max = temp;
					if (temp<min) min = temp;
				}
			}
			
			System.out.println("최소값 : " + min + " 최대값 : " + max);
			
			// 조건에 만족하면 경우의 수 증가
			if ((sum>=L) && (sum<=R) && ((max-min)>=X)) {
				System.out.println("***조건 만족***");
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
	}
}
