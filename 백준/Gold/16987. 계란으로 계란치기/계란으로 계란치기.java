import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int idx, int cnt) {
        // 종료 조건 : idx가 N일 때
        if (idx == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        Egg origin = eggs.get(idx);

        if (origin.v <= 0) {
            backtracking(idx+1, cnt);
            return;
        }

        boolean isAttacked = false;

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;

            Egg egg = eggs.get(i);

            if (egg.v <= 0) continue;

            isAttacked = true;

            origin.v -= egg.weight;
            egg.v -= origin.weight;

            int brokenCnt = 0;
            if (origin.v <= 0) brokenCnt++;
            if (egg.v <= 0) brokenCnt++;

            backtracking(idx+1, cnt+brokenCnt);

            origin.v += egg.weight;
            egg.v += origin.weight;
        }

        if (!isAttacked) {
            backtracking(idx+1, cnt);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(v, weight));
        }
    }
}

class Egg {
    int v, weight;
    public Egg (int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}