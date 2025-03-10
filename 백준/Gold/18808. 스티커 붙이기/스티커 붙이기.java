import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static List<Node_18808>[] list;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 스티커를 붙인다.
         * 2. 다음 스티커를 붙인다.
         * 2-1. 스티커는 90도, 180도, 270도로 회전할 수 있다. (회전하는 메서드)
         * 2-2. 스티커가 이미 붙어있는 공간이 있다면 다음 스티커로 넘어간다.
         * 3. 끝까지 갔을 때 가장 많이 스티커가 붙어있는 갯수를 구한다.
         */
    }

    private static void solve() {
        for (int i = 0; i < k; i++) {
            // 스티커를 붙이는 메서드
            if (!tryAttachSticker(list[i]));
        }

        counterSticker();
        System.out.println(answer);
    }

    private static void counterSticker() {
        for (int[] arr : board) {
            for (int cell : arr) {
                answer += cell;
            }
        }
    }

    private static boolean tryAttachSticker(List<Node_18808> sticker) {
        for (int i = 0; i < 4; i++) {
            if (canAttachSticker(sticker)) {
                return true;
            }
            sticker = rotateSticker(sticker);
        }
        return false;
    }

    private static boolean canAttachSticker(List<Node_18808> sticker) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canAttach(sticker, i, j)) {
                    attachSticker(sticker, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private static void attachSticker(List<Node_18808> sticker, int r, int c) {
        for (Node_18808 node : sticker) {
            int nr = node.r + r;
            int nc = node.c + c;
            board[nr][nc] = 1;
        }
    }

    private static boolean canAttach(List<Node_18808> sticker, int r, int c) {
        for (Node_18808 node18808 : sticker) {
            int nr = node18808.r + r;
            int nc = node18808.c + c;

            if (nr >= n || nc >= m || board[nr][nc] == 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Node_18808> rotateSticker(List<Node_18808> sticker) {
        List<Node_18808> rotated = new ArrayList<>();
        int maxR = 0;
        int maxC = 0;
        for (Node_18808 node : sticker) {
            maxR = Math.max(node.r, maxR);
            maxC = Math.max(node.c, maxC);
        }

        for (Node_18808 node : sticker) {
            rotated.add(new Node_18808(node.c, maxR - node.r));
        }

        return rotated;
    }


    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = 0;

        list = new List[k];

        for (int i = 0; i < k; i++) {
            list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == 1) {
                        list[i].add(new Node_18808(j, k));
                    }
                }
            }
        }

        board = new int[n][m];

    }
}

class Node_18808 {
    int r, c;
    public Node_18808 (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
