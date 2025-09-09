import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            for (int j = N - 1; j >= 0; j--) {
                if (j % 2 == 0) {
                    dq.addFirst(arr[j]);
                } else {
                    dq.addLast(arr[j]);
                }
            }

            int firstNum = dq.peekFirst();
            int lastNum = dq.peekLast();
            int maxNum = Integer.MIN_VALUE;
            int prev = dq.pollFirst();
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                maxNum = Math.max(maxNum, Math.abs(cur - prev));
                prev = cur;
            }
            maxNum = Math.max(maxNum, Math.abs(firstNum - lastNum));
            System.out.println(maxNum);
        }
    }
}
