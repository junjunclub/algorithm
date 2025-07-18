import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs(arr, K));
    }

    private static int bfs(int[] arr, int k) {
        Queue<int[]> q = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        String start = toStr(arr);
        String target = makeTarget(N);

        q.add(arr);
        visited.put(start, 0);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            String curStr = toStr(cur);
            int depth = visited.get(curStr);

            if (curStr.equals(target)) return depth;

            for (int i = 0; i <= cur.length - k; i++) {
                int[] next = cur.clone();

                reverse(next, i, i + K - 1);
                String nextStr = toStr(next);

                if (!visited.containsKey(nextStr)) {
                    q.add(next);
                    visited.put(nextStr, depth + 1);
                }
            }
        }


        return -1;
    }

    private static void reverse(int[] next, int l, int r) {
        while (l < r) {
            int temp = next[l];
            next[l] = next[r];
            next[r] = temp;
            l++;
            r--;
        }
    }

    private static String makeTarget(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static String toStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
