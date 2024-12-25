import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static StringTokenizer st;
    static int[] list;
    static int[] path;
    static int n, k, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new int[n];
        path = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        perm(0, 0);
        System.out.println(answer);
    }

    private static void perm(int depth, int temp) {
        if (depth == n) {
            answer++;
            return;
        }

        if (temp < depth * k) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path[depth] = list[i];
                perm(depth+1, temp + list[i]);
                visited[i] = false;
            }
        }
    }
}
