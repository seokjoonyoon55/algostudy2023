import java.util.Scanner;

public class BAEK10972 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[] arr = new int[N];
		
		// 입력값 배열 만들기
		for (int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		nextP(arr);
		
		sc.close();
	}
	
	public static void nextP(int[] arr) {
		int idx = N-1;
		
		while (idx>0 && arr[idx] < arr[idx-1]) idx--;
		
		if (idx==0) {
			System.out.println(-1);
			return;
		}
		
		// idx == 3
		// arr[idx-1] 와 그 뒤에 있는 값 중 arr[idx-1] 다음 값이랑 바꾸기
		int temp = arr[N-1];
		
		for (int i=N-2;i>=idx;i--) {
			if (arr[i] >= arr[idx-1]) {
				temp = arr[i];
			}
		}
		
		
	
		
	}
	
	
}
