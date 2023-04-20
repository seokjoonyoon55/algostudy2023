import java.util.PriorityQueue;

public class Prog_더맵게 {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		int cnt = 0;
		
		// 배열의 원소 중 K보다 작은 값과 그 외의 값을 각각 넣을 우선순위큐
		PriorityQueue<Integer> under = new PriorityQueue<>();
		PriorityQueue<Integer> over = new PriorityQueue<>();
		
		// 우선순위큐에 배열의 원소 넣는 반복문
		for (int i=0;i<scoville.length;i++) {
			int temp = scoville[i];
			
			if (temp < K) under.add(temp);
			else over.add(temp);
		}
		
		
		//༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ
		//＼(ﾟｰﾟ＼)( ﾉ ﾟｰﾟ)ﾉ＼(ﾟｰﾟ＼)( ﾉ ﾟｰﾟ)ﾉ＼(ﾟｰﾟ＼)( ﾉ ﾟｰﾟ)ﾉ＼(ﾟｰﾟ＼)( ﾉ ﾟｰﾟ)ﾉ
		//〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜〜(￣▽￣〜)(〜￣▽￣)〜
		//( ͡°( ͡° ͜ʖ( ͡° ͜ʖ ͡°)ʖ ͡°) ͡°)
		
		
		// under에 원소가 1개 이하로 남을 때까지 음식 섞기 반복
		while (under.size() > 1) {
			// 음식 섞어주고
			int sum = under.poll() + under.poll()*2;
			cnt++;
			// K보다 작으면 다시 under에
			// K보다 크거나 같으면 다시 over에
			if (sum < K) under.add(sum);
			else over.add(sum);
		}
		
		// under가 비어있다면 모든 원소가 K보다 커진 것이므로 그대로 출력
		if (under.isEmpty()) System.out.println(cnt);
		// under에 원소가 하나 남았는데 over에 원소가 없다면
		// 더 이상 섞을 수 없으므로 -1을 출력
		else if (over.isEmpty()) {
			cnt = -1;
			System.out.println(cnt);
		}
		// under에 원소가 하나, over에 원소가 있다면 한번만 더 섞으면 되기 때문에 
		// 1 더해서 출력
		else {
			cnt++;
			System.out.println(cnt);
		}		
	}
}
