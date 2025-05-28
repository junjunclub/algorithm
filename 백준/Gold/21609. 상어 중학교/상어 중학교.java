import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Block10836> pq;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws Exception{
        init();
        solve();
        /**
         * 1. 크기가 가장 큰 블록 그룹 찾기
         * 1-1. 블록 그룹이 여러개라면, 무지개 블록의 수가 가장 많은 그룹
         * 1-2. 이 그룹도 여러가지라면, 기준 블록의 행이 가장 큰 것
         * 1-3. 열이 가장 큰 것 기준으로 찾기
         * 2. 1 그룹의 모든 블록을 제거하고, 블록의 갯수의 제곱만큼의 점수를 획득한다.
         * 3. 격자에 중력이 작용해서 검정색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동한다.
         * 4. 격자가 90도 반시계 방향으로 회전한다.
         * 5. 다시 격자에 중력이 작용한다.
         *
         * 6. 블록 그룹이 존재하는 동안 계속해서 반복
         */
    }

    private static void solve() {
        int answer = 0;
        while (true) {
            // 블록 그룹이 존재하는 동안 계속해서 반복
            if (canFindBlock()) {
                List<Node10836> nodes = pq.poll().nodes;
                answer += nodes.size() * nodes.size();

                for (int i = 0; i < nodes.size(); i++) {
                    Node10836 n = nodes.get(i);
                    board[n.r][n.c] = -2;
                }
                activateGravity();
                rotate();
                activateGravity();
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    private static void rotate() {
        int[][] temp = new int[N][N];
        // 0, 0 -> N, 0 || 0, 1 -> N-1, 0 || 0, 2 -> N-2, 0 || 1, 0 -> N, 1 || 1, 3 -> N-3 ,1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N - j - 1][i] = board[i][j];
            }
        }
        board = temp;
    }

    private static void activateGravity() {
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                // 검은색 블록을 만나면 블록 쌓기
                if (board[j][i] == -1) {
                    for (int k = 0; k < list.size(); k++) {
                        board[j - k - 1][i] = list.get(list.size() - 1 - k);
                    }
                    list.clear();
                } else if (board[j][i] != -2){
                    // 블록이 존재한다면
                    int num = board[j][i];
                    list.add(num);
                    board[j][i] = -2;
                } else {
                    board[j][i] = -2;
                }
            }
            for (int k = 0; k < list.size(); k++) {
                board[N - k - 1][i] = list.get(list.size() - 1 - k);
            }
            list.clear();
        }
    }

    private static boolean canFindBlock() {
        visited = new boolean[N][N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    bfs(i, j);
                }
            }
        }
        if (pq.isEmpty()) {
            return false;
        }
        return true;
    }

    private static void bfs(int r, int c) {
        Queue<Node10836> q = new LinkedList<>();
        List<Node10836> list = new ArrayList<>();
        visited[r][c] = true;
        list.add(new Node10836(r, c));
        q.add(new Node10836(r, c));
        int rainbow = 0;
        while (!q.isEmpty()) {
            Node10836 node = q.poll();

            int nowR = node.r;
            int nowC = node.c;

            for (int i = 0; i < 4; i++) {
                int newR = nowR + dr[i];
                int newC = nowC + dc[i];
                if (0 > newR || N <= newR || 0 > newC || N <= newC || visited[newR][newC]) continue;
                if (board[newR][newC] == 0) rainbow++;
                if (board[newR][newC] != board[r][c] && board[newR][newC] != 0) continue;

                q.add(new Node10836(newR, newC));
                list.add(new Node10836(newR, newC));
                visited[newR][newC] = true;
            }
        }
        if (list.size() >= 2) {
            pq.add(new Block10836(list, rainbow, r, c));
        }

        for (int i = 0; i < list.size(); i++) {
            Node10836 n = list.get(i);
            if (board[n.r][n.c] == 0) {
                visited[n.r][n.c] = false;
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

class Node10836 {
    int r, c;
    public Node10836 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Block10836 implements Comparable<Block10836>{
    List<Node10836> nodes;
    int rainbowCnt, sr, sc;
    public Block10836 (List<Node10836> nodes, int rainbowCnt, int sr, int sc) {
        this.nodes = nodes;
        this.rainbowCnt = rainbowCnt;
        this.sr = sr;
        this.sc = sc;
    }

    @Override
    public int compareTo (Block10836 b) {
        if (b.nodes.size() == this.nodes.size()) {
            if (b.rainbowCnt == this.rainbowCnt) {
                if (b.sr == this.sr) {
                    return Integer.compare(b.sc, this.sc);
                }
                return Integer.compare(b.sr, this.sr);
            }
            return Integer.compare(b.rainbowCnt, this.rainbowCnt);
        }
        return Integer.compare(b.nodes.size(), this.nodes.size());
    }
}