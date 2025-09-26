import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        boolean sheep;
        long cnt;
        Info(boolean sheep, long cnt) {
            this.sheep = sheep;
            this.cnt = cnt;
        }
    }

    static List<Integer>[] graph;
    static Info[] curInfo;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        curInfo = new Info[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean sheep = st.nextToken().equals("S");
            long cnt = Long.parseLong(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            curInfo[i] = new Info(sheep, cnt);
            graph[parent].add(i);
        }

        curInfo[1] = new Info(true, 0);
        System.out.println(dfs(1));
    }

    private static long dfs(int cur) {
        long sum = 0;
        for (int next : graph[cur]) {
            sum += dfs(next);
        }

        if (curInfo[cur].sheep) {
            return sum + curInfo[cur].cnt;
        } else {
            return Math.max(0, sum - curInfo[cur].cnt);
        }
    }
}