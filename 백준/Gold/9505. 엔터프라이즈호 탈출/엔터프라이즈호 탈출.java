import java.util.*;
import java.io.*;

public class Main {
	static int T, K, W, H;
	static Map<Character, Integer> map;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int[][] board;
	static Queue<Node> pq;
	static StringBuilder sb;
	
	static class Node implements Comparable<Node>{
		int r, c, v;
		public Node (int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}
		@Override
		public int compareTo (Node n) {
			if (this.v != n.v) {
				return Integer.compare(this.v, n.v);
			}
			return Integer.compare(this.r, n.r);
		}
	}
	
	public static void main(String[] args) throws Exception{
		init();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			map = new HashMap<>();
			
			K = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			pq = new PriorityQueue<>();
			
			board = new int[H][W];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				Character key = st.nextToken().charAt(0);
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			}
			
			for (int j = 0; j < H; j++) {
				String input = br.readLine();
				for (int k = 0; k < input.length(); k++) {
					if (input.charAt(k) == 'E') {
						pq.add(new Node(j, k, 0));
					} else {
						board[j][k] = map.getOrDefault(input.charAt(k), 0);
					}
				}
			}
			
			dijk();
		}
		System.out.println(sb);
	}
	
	private static void dijk() {
		int[][] dist = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		Node start = pq.peek();
		dist[start.r][start.c] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.r == 0 || cur.c == 0 || cur.r == H - 1 || cur.c == W - 1) {
				sb.append(dist[cur.r][cur.c]).append("\n");
				return;
			}
			
			if (dist[cur.r][cur.c] < cur.v) continue;
			
			for (int i = 0; i < 4; i++) {
				int newR = cur.r + dr[i];
				int newC = cur.c + dc[i];
				
				if (0 > newR || 0 > newC || newR >= H || newC >= W) continue;
				
				if (dist[newR][newC] > dist[cur.r][cur.c] + board[newR][newC]) {
					dist[newR][newC] = dist[cur.r][cur.c] + board[newR][newC];
					pq.add(new Node(newR, newC, dist[cur.r][cur.c] + board[newR][newC]));
				}
			}
		}
	}
}
