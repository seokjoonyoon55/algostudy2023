import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon11866 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	
    	Queue<Integer> q = new LinkedList<>();
    	
    	// q에 1부터 N까지 숫자 입력
    	for(int i = 1; i <= N; i++) {
    		q.add(i);
    	}
    	System.out.print("<");
    	
    	// N이 1이 될때까지 수행
    	while(N-- > 0) {
    		for(int i = 0; i < K; i++) {
    			if(i == K - 1) { // K번째 숫자가 되었을 때
    				if(N == 0) System.out.print(q.poll()); // 마지막 숫자는 쉼표 없이 출력
    				else System.out.print(q.poll() + ", "); // 마지막 숫자가 아니라면 쉼표와 함께 출력
    			} else {
    				q.add(q.poll()); // K번째 숫자가 아니라면 숫자를 빼내서 q에 재추가
    			}
    		}
    	}
    	System.out.print(">");
    	
    }
}
