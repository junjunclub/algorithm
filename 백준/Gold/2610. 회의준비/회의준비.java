import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static StringBuilder sb = new StringBuilder();
    static int[] parents;
    static int[][] board;
    static final int INF = 123456789;
    static String[] input;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
    	
    	for (int k = 1; k <= N; k++) {
    		for (int i = 1; i <= N; i++) {
    			for (int j = 1; j <= N; j++) {
    				if (board[i][j] > board[i][k] + board[k][j]) {
    					board[i][j] = board[i][k] + board[k][j];
    				}
    			}
    		}
    	}
    	
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for (int i = 1; i <= N; i++) {
    		int findi = find(i);
    		map.computeIfAbsent(findi, k -> new ArrayList<>()).add(i);
    	}
    	
    	List<Integer> list = new ArrayList<>();
    	for (List<Integer> nodes : map.values()) {
    		int repNode = -1;
    		int repV = INF;
    		
    		for (int i : nodes) {
    			int v = 0;
    			for (int j : nodes) {
    				v = Math.max(v, board[i][j]);
    			}
    			
    			if (v < repV || (repV == v && i < repNode)) {
    				repNode = i;
    				repV = v;
    			}
    		}
    		list.add(repNode);
    	} 
    	
    	Collections.sort(list);
    	
    	sb.append(list.size()).append("\n");
    	
    	for (int i = 0; i < list.size(); i++) {
    		sb.append(list.get(i)).append("\n");
    	}
    	
    	System.out.println(sb);
    	
    }
    
    private static void union(int x, int y) {
    	int findx = find(x);
    	int findy = find(y);
    	
    	if (findx == findy) return;

    	if (findx < findy) {
    		parents[findy] = findx;
    	} else {
    		parents[findx] = findy;
    	}
    }
    
    private static int find(int x) {
    	if (parents[x] == x) {
    		return parents[x];
    	}
    	return parents[x] = find(parents[x]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        parents = new int[N + 1];
        board = new int[N + 1][N + 1];
        
        for (int i = 0; i <= N; i++) {
        	parents[i] = i;
        	Arrays.fill(board[i], INF);
        	board[i][i] = 0;
        }
        
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());

        	board[a][b] = 1;
        	board[b][a] = 1;
        	union(a, b);
        }
    }
}
