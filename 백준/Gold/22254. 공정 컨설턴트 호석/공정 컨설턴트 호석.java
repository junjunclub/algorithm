import java.util.*;
import java.io.*;

public class Main {
	static int N, X, ans;
	static int[] arr;
	
	static class Machine implements Comparable<Machine>{
		int id, time;
		
		public Machine (int id, int time) {
			this.id = id;
			this.time = time;
		}
		
		@Override
		public int compareTo (Machine m) {
			if (this.time != m.time) {
				return Integer.compare(this.time, m.time);
			}
			return Integer.compare(this.id, m.id);
		}
	}
	
	public static void main (String[] args) throws Exception{
		init();
		solve();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void solve() {
		Queue<Machine> pq = new PriorityQueue<>();
		
		int left = 1;
		int right = N;
		int mid;
		
		while (left <= right) {
			boolean flag = true;
			
			pq.clear();
			
			mid = (left + right) / 2;
			
			int idx = 0;
			
			// mid만큼 기계를 pq에 넣어주기
			for (; idx < mid; idx++) {
				pq.add(new Machine(idx, arr[idx]));
			}
			
			for (int i = mid; i < N; i++) {
				Machine cur = pq.poll();
				cur.time += arr[i];
				if (cur.time > X) {
					flag = false;
					break;
				}
				pq.add(cur);
			}
			
			if (flag) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(ans);
	}
}
