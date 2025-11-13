import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M;
    static Node[][] board;

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    static List<Shark> sharks;

    static class Shark {
        int r, c, s, d, z;

        public Shark (int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public Shark (Shark shark) {
            this.r = shark.r;
            this.c = shark.c;
            this.s = shark.s;
            this.d = shark.d;
            this.z = shark.z;
        }

        public Shark move () {
            int speed = s;

            if (d == 1 || d == 2) {
                speed %= (R - 1) * 2;
            } else {
                speed %= (C - 1) * 2;
            }

            for (int i = 0; i < speed; i++) {
                r += dr[d];
                c += dc[d];

                if (r < 0) {
                    r = 1;
                    d = 2;
                } else if (r >= R) {
                    r = R - 2;
                    d = 1;
                } else if (c < 0) {
                    c = 1;
                    d = 3;
                } else if (c >= C) {
                    c = C - 2;
                    d = 4;
                }
            }

            return this;
        }
    }

    static class Node {
        int r, c;
        Shark shark;

        public Node (int r, int c, Shark shark) {
            this.r = r;
            this.c = c;
            this.shark = shark;
        }

        public Node (int r, int c) {
            this.r = r;
            this.c = c;
            this.shark = null;
        }
    }

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int idx = -1;
        int ans = 0;
        while (idx < C - 1) {
            idx++;

            ans += getShark(idx);

            sharkMove();

        }

        System.out.println(ans);
    }

    private static int getShark(int idx) {
        for (int i = 0; i < R; i++) {
            Node now = board[i][idx];

            if (now.shark != null) {
                int v = now.shark.z;
                sharks.remove(now.shark);
                now.shark = null;
                return v;
            }
        }
        return 0;
    }

    private static void sharkMove() {
        Node[][] temp = new Node[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = new Node(i, j);
            }
        }

        List<Shark> newSharks = new ArrayList<>();

        for (Shark s : sharks) {
            Shark moved = s.move();
            int r = moved.r;
            int c = moved.c;

            if (temp[r][c].shark == null) {
                temp[r][c].shark = moved;
                newSharks.add(moved);
            } else {

                if (temp[r][c].shark.z < moved.z) {
                    newSharks.remove(temp[r][c].shark);
                    temp[r][c].shark = moved;
                    newSharks.add(moved);
                }
            }
        }

        sharks = newSharks;
        board = temp;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Node[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = new Node(i, j);
            }
        }

        sharks = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            board[r][c].shark = shark;
            sharks.add(shark);
        }

    }
}
