import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
	// 우선순위 큐에 스코빌 배열 원소 넣어주기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
	// 오름차순 정렬 기준 가장 앞에있는 값이 K보다 크다면 0 출력
        if(pq.peek() >= K) return 0;
        // K를 만들수 있는지 없는지 판단할 변수
        boolean flag = true;
		// pq에 원소가 2개 이상일 때만 진행
		while(pq.size() > 1) {
			answer++;
            int a = pq.remove();
			int b = pq.remove() * 2;
			pq.add(a + b);
            
			if(pq.peek() >= K) {
                flag = false;
                break;
            }
		}
        if(!flag) return answer;
        else return -1;
    }
}