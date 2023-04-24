import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2470_2 {
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
			for (int j=i+1;j<N;j++) {
				sum = arr[i] + arr[j];
				
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					a = arr[i];
					b = arr[j];
				}
				else if (Math.abs(sum) > min) {
					break;
				}
			}
		}
		
//		System.out.println(min);
//		System.out.println(a + " " + b);
		
		System.out.print(Math.min(a, b) + " " + Math.max(a, b));
	}
}
