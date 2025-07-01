import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end;
    static StringTokenizer st;
    static long answer;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
            init();
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            arr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            calculate(arr);
        }
        System.out.println(answer);
        System.out.println(sb);
    }

    private static void calculate(int[] arr) {
        long maxV = arr[0];
        long tempV = arr[0];
        int tempStart = 0;
        start = 0;
        end = 0;

        for (int i = 1; i < arr.length; i++) {
            if (tempV + arr[i] <= arr[i]) {
                tempStart = i;
                tempV = arr[i];
            } else {
                tempV += arr[i];
            }

            if (maxV < tempV ||
                    (tempV == maxV && (end - start) > (i - tempStart))) {
                end = i;
                maxV = tempV;
                start = tempStart;
            }
        }
        answer += maxV;
        sb.append(start + 1).append(" ").append(end + 1).append("\n");
    }
}
