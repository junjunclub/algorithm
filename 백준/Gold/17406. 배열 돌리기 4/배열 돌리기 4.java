import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] board;
	static boolean[] visited;
	static int[] path;
	static int ans = Integer.MAX_VALUE;
	static List<Order> list = new ArrayList<>();
	
	static int N, M, K;
	static class Order {
		int r, c, s;
		public Order(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
	public static void main(String[] args) throws Exception{
		init();
		solve();
	}
	
	public static void solve() {
		visited = new boolean[K];
		path = new int[K];
		
		perm(0);
		
		System.out.println(ans);
	}
	
	public static void perm(int depth) {
		if (depth == K) {
			rollPerm(path);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				path[depth] = i;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void rollPerm (int[] arr) {
		int[][] copyBoard = copy(board);
		for (int i = 0; i < arr.length; i++) {
			Order o = list.get(arr[i]);
			roll(o, copyBoard);
		}
		
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < M; j++) {
				temp += copyBoard[i][j];
			}
			if (temp < ans) {
				ans = temp;
			}
		}
	}
	
	public static int[][] copy(int[][] arr) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			copy[i] = arr[i].clone();
		}
		return copy;
	}
	
	public static void roll (Order o, int[][] board) {
		int r = o.r;
		int c = o.c;
		int s = o.s;
		
		for (int size = 1; size <= s; size++) {
			int top = r - size;
			int bottom = r + size;
			int left = c - size;
			int right = c + size;
			
			int prev = board[top][left];
			
			for (int j = left + 1; j <= right; j++) {
				int tmp = board[top][j];
				board[top][j] = prev;
				prev = tmp;
			}
			
			for (int i = top + 1; i <= bottom; i++) {
				int tmp = board[i][right];
				board[i][right] = prev;
				prev = tmp;
			}
			
			for (int j = right - 1; j >= left; j--) {
				int tmp = board[bottom][j];
				board[bottom][j] = prev;
				prev = tmp;
			}
			
			for (int i = bottom - 1; i >= top; i--) {
				int tmp = board[i][left];
				board[i][left] = prev;
				prev = tmp;
			}
		}
	}
	
	public static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			Order o = new Order(r, c, s);
			list.add(o);
		}
	}
}
