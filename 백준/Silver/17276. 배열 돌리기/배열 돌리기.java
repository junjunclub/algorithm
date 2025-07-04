import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, D;
    static int[][] arr, copyArr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            if (D < 0) D += 360;
            D /= 45;

            arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[j][k] = num;
                }
            }
            copyArr = new int[N][N];
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    copyArr[a][b] = arr[a][b];
                }
            }

            for (int j = 0; j < D; j++) {
                rotate45();
                for (int a = 0; a < N; a++) {
                    for (int b = 0; b < N; b++) {
                        arr[a][b] = copyArr[a][b];
                    }
                }
            }
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    sb.append(arr[a][b]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void rotate45() {
        for (int i = 0; i < N; i++) {
            copyArr[i][N/2] = arr[i][i];
            copyArr[i][i] = arr[N/2][i];
            copyArr[N/2][i] = arr[N - i - 1][i];
            copyArr[N - i - 1][i] = arr[N - i - 1][N/2];  // 중앙행 → ↙
        }
    }

}
