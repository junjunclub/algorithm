import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n, m, k;
    static ArrayList<Node17835>[] list;
    static List<Integer> meetingLocation;
    static int answerLocation = 0;
    static long answerDistance = 0;

    public static void main(String[] args) throws IOException {

        init();
        /**
         * 1. 인접 리스트로 목적지와 거리 넣어주기
         * 2. 다익스트라 돌리기
         * 3. 면접장이 아닌 경우에서 최댓값, 최대거리 출력
         *
         * 힌트 : 역방향으로 탐색을 해야한다....
         * long으로....
         */

        dijk(meetingLocation);

        System.out.println(answerLocation);
        System.out.println(answerDistance);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        meetingLocation = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[v].add(new Node17835(u, c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            meetingLocation.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void dijk(List<Integer> meetingList) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node17835> pq = new PriorityQueue<>();

        for (int start : meetingList) {
            pq.offer(new Node17835(start, 0));
            dist[start] = 0;
        }

        while (!pq.isEmpty()) {
            Node17835 n = pq.poll();
            int curLoc = n.end;
            long curWeight = n.weight;

            if (dist[curLoc] < curWeight) continue;

            for (Node17835 newNode : list[curLoc]) {
                int newNodeLoc = newNode.end;
                long newNodeDist = newNode.weight + curWeight;

                if (dist[newNodeLoc] > newNodeDist) {
                    pq.offer(new Node17835(newNodeLoc, newNodeDist));
                    dist[newNodeLoc] = newNodeDist;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] != 0 && dist[i] != Long.MAX_VALUE && answerDistance < dist[i]) {
                answerDistance = dist[i];
                answerLocation = i;
            }
        }
    }
}

class Node17835 implements Comparable<Node17835>{
    int end;
    long weight;
    public Node17835 (int end, long weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo (Node17835 n) {
        return Long.compare(this.weight, n.weight);
    }
}