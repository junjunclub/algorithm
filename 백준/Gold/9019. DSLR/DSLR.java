import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, num1, num2;
    static boolean[] visited;
    static StringBuilder sb;
    static Queue<Integer> q;
    static String[] answer;
    public static void main(String[] args) throws Exception{
        init();
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            answer = new String[10000];
            q = new LinkedList<>();
            q.add(num1);
            Arrays.fill(answer, "");
            visited[num1] = true;
            bfs();
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int n = q.poll();

            if (n == num2) {
                sb.append(answer[num2]).append("\n");
                return;
            }

            String temp = answer[n];

            int d = (2*n+10000)%10000;
            if (!visited[d]) {
                visited[d] = true;
                q.add(d);
                answer[d] = temp + "D";
            }

            int s = (n-1+10000)%10000;
            if (!visited[s]) {
                visited[s] = true;
                q.add(s);
                answer[s] = temp + "S";
            }

            int l = change1(n);
            if (!visited[l]) {
                visited[l] = true;
                q.add(l);
                answer[l] = temp + "L";
            }

            int r = change2(n);
            if (!visited[r]) {
                visited[r] = true;
                q.add(r);
                answer[r] = temp + "R";
            }
        }
    }

    private static int change2(int n) {
        int t = n % 10;
        n /= 10;
        n += t*1000;
        return n;
    }

    private static int change1(int n) {
        int t = n / 1000;
        n -= t*1000;
        n *= 10;
        n += t;
        return n;
    }
}
