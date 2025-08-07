import java.util.*;
import java.io.*;

public class Main {
    static int N, M, groupId, ans;
    static char[][] board;
    static int[][] visited;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         * 1. 싸이클을 만든다.
         * 2. count를 1 늘려준다.
         */
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        visited = new int[N][M];
        
        groupId = 0;
        ans = 0;
        
        for (int i = 0; i < N; i++) {
        	board[i] = br.readLine().toCharArray();
        }
    }
    
    private static void dfs(int nr, int nc) {
    	visited[nr][nc] = groupId;
    	
    	int i = 0;
    	
    	switch (board[nr][nc]) {
    	case 'S':
    		i = 0;
    		break;
    	case 'E':
    		i = 1;
    		break;
    	case 'W':
    		i = 2;
    		break;
    	case 'N':
    		i = 3;
    		break;
    	}
    	
    	int newR = nr + dr[i];
    	int newC = nc + dc[i];
    	
    	if (visited[newR][newC] == 0) {
    		dfs(newR, newC);
    	} else if (visited[newR][newC] == groupId){
    		ans++;
    	}
    }

    private static void solve() {
    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (visited[i][j] == 0) {
        			groupId++;
        			dfs(i, j);
        		}
        	}
        }
    	
    	System.out.println(ans);
    }
}