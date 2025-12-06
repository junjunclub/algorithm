import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static List<Integer> res;
    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        System.out.println(recur(0, 0, N));
    }

    private static int recur(int r, int c, int n) {
        if (n == 1) {
            return arr[r][c];
        }
        
        int half = n / 2;
        
        int[] temp = new int[4];
        
        temp[0] = recur(r, c, half);
        temp[1] = recur(r, c + half, half);
        temp[2] = recur(r + half, c, half);
        temp[3] = recur(r + half, c + half, half);
        
        Arrays.sort(temp);
        
        return temp[1];
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}