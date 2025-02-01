import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long answer;
    static int[] A, B, C, D, AB, CD;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int l = 0;
        int r = n*n-1;
        while (l < n*n && r >= 0) {
            if (AB[l] + CD[r] < 0) {
                l++;
            } else if (AB[l] + CD[r] > 0) {
                r--;
            } else {
                long lC = 1;
                long rC = 1;
                while (l < n*n-1 && AB[l] == AB[l+1]) {
                    l++;
                    lC++;
                }
                while (r > 0 && CD[r] == CD[r-1]) {
                    r--;
                    rC++;
                }
                answer += lC * rC;
                l++;
            }
        }

        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        AB = new int[n*n];
        CD = new int[n*n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        answer = 0;
    }
}
