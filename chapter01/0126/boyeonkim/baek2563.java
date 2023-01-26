import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0; // 색종이 면적
        int[][] arr = new int[100][100]; // 도화지 면적
        
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            for(int j = x; j < x+10; j++){ // 가로세로 길이 10만큼 면적채우기
                for(int k = y; k < y+10; k++){
                    if(arr[j][k] == 1) continue; // 이미 면적이 채워져있다면 스킵
                    arr[j][k] = 1; // 색종이 면적 증가
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}