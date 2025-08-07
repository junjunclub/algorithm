import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int[][] board;
	static int[][] dp;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	public static void main (String[] args) throws Exception{
		init();
		solve();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void solve() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}
		System.out.println(ans);
	}
	
	private static int dfs(int r, int c) {
		if (dp[r][c] != 0) return dp[r][c];
		
		dp[r][c] = 1;
		
		for (int i = 0; i < 4; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			
			if (0 > newR || 0 > newC || N <= newR || N <= newC) continue;
			
			if (board[r][c] < board[newR][newC]) {
				dp[r][c] = Math.max(dp[r][c], dfs(newR, newC) + 1);
			}
		}
		return dp[r][c];
	}
}
