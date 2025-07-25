import java.util.*;
import java.io.*;

public class Main {
	static class User implements Comparable<User>{
		int start, end, idx;
		public User (int start, int end) {
			this.start = start;
			this.end = end;
		}
		public User (User u, int idx) {
			this.start = u.start;
			this.end = u.end;
			this.idx = idx;
		}
		
		@Override
		public int compareTo (User u) {
			if (u.start != this.start) {
				return Integer.compare(this.start, u.start);
			}
			return Integer.compare(this.end, u.end);
		}
	}
	
	static int N;
	static int[] answer;
	static Queue<User> pq;
	static Queue<Integer> q;
	static List<User> list;
	public static void main (String[] args) throws Exception{
		init();
		solve();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		pq = new PriorityQueue<User>((o1, o2) -> o1.end - o2.end);
		q = new PriorityQueue<>();
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new User(s, e));
		}
		Collections.sort(list);
	}
	
	private static void solve() {
		// list에 시작시간 순으로 정렬되어있는 사용자들을 pq에 넣어준다.
		// answer[pq의 size]++ 를 해준다. -> 이게 아니라, 전체 컴퓨터 대수에서 pq에서 빠진 갯수를 뺴주면 되나? 
		// pq의 maxSize를 출력해준다

		int maxV = 0;

		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			
			while (!pq.isEmpty() && user.start >= pq.peek().end) {
				User u = pq.poll();
				q.add(u.idx);
			}
			
			User newUser;
			
			if (q.isEmpty()) {
				// q가 비어있으면 pq의 사이즈 번호를 가진 컴퓨터 사용
				newUser = new User(user, pq.size()); 
			} else {
				// q가 비어있지 않으면 가장 먼저 q에 들어온 컴퓨터를 사용
				newUser = new User(user, q.poll());
			}
			
			pq.add(newUser);
			
			answer[newUser.idx]++;
			maxV = Math.max(pq.size(),  maxV);
		}
		System.out.println(maxV);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxV; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}
