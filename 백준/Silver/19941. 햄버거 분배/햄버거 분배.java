import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String list = br.readLine();
        int cnt = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (list.charAt(i) == 'P') {
                for (int j = -k; j <= k; j++) {
                    if (i+j >= 0 && i+j < n && list.charAt(i+j) == 'H' && !visited[i+j]) {
                        cnt++;
                        visited[i+j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
