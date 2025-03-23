import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static Queue<FireBall>[][] board;
    static Queue<FireBall>[][] temp;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. q에 파이어볼 정보 담기
         * 2. 순회하면서 파이어볼 temp로 이동
         * 3. 이동이 끝나면 temp를 다시 board로
         * 4. board를 순회하면서 파이어볼 합치기
         * 
         * 속력이 엄청 클 때 인덱스 에러가 발생했다.......
         */
    }

    private static void solve() {
        // K번 실행한다.
        for (int k = 0; k < K; k++) {

            // 임시 배열 초기화
            temp = new LinkedList[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = new LinkedList<>();
                }
            }

            // 순회하면서 파이어볼이 있는 경우 이동(temp로)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!board[i][j].isEmpty()) {
                        moveFireball(i, j);
                    }
                }
            }

            board = temp;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j].size() >= 2) {
                        fusionFireball(i, j);
                    }
                }
            }
        }

        sum();
    }

    private static void sum() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i][j].isEmpty()) {
                    while (!board[i][j].isEmpty()) {
                        answer += board[i][j].poll().m;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void moveFireball(int r, int c) {
        while (!board[r][c].isEmpty()) {
            // 질량 m, 방향 d, 속력 s
            FireBall fb = board[r][c].poll();

            int newR = ((r + dr[fb.d] * fb.s) % N + N) % N;
            int newC = ((c + dc[fb.d] * fb.s) % N + N) % N;


            temp[newR][newC].add(new FireBall(fb.m, fb.s, fb.d));
        }
    }

    private static void fusionFireball(int r, int c) {
        int tempM = 0;
        int tempD = 0;
        int tempS = 0;
        int start = 1;
        int size = board[r][c].size();
        while (!board[r][c].isEmpty()) {
            FireBall fb = board[r][c].poll();
            tempM += fb.m;
            tempS += fb.s;
            // 방향이 짝수면
            if (fb.d % 2 == 0) {
                tempD++;
            }
        }
        // 모두 짝수거나 모두 홀수 일 경우 시작을 0으로;
        if (tempD == 0 || tempD == size) {
            start = 0;
        }

        int newM = tempM / 5;
        int newS = tempS / size;

        if (newM == 0) return;

        for (int i = start; i < 8; i += 2) {
            board[r][c].add(new FireBall(newM, newS, i));
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new LinkedList<>();
            }
        }



        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[r-1][c-1].add(new FireBall(m, s, d));
        }
    }
}

class FireBall {
    int m, s, d;

    public FireBall(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}