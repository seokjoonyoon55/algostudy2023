// 간단한 369게임
// D2
import java.util.*;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            String str = Integer.toString(test_case);
            if (str.contains("3") == true || str.contains("6") == true || str.contains("9") == true) {
                int cnt = 0;
                String hyp = "-";
                StringBuilder sb = new StringBuilder();
                cnt += str.length() - str.replace(String.valueOf("3"), "").length();
                cnt += str.length() - str.replace(String.valueOf("6"), "").length();
                cnt += str.length() - str.replace(String.valueOf("9"), "").length();
                for(int i = 0; i < cnt; i++) {
                    sb.append(hyp);
                }
                System.out.printf("%s ", sb);
            } else System.out.printf("%d ", test_case);
        }
    }
}
