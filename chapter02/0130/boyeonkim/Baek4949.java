package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray(); // 괄호를 배열에 저장
            int cnt = 0; // 괄호의 갯수를 담을 변수
            for(char c : arr){
            	if(cnt >= 0) { // 0 이상일 경우만 cnt 계산 진행
            		if(c == '(') cnt++; //
                   		else if(c == ')') cnt--;
            	} else break; // 앞에 '('보다 ')'가 더 많을 경우엔 cnt 음수가 됨. 음수라면 진행 x
            }
            if(cnt == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
	}
}