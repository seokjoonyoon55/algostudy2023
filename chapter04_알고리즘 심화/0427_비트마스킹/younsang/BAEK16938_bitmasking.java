package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK16938_bitmasking {
	static int N, L, R, X, ans;
	static int[] arr;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        
        bitmasking();
        
        System.out.println(ans);
    }
    
    public static void bitmasking() {
    	for (int i = 1; i < (1 << N); i++) {
    		// 1의 개수를 세기 위해 Integer.bitCount() 메소드 사용
    		// 1이면 사용했다는 뜻 0이면 사용안했음
    		// 110이면 1,2번째 사용했다는 뜻임.
            if (Integer.bitCount(i) < 2) { // 문제를 2개 이상 풀어야 함
                continue;
            }
            // 선택한 문제의 난이도의 합
            int t = 0;
            // 선택한 문제를 이진수로 표현한 것을 합친 값
            // 최솟값
            int min = Integer.MAX_VALUE;
            // 최댓값
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
            	// 해당 자리에 대한 인덱스 값임 (j가)
            	// 만약에 110이면 110과 100을 & 한 값이 0이 아니므로
            	// idx 2 사용 했다는 뜻..
            	if ((i & (1 << j)) != 0) {
                    t += arr[j];
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                }
            }
            if (t >= L && t <= R && max - min >= X) {
                ans++;
            }
        }
    }
}