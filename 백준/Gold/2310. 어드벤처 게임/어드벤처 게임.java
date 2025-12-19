import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        String type;
        int money;
        List<Integer> next = new ArrayList<>();

        public Room(String type, int money) {
            this.type = type;
            this.money = money;
        }
    }

    static int N;
    static Room[] rooms;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            rooms = new Room[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String t = st.nextToken();
                int money = Integer.parseInt(st.nextToken());
                rooms[i] = new Room(t, money);

                while (true) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 0) break;
                    rooms[i].next.add(n);
                }
            }

            visited = new boolean[N + 1];
            flag = false;
            dfs(1, 0);

            sb.append(flag ? "Yes" : "No").append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int now, int money) {
        if (flag) return;
        if (now == N) {
            flag = true;
            return;
        }

        visited[now] = true;

        for (int next : rooms[now].next) {
            if (visited[next]) continue;

            Room r = rooms[next];
            int curMoney = money;

            if (r.type.equals("L")) {
                curMoney = Math.max(curMoney, r.money);
            } else if (r.type.equals("T")) {
                if (curMoney < r.money) continue;
                curMoney -= r.money;
            }

            dfs(next, curMoney);
        }

        visited[now] = false;
    }
}