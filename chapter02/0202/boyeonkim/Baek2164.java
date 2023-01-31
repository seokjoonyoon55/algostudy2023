import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= N; i++){ // q에 숫자 입력
            q.add(i);
        }
        while(q.size() > 1){ // 숫자 한개가 남을때까지 반복
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek()); // 남은 숫자 출력
        sc.close();
    }
}