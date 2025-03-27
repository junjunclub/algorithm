import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int status;
    static ArrayDeque<Node3190> list;
    static Map<Integer, Character> map;
    static boolean[][] isApple;
    // 우, 하, 좌, 상 순서
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 머리 다음 위치를 체크
         * 2. 사과체크
         * 2-1. 사과가 있으면 머리만 늘려주기, 사과 제거
         * 2-2. 사과가 없으면 머리 늘려주고 꼬리 제거
         * 3. 방향 전환
         * 
         * 문제를 잘 읽고, deque의 First와 Last가 어떤건지 정확히 파악할 필요가 있다.
         */
    }

    private static void solve() {
        int time = 0;
        int head = 0;
        list.add(new Node3190(0,0));

        while (true) {
            time++;

            Node3190 headPos = list.peekLast();
            int hR = headPos.r+dr[head];
            int hC = headPos.c+dc[head];

            int posV = positionValidate(hR, hC);

            if (posV == -1) {
                break;
            } else if (posV == 1) {
                list.addLast(new Node3190(hR, hC));
                isApple[hR][hC] = false;
            } else {
                list.addLast(new Node3190(hR, hC));
                list.pollFirst();
            }

            Character nextHead = map.getOrDefault(time, '0');

            if (nextHead == 'L') {
                head = ((head - 1) + 4) % 4;
            } else if (nextHead == 'D') {
                head = ((head + 1) + 4) % 4;
            }
        }
        System.out.println(time);
    }

    private static int positionValidate(int r, int c) {
        if (0 > r || N <= r || 0 > c || N <= c) {
            return -1;
        }
        if (isApple[r][c]) {
            return 1;
        }

        for (Node3190 node : list) {
            if (node.r == r && node.c == c)
                return -1;
        }

        return 0;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        list = new ArrayDeque<>();
        map = new HashMap<>();

        status = 1;

        isApple = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            isApple[r-1][c-1] = true;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            Character P = st.nextToken().charAt(0);
            map.put(X, P);
        }
    }
}


class Node3190 {
    int r, c;
    public Node3190 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}