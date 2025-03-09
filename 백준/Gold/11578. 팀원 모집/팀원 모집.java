import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int answer;
    static List<Problem> problems;
    static int result;
    static boolean flag;

    private static class Problem {
        int mask;

        public Problem (int mask) {
            this.mask = mask;
        }
    }

    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 팀원 순회
         * 2. 모든 문제를 풀 수 있는 경우의 수를 갱신
         */
    }

    private static void solve() {
        calculate();
        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void calculate() {
        bitMasking(0, 0, 0);
    }

    private static void bitMasking(int idx, int prob, int cnt) {
        if (prob == answer) {
            result = Math.min(cnt, result);
            flag = true;
            return;
        }

        if (idx == problems.size()) return;

        bitMasking(idx + 1, prob, cnt);

        bitMasking(idx + 1, prob | problems.get(idx).mask, cnt + 1);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = (1 << n) - 1;
        result = m;

        problems = new ArrayList<>();
        
        flag = false;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int mask = 0;

            for (int j = 0; j < k; j++) {
                int problemNum = Integer.parseInt(st.nextToken()) - 1;
                mask |= (1 << problemNum);
            }
            problems.add(new Problem(mask));
        }
    }
}