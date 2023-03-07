import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        int N = Integer.parseInt(br.readLine());
        int back = 0; // push로 받은 숫자중 마지막 숫자 변수
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            
            switch(s){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    q.add(x);
                    back = x;
                    break;
                    
                case "pop":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                    
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                    
                case "empty":
                    if(q.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                
                case "front":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                  
                case "back":
                    if(q.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(back).append("\n");
                    break;
                
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}