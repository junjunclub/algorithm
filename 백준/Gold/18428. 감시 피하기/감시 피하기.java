import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static boolean[][] visited;
    static char[][] school;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static List<Integer> teachers;
    static int n;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        school = new char[n][n];
        teachers = new ArrayList<>();
        // input
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                school[i][j] = st.nextToken().charAt(0);
                if (school[i][j] == 'T') {
                    teachers.add(cnt);
                }
                cnt++;
            }
        }
        flag = false;
        comb(0, 0);

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void comb(int idx, int depth) {
        if (flag) return;

        if (idx == n*n) return;

        if (depth == 3) {
            if (findStu()) {
                flag = true;
            }
            return;
        }

        int r = idx / n;
        int c = idx % n;

        if (school[r][c] == 'X') {
            school[r][c] = 'W';
            comb(idx + 1, depth + 1);
            school[r][c] = 'X';
        }
        comb(idx + 1, depth);

    }

    private static boolean findStu() {
        for (int k : teachers) {
            for (int i = 0; i < 4; i++) {
                int r = k / n;
                int c = k % n;

                while (true) {
                    int newR = r + dr[i];
                    int newC = c + dc[i];

                    if (0 > newR || newR >= n || 0 > newC || newC >= n || school[newR][newC] == 'W') {
                        break;
                    }

                    if (school[newR][newC] == 'S') {
                        return false;
                    }
                    r = newR;
                    c = newC;
                }
            }
        }
        return true;
    }
}
