package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEK9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
				
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			while (true) {
				// () 포함하면 제거
				if (str.contains("()")) str = str.replace("()", "");
				// () 포함하지 않으면 반복문 break
				else break;
			}
			
			// str에 아무것도 남아있지 않으면 YES, 남아있으면 NO 출력
			if (str.equals("")) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
