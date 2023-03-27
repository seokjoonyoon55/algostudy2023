import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(nextP(arr)) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			System.out.println(sb.toString());
		} else System.out.println(-1);
	}

	private static boolean nextP(int[] p) {
		int n = p.length;
		
		int originIdx = n - 2;

		while(originIdx >= 0 && p[originIdx] >= p[originIdx + 1]) {
			--originIdx;
		}
		
		if(originIdx == -1) return false;
		
		int target = n - 1;
		while(p[target] <= p[originIdx]) target--;
		
		swap(p, originIdx, target);
		
		int back = n - 1;
		int idx = originIdx + 1;
		
		while(idx < back) {
			swap(p, idx++, back--);
		}
		
		return true;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}