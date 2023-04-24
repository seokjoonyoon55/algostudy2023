import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum, min, a, b;
		sum = 0;
		min = Integer.MAX_VALUE;
		a = 0;
		b = 0;
		
		
		for (int i=0;i<N;i++) {
			for (int j=N-1;j>i;j--) {
				sum = Math.abs(arr[i] + arr[j]);
				
				if (sum < min) {
					min = sum;
					a = arr[i];
					b = arr[j];
				}
				else if (sum > min) {
					break;
				}
			}
		}
		
//		System.out.println(sum);
//		System.out.println(a + " " + b);
		System.out.print(a + " " + b);
	}
}
