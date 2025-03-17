import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static int R, C, T, answer;
    static int[][] board;
    static int[][] tempBoard;
    static int[] airU = new int[2];
    static int[] airD = new int[2];
    static Queue<Air> dirty = new LinkedList<>();

    public static class Air{
        int x;
        int y;
        int size;

        public Air() {}
        public Air(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException{

        init();
        solve();

        System.out.print(answer);

    }

    private static void solve() {
        while(T-->0) {
            Queue<Air> qu = new LinkedList<>();
            int[][] visited = new int[R][C];
            tempBoard = new int[R][C];

            while(!dirty.isEmpty()) {
                qu.add(dirty.poll());
            }


            while(!qu.isEmpty()) {
                Air cur = qu.poll();

                if(visited[cur.y][cur.x]>0)continue;

                int count = 0;
                int spread = (int) Math.floor(cur.size / 5);
                for(int i = 0; i < 4; i++) {
                    int mx = cur.x + dx[i];
                    int my = cur.y + dy[i];

                    if(mx < 0 || mx >= C || my <0 || my >= R || board[my][mx] == -1 )continue;
                    count++;
                    tempBoard[my][mx] += spread;

                }
                tempBoard[cur.y][cur.x] -= spread * count;
            }

            for(int i = 0 ; i < R; i++) {
                for(int j = 0 ; j < C;j++) {
                    board[i][j] += tempBoard[i][j];
                }
            }

            cleaningTopAir();
            cleaningBottomAir();

            for(int i = 0 ; i < R; i++) {
                for(int j = 0 ; j < C;j++) {
                    if(board[i][j] > 0) dirty.add(new Air(j,i,board[i][j]));
                }
            }
        }

        answer = 2;

        for(int i = 0 ; i < R; i++) {
            for(int j = 0 ; j < C;j++) {
                answer += board[i][j];
            }
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];


        boolean isFind = false;
        for(int i = 0 ; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(board[i][j] == -1 && !isFind) {
                    airU[0] = i;
                    airD[0] = i+1;
                    isFind =true;
                }
                else if(board[i][j] > 0) {
                    dirty.add(new Air(j,i,board[i][j]));
                }
            }
        }
    }

    public static void cleaningTopAir() {
        for(int i = airU[0] - 1; i > 0; i--) {
            board[i][0] = board[i-1][0];
        }

        for(int i =0; i < C-1; i++) {
            board[0][i] = board[0][i+1];
        }

        for(int i = 0; i < airU[0] ; i++) {
            board[i][C-1] = board[i+1][C-1];
        }

        for(int i = C-1; i > 1; i--) {
            board[airU[0]][i] = board[airU[0]][i-1];
        }
        board[airU[0]][1] = 0;
    }
    public static void cleaningBottomAir() {
        for(int i = airD[0] + 1; i < R - 1; i++) {
            board[i][0] = board[i+1][0];
        }

        for(int i =0; i < C-1; i++) {
            board[R-1][i] = board[R-1][i+1];
        }

        for(int i = R-1; i > airD[0] ; i--) {
            board[i][C-1] = board[i-1][C-1];
        }

        for(int i = C-1; i > 1; i--) {
            board[airD[0]][i] = board[airD[0]][i-1];
        }
        board[airD[0]][1] = 0;
    }
}