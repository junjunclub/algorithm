import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static char[][] window;
    static int result;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        answer = new int[5];

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        window = new char[5*m+1][5*n+1];

        for (int i = 0; i < window.length; i++) {
            window[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[check(i*5+1, j*5+1)]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int check(int r, int c) {
        result = 0;

        for (int i = r; i < r+4; i++) {
            if (window[i][c] == '.') {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }
}
