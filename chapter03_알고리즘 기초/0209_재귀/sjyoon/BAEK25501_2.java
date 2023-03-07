package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK25501_2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String S;	
				
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<T;i++) {
			S = br.readLine();
			int cnt = 0;
			int l = 0;
			int r = S.length()-1;
			
			while (true) {
				cnt++;
				if (l>=r) {
					sb.append("1 ").append(cnt+"\n");
					break;
				} else if (S.charAt(l)==S.charAt(r)) {
					l++;
					r--;
					continue;
				} else {
					sb.append("0 ").append(cnt+"\n");
					break;
				}
			}
		}
		
		br.close();
		System.out.println(sb);
	}
}
