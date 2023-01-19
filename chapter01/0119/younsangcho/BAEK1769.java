package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK1769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
		String str = br.readLine();
        int cnt = 0;
        String answer;
        // 한 자리가 될 때까지 반복
        while (str.length() != 1) {
        	int sum = 0;
        	// 각 자리 수 합산
	        for (int i = 0; i < str.length(); i++) {
	        	sum += Character.getNumericValue(str.charAt(i));
	        }
	        // 합산된 문자열
	        str = Integer.toString(sum);
	        cnt++;
        }
        System.out.println(cnt);
        // 3의 배수이면 YES, 아니면 NO 출력
        answer = (Integer.parseInt(str) % 3 == 0) ? "YES" : "NO";
        System.out.print(answer);
    }
}
