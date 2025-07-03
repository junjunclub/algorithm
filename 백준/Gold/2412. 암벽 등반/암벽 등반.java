import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int n, T;
    static Queue<Node2412> q;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new List[T + 1];

        for (int i = 0; i <= T; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[c].add(r);
        }

        for (int i = 0; i <= T; i++) {
            Collections.sort(list[i]);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node2412> q = new LinkedList<>();
        q.add(new Node2412(0, 0));

        int cnt = 0;                       // 지금까지 점프한 횟수
        while (!q.isEmpty()) {
            int size = q.size();           // 현재 레벨에 있는 노드 수
            for (int s = 0; s < size; s++) {
                Node2412 node = q.poll();
                int nowR = node.r;
                int nowC = node.c;

                if (nowC == T) return cnt; // 이 레벨 그대로가 정답

                for (int i = nowC - 2; i <= nowC + 2; i++) {
                    if (i < 0 || i > T) continue;
                    for (int j = 0; j < list[i].size(); ) {
                        int nx = list[i].get(j);
                        if (nowR - 2 > nx) { j++; continue; }  // 너무 왼쪽이면 pass
                        if (nowR + 2 < nx) break;

                        q.add(new Node2412(nx, i));
                        list[i].remove(j);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}

class Node2412 {
    int r, c;
    public Node2412 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}