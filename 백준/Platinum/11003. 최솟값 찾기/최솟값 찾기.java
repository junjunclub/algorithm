import java.util.*;
import java.io.*;

public class Main {
    static class Value {
        int n, idx;
        Value(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Value> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast().n > num) {
                dq.pollLast();
            }

            dq.addLast(new Value(num, i));

            if (dq.peekFirst().idx <= i - L) {
                dq.pollFirst();
            }

            sb.append(dq.peekFirst().n).append(" ");
        }

        System.out.println(sb);
    }
}