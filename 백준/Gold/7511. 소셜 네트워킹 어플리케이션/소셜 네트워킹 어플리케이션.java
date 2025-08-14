
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, k, m;
    static StringBuilder sb = new StringBuilder();
    static int[] parents;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        System.out.println(sb);
    }
    
    private static void union(int x, int y) {
    	int fx = find(x);
    	int fy = find(y);
    	
    	if (fx == fy) return;
    	
    	if (fx > fy) {
    		parents[fx] = fy;
    	} else {
    		parents[fy] = fx;
    	}
    }
    
    private static int find(int x) {
    	if (parents[x] == x) {
    		return x;
    	}
    	return parents[x] = find(parents[x]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= T; i++) {
        	sb.append("Scenario "+i+":").append("\n");
        	n = Integer.parseInt(br.readLine());
        	k = Integer.parseInt(br.readLine());
        	
        	parents = new int[n + 1];
        	
        	for (int j = 0; j <= n; j++) {
        		parents[j] = j;
        	}
        	
        	for (int j = 0; j < k; j++) {
        		st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	
            	union(a, b);
        	}
        	
        	m = Integer.parseInt(br.readLine());
        	
        	for (int j = 0; j < m; j++) {
        		st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	
            	if (find(a) == find(b)) {
            		sb.append("1").append("\n");
            	} else {
            		sb.append("0").append("\n");
            	}
        	}
        	sb.append("\n");
        }
    }
}
