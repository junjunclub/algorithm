import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, C;
    static char[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;

        char[] dirChar = {'U', 'R', 'D', 'L'};
        int maxCnt = -1;
        char bestDir = ' ';
        String result = "";

        for (int d = 0; d < 4; d++) {
            visited = new int[N][M][4];
            int val = simulate(R, C, d);
            if (val == -1) {
                System.out.println(dirChar[d]);
                System.out.println("Voyager");
                return;
            }
            if (val > maxCnt) {
                maxCnt = val;
                bestDir = dirChar[d];
            }
        }

        System.out.println(bestDir);
        System.out.println(maxCnt);
    }

    static int simulate(int r, int c, int dir) {
        int cnt = 0;
        int curR = r, curC = c, curDir = dir;

        while (true) {
            int nr = curR + dr[curDir];
            int nc = curC + dc[curDir];
            cnt++;

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) return cnt;
                
            if (board[nr][nc] == 'C') return cnt;

            if (visited[nr][nc][curDir] == 1) return -1;
            
            visited[nr][nc][curDir] = 1;

            if (board[nr][nc] == '/') curDir = reflectSlash(curDir);
            else if (board[nr][nc] == '\\') curDir = reflectBackslash(curDir);

            curR = nr;
            curC = nc;
        }
    }

    static int reflectSlash(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }

    static int reflectBackslash(int dir) {
        if (dir == 0) return 3;
        if (dir == 1) return 2;
        if (dir == 2) return 1;
        return 0;
    }
}