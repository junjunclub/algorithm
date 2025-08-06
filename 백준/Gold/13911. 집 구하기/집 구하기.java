import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int end, v;
		public Node (int end, int v) {
			this.end = end;
			this.v = v;
		}
		@Override
		public int compareTo (Node n) {
			if (this.v != n.v) {
				return Integer.compare(this.v, n.v);
			}
			return Integer.compare(this.end, n.end);
		}
	}
	
    static int V, E, x, y, mac, star;
    static int[] macDist;
    static int[] starDist;
    static List<Node>[] list;
    static List<Integer> macList = new ArrayList<>();
    static List<Integer> starList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new List[V + 1];
        
        for (int i = 1; i <= V; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	Node nodeA = new Node(e, w);
        	Node nodeB = new Node(s, w);
        	list[e].add(nodeB);
        	list[s].add(nodeA);
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	int m = Integer.parseInt(st.nextToken());
        	macList.add(m);
        }
        
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        
        y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
        	int s = Integer.parseInt(st.nextToken());
        	starList.add(s);
        }
        
    	macDist = new int[V + 1];
        starDist = new int[V + 1];
    }
    
    private static void solve() {

        
        Arrays.fill(macDist, Integer.MAX_VALUE);
        Arrays.fill(starDist, Integer.MAX_VALUE);
    	
        dijk(macDist, macList);
    	dijk(starDist, starList);
    	
    	long minV = Integer.MAX_VALUE;
    	
    	for (int i = 1; i <= V; i++) {
    		if (macDist[i] == 0 || starDist[i] == 0) continue;
    		
    		if (macDist[i] <= x && starDist[i] <= y) {
    			minV = Math.min(minV, macDist[i] + starDist[i]);	
    		}
    	}
    	
    	if (minV == Integer.MAX_VALUE) {
    		System.out.println(-1);
    	} else {
    		System.out.println(minV);
    	}
    }
    
    private static void dijk (int[] dist, List<Integer> storeList) {
    	Queue<Node> pq = new PriorityQueue<>();
    	
    	for (int i = 0; i < storeList.size(); i++) {
    		int start = storeList.get(i);
    		dist[start] = 0;
        	pq.offer(new Node(start, 0));
    		
    	}
    	
    	while (!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if (cur.v > dist[cur.end]) continue;
    		
    		for (Node next : list[cur.end]) {
    			if (dist[cur.end] + next.v < dist[next.end]) {
    				dist[next.end] = dist[cur.end] + next.v;
    				pq.add(new Node(next.end, dist[next.end]));
    			}
    		}
    	}
    }
}