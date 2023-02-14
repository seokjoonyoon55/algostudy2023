class Solution {
    public int solution(int n, int k) {
        int answer = (12000 * n) + (2000 * k);
        if(n > 9){
            int service = n / 10;
            service = service * 2000;
            answer = answer - service;
        }
        return answer;
    }
}