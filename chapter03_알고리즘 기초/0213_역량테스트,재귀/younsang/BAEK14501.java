package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK14501 {
	// 상담 완료하는데 걸리는 시간을 담을 배열 선언
	static int t[];
	// 받을 수 있는 금액을 담을 배열 선언
	static int p[];
	
	// 일 수 변수 선언
	static int N;
	
	// 최대 이익 변수 선언 및 초기화
	// 0보다 작은 정수 아무거나 상관 X
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 각 배열의 길이 설정
		t = new int[N];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0);
		
		System.out.println(result);
	}
	
	static void func(int idx, int sum) {
		
		if (idx == N) {
			result = (result < sum) ? sum : result;
			return;
		}
		
		// N + x 일 째가 되는 날이므로 return
		if (idx > N) return;
		
		// 예제로 설명해보면 1일에는 3일동안 상담을 하게 되는데,
		// 그럼 4일째에 다시 상담을 할 수 있으므로
		// 4일째로 넘어가고, 첫 날에 상담 금액인 10을 sum 매개변수에 더해서 인자로 전달한다. 
		func(idx + t[idx], sum + p[idx]); 
		
		// 만약 1일째에 상담을 하는 것이 최대 수익이 아닐 경우
		// +1일로 넘어간다.
		// result 값을 static을 사용해 클래스 변수로 설정했기 때문에
		// 맨 위의 조건문에서 모든 경우의 수를 비교할 수 있다.
		func(idx+1, sum);
	}
}
