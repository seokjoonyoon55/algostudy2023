import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            switch(str){
                case "push_front":
                    int m = Integer.parseInt(st.nextToken());
                    deque.offerFirst(m);
                    break;
                
                case "push_back":
                    int k = Integer.parseInt(st.nextToken());
                    deque.offerLast(k);
                    break;
                    
                case "pop_front":
                    if(deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.removeFirst()).append("\n");
                    break;
                    
                case "pop_back":
                    if(deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.removeLast()).append("\n");
                    break;
                    
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                    
                case "empty":
                    if(deque.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                    
                case "front":
                    if(deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                    
                case "back":
                    if(deque.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}