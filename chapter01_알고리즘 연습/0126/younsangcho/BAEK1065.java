package algorithm_Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        
        int result = 0;
        // 100미만 숫자는 한수의 개수가 N과 같음
        if (N < 100) {
        	result = N;
        // 1000일 때 (4자리 숫자일 때)
        } else if (N == 1000) {
        	result = 144;
        // (101 ~ 1000일 때)
        } else {
        	// 기본적으로 한수가 99개
        	result = 99;
        	// 100의 자리 숫자 추출
        	int hund = Character.getNumericValue(str.charAt(0));
        	
        	for (int j = 1; j <= hund; j++) {
        		// 100의 자리, 10의 자리, 1의 자리가 다 같을 때 (ex. 222)
        		if (j*100+j*10+j <= N) result++;
        		
        		// 위의 경우 보다 작을 때 (ex. 210)
        		for (int i = 1; j - 2*i >= 0; i++) {
        			if ( (j*100)+((j-i)*10)+(j-2*i) <= N ) result++;
        		}
        		// 위의 경우보다 클 때 (ex. 234, 246, 258)
        		for (int i = 1; j + 2*i < 10; i++) {
        			if ( (j*100)+((j+i)*10)+(j+2*i) <= N ) result++;
        		}
        	}
        }
        System.out.println(result);
    }


}
