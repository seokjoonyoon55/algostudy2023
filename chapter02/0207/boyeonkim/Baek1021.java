// 메모리 초과 실패
import java.util.Scanner;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        
        LinkedList<Integer> list = new LinkedList<>(); // deque 안씀,,
        for(int i = 1; i <= N; i++){ // list에 숫자 하나씩 입력
            list.offer(i);
        }
        while(M-- > 0){
            int target = sc.nextInt();
            while(!list.isEmpty()){
                if(list.getFirst() == target){ // 해당하는 숫자라면
                    list.pollFirst();
                    break;
                }
                if(list.indexOf(target) <= list.size() / 2){ // 원하는 숫자가 리스트의 앞쪽에 있다면
                    list.offer(list.pollFirst()); // 앞에서부터 빼기
                } else {
                    list.offer(list.pollLast()); // 아니라면 뒤에서 빼기
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}