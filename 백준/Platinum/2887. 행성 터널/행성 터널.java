import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;
    static List<Edge2887> edgeList;
    static Node2887[] nodes;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        Collections.sort(edgeList);

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (Edge2887 e : edgeList) {
            if (find(e.start) != find(e.end)) {
                union(e.start, e.end);
                answer += e.weight;
            }
        }
        System.out.println(answer);
    }

    private static void union(int start, int end) {
        int a = find(start);
        int b = find(end);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int start) {
        if (parent[start] == start) return start;
        return parent[start] = find(parent[start]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        nodes = new Node2887[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            nodes[i] = new Node2887(i, x, y, z);
        }
        edgeList = new ArrayList<>();

        Arrays.sort(nodes, Comparator.comparingInt(n -> n.x));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(nodes[i].x - nodes[i + 1].x);
            Edge2887 edge = new Edge2887(nodes[i].num, nodes[i + 1].num, cost);
            edgeList.add(edge);
        }

        Arrays.sort(nodes, Comparator.comparingInt(n -> n.y));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(nodes[i].y - nodes[i + 1].y);
            Edge2887 edge = new Edge2887(nodes[i].num, nodes[i + 1].num, cost);
            edgeList.add(edge);
        }

        Arrays.sort(nodes, Comparator.comparingInt(n -> n.z));
        for (int i = 0; i < N - 1; i++) {
            int cost = Math.abs(nodes[i].z - nodes[i + 1].z);
            Edge2887 edge = new Edge2887(nodes[i].num, nodes[i + 1].num, cost);
            edgeList.add(edge);
        }
    }
}

class Node2887 {
    int num, x, y, z;

    public Node2887 (int num, int x, int y, int z) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
class Edge2887 implements Comparable<Edge2887> {
    int start;
    int end;
    int weight;

    public Edge2887(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge2887 o) {
        return Integer.compare(this.weight, o.weight);
    }
}