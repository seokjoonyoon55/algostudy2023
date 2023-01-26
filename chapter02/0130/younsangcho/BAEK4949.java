package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEK4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String str = br.readLine();
			// . 입력하면 break
			if (str.equals(".")) break;
			
			// 추출할 문자열 선언 및 초기화
			String ext = "";
			
			// (, ), [, ] 만 추출해서 ext에 할당
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') ext = ext + str.charAt(i);
			}
			
			// ()를 포함하면 제거, []를 포함하면 제거, 두 경우 다 아닐 경우 break
			while (true) {
				if (ext.contains("()")) ext = ext.replace("()", "");
				else if (ext.contains("[]")) ext = ext.replace("[]", "");
				else break;
			}
			
			// ext 변수에 아무것도 안남아있으면 yes 출력, 남아있으면 no 출력
			if (ext.equals("")) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
