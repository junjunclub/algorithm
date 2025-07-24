import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static final int INF = 1_000_000_000;
	static int[][] board, answer;
	public static void main(String[] args) throws Exception {
		init();
		solve();
	}
	
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N + 1][N + 1];
		answer = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					board[i][j] = 0;
				} else {
					board[i][j] = INF;					
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			board[s][e] = Math.min(w, board[s][e]);
			board[e][s] = Math.min(w, board[e][s]);
			answer[s][e] = e;
			answer[e][s] = s;
		}
	}
	
	private static void solve() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						answer[i][j] = answer[i][k];
						board[i][j] = board[i][k]+board[k][j];						
					}
				}
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(board[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					sb.append("-").append(" ");
				} else {
					sb.append(answer[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}