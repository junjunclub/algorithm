import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t, count;
    static int[] arr;
    static boolean[] team, visited;

    public static void main(String[] args) throws Exception{
        init();
    }

    private static void dfs(int n) {
        if (visited[n]) {
            team[n] = true;
            count++;
        } else {
            visited[n] = true;
        }

        if (!team[arr[n]]) {
            dfs(arr[n]);
        }

        visited[n] = false;
        team[n] = true;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = 0;
            arr = new int[n+1];
            visited = new boolean[n+1];
            team = new boolean[n+1];
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!team[j]) {
                    dfs(j);
                }
            }

            System.out.println((n-count));
        }
    }
}
