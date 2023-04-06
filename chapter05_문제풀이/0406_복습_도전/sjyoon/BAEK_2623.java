import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_2623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 가수 수
		int M = sc.nextInt();	// 보조PD 수
		
		Queue<Integer>[] arr = new LinkedList[M];
		
		// 배열에 입력값 저장
		for (int m=0;m<M;m++) {
			arr[m] = new LinkedList<>();
			
			for (int i=0;i<sc.nextInt();i++) {
				arr[m].add(sc.nextInt());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			for (int i=0;i<M;i++) {
				int temp = arr[M].poll();
				
				
				sb.append(temp+" ");
			}
		}
		
	}
}
