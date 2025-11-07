import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static class Car implements Comparable<Car> {
        int pos, fuel;

        public Car (int pos, int fuel) {
            this.pos = pos;
            this.fuel = fuel;
        }

        @Override
        public int compareTo (Car c) {
            if (c.pos != this.pos) {
                return Integer.compare(this.pos, c.pos);
            }
            return Integer.compare(this.fuel, c.fuel);
        }
    }

    static List<Car> list = new ArrayList<>();
    static Deque<Integer> q = new ArrayDeque<>();
    static List<Integer> ans = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int left = S - 1;
        while (true) {
            if (left >= 0 && Math.abs(list.get(left).pos - list.get(S).pos) <= list.get(S).fuel) {
                q.add(left);
                visited[left] = true;
                left--;
            } else {
                break;
            }
        }

        int right = S + 1;
        while (true) {
            if (right < N && Math.abs(list.get(right).pos - list.get(S).pos) <= list.get(S).fuel) {
                q.add(right);
                visited[right] = true;
                right++;
            } else {
                break;
            }
        }

        q.add(S);
        visited[S] = true;

        while (!q.isEmpty()) {
            Integer idx = q.poll();
            Car nowCar = list.get(idx);

            for (int i = idx - 1; i >= 0; i--) {
                if (list.get(idx).fuel < Math.abs(nowCar.pos - list.get(i).pos)) break;
                if (visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }

            for (int i = idx + 1; i < N; i++) {
                if (list.get(idx).fuel < Math.abs(nowCar.pos - list.get(i).pos)) break;
                if (visited[i]) continue;
                q.add(i);
                visited[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int f = Integer.parseInt(st.nextToken());
            Car c = new Car(arr[i], f);
            list.add(c);
        }
    }
}
