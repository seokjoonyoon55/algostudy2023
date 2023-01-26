package algorithm_Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEK10773 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K];
        int idx = 0; int sum = 0;
        
        for(int i = 0; i < K; i++) {
        	int e = Integer.parseInt(br.readLine());
        	// 0을 입력했을 때, 총합에서 배열의 마지막 값 차감 및 배열에서 마지막 값 0으로 reset
        	if (e == 0) {
        		sum -= arr[--idx];
        		arr[idx] = 0;
        	// 0 이외의 다른 값을 입력했을 때, 배열에 추가 및 총합에 덧셈
        	} else {
        		arr[idx] = e;
        		sum += arr[idx];
        		idx++;
        	}
        }
        System.out.println(sum);
	}
}
