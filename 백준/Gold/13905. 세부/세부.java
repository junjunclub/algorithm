
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int start, end, v;
		
		public Node (int start, int end, int v) {
			this.start = start;
			this.end = end;
			this.v = v;
		}
		
		@Override
		public int compareTo (Node n) {
			if (this.v != n.v) return Integer.compare(n.v, this.v);
			return Integer.compare(this.end, n.end);
		}
	}
	
    static int N, M, s, e;
    static int[] parents;
    static Queue<Node> pq;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        kruskal();
    }
    
    private static void kruskal() {	
    	while (!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		union(cur.start, cur.end);
    		
    		if (find(s) == find(e)) {
    			System.out.println(cur.v);
    			return;
    		}
    	}
    	System.out.println(0);
    	return;
    }
    
    private static int find (int x) {
    	if (parents[x] == x) {
    		return x;
    	}
    	return parents[x] = find(parents[x]);
    }
    
    private static void union (int x, int y) {
    	int findX = find(x);
    	int findY = find(y);
    	
    	if (findX == findY) return;
    	
    	if (parents[findX] > parents[findY]) {
    		parents[findY] = parents[findX];
    	} else {
    		parents[findX] = parents[findY];
    	}
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        pq = new PriorityQueue<>();
        
        parents = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	parents[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Node n = new Node(start, end, v);
            pq.offer(n);
        }
    }
}
