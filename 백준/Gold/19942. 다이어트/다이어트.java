import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Ingredient {
        int p, f, s, v, c;
        public Ingredient (int p, int f, int s, int v, int c) {
            this.p = p; this.f = f; this.s = s; this.v = v; this.c = c;
        }
    }

    static int N;
    static int mp, mf, ms, mv;
    static List<Ingredient> list;
    static boolean[] visited;

    static int minCost = Integer.MAX_VALUE;
    static List<Integer> bestComb = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        init();
        dfs(0);
        printResult();
    }

    private static void dfs(int idx) {
        if (idx == N) {
            int tp = 0, tf = 0, ts = 0, tv = 0, tc = 0;
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    Ingredient in = list.get(i);
                    tp += in.p;
                    tf += in.f;
                    ts += in.s;
                    tv += in.v;
                    tc += in.c;
                    current.add(i + 1); // 재료 번호 (1-based index)
                }
            }

            if (tp >= mp && tf >= mf && ts >= ms && tv >= mv) {
                if (tc < minCost) {
                    minCost = tc;
                    bestComb = new ArrayList<>(current);
                } else if (tc == minCost) {
                    if (isSmall(current, bestComb)) {
                        bestComb = new ArrayList<>(current);
                    }
                }
            }
            return;
        }
        
        visited[idx] = true;
        dfs(idx + 1);

        visited[idx] = false;
        dfs(idx + 1);
    }

    private static boolean isSmall(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) return a.get(i) < b.get(i);
        }
        return a.size() < b.size();
    }

    private static void printResult() {
        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(minCost);
        for (int i = 0; i < bestComb.size(); i++) {
            System.out.print(bestComb.get(i) + (i == bestComb.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Ingredient(p, f, s, v, c));
        }
    }
}