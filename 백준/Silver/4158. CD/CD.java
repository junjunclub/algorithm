import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = 0;
            int[] sg = new int[n];
            int[] sy = new int[m];

            if (n == 0 && m == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                sg[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < n; i++) {
                sy[i] = Integer.parseInt(br.readLine());
            }

            int s1 = 0;
            int s2 = 0;

            while (s1 != n && s2 != m) {
                if (sg[s1] == sy[s2]) {
                    answer++;
                    s1++;
                    s2++;
                } else if (sg[s1] > sy[s2]) {
                    s2++;
                } else {
                    s1++;
                }
            }
            System.out.println(answer);
        }
    }
}
