import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node1238>[] arr;
    static ArrayList<Node1238>[] reverseArr;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int[] dist1 = dijk(arr);
        int[] dist2 = dijk(reverseArr);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(dist1[i]+dist2[i], answer);
        }
        System.out.println(answer);
    }

    private static int[] dijk(ArrayList<Node1238>[] arr) {
        PriorityQueue<Node1238> pq = new PriorityQueue<>();
        pq.offer(new Node1238(X, 0));

        int[] dist = new int[N+1];
        boolean[] check = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node1238 n = pq.poll();
            int cur = n.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node1238 node : arr[cur]) {
                    Node1238 next = node;

                    if (dist[cur] + node.weight < dist[next.end]) {
                        dist[next.end] = dist[cur] + node.weight;
                        pq.add(new Node1238(next.end, dist[next.end]));
                    }

                }
            }
        }
        return dist;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        reverseArr = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
            reverseArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            arr[S].add(new Node1238(E, T));
            reverseArr[E].add(new Node1238(S, T));
        }


    }
}

class Node1238 implements Comparable<Node1238> {
    int end, weight;
    public Node1238 (int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1238 n) {
        return Integer.compare(this.weight, n.weight);
    }
}