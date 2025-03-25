import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] up, down, front, back, left, right;
    static StringBuilder sb;
    static int T;
    static String[] command;

    public static void main(String[] args) throws Exception {
        init();
        solve();
        /**
        * 1. 무식하게.....
        * 2. 그치만 똑똑하게....
        * 3. 각 면이 어떻게 변하는지도 확인해야한다. (이걸 안해서 답이 제대로 안나옴)
        */
    }

    private static void solve() {
        System.out.println(sb);
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            up = new char[][]{{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
            down = new char[][]{{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
            front = new char[][]{{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
            back = new char[][]{{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
            left = new char[][]{{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
            right = new char[][]{{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};

            command = new String[n];
            for (int j = 0; j < n; j++) {
                command[j] = st.nextToken();
            }

            for(int j = 0; j < n; j++) {
                String str = command[j];
                char move = str.charAt(0);
                char dir = str.charAt(1);
                if(move == 'U') {
                    rotate_U(dir);
                } else if(move == 'D') {
                    rotate_D(dir);
                } else if(move == 'F') {
                    rotate_F(dir);
                } else if(move == 'B') {
                    rotate_B(dir);
                } else if(move == 'L') {
                    rotate_L(dir);
                } else if(move == 'R') {
                    rotate_R(dir);
                }
            }

            for(int j = 0; j < 3; j++) {
                for(int k = 0;k < 3; k++) {
                    sb.append(up[j][k]);
                }
                sb.append("\n");
            }
        }
    }

    private static void rotate_U(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = front[0][i];

            for (int i = 0; i < 3; i++) front[0][i] = right[0][i];
            for (int i = 0; i < 3; i++) right[0][i] = back[0][i];
            for (int i = 0; i < 3; i++) back[0][i] = left[0][i];
            for (int i = 0; i < 3; i++) left[0][i] = temp[i];

            up = roll(up);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = front[0][i];

            for (int i = 0; i < 3; i++) front[0][i] = left[0][i];
            for (int i = 0; i < 3; i++) left[0][i] = back[0][i];
            for (int i = 0; i < 3; i++) back[0][i] = right[0][i];
            for (int i = 0; i < 3; i++) right[0][i] = temp[i];

            up = rollReverse(up);
        }
    }

    private static void rotate_D(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = front[2][i];

            for (int i = 0; i < 3; i++) front[2][i] = left[2][i];
            for (int i = 0; i < 3; i++) left[2][i] = back[2][i];
            for (int i = 0; i < 3; i++) back[2][i] = right[2][i];
            for (int i = 0; i < 3; i++) right[2][i] = temp[i];

            down = roll(down);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = front[2][i];

            for (int i = 0; i < 3; i++) front[2][i] = right[2][i];
            for (int i = 0; i < 3; i++) right[2][i] = back[2][i];
            for (int i = 0; i < 3; i++) back[2][i] = left[2][i];
            for (int i = 0; i < 3; i++) left[2][i] = temp[i];

            down = rollReverse(down);
        }
    }

    private static void rotate_F(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[2][i];

            for (int i = 0; i < 3; i++) up[2][i] = left[2 - i][2];
            for (int i = 0; i < 3; i++) left[i][2] = down[0][i];
            for (int i = 0; i < 3; i++) down[0][i] = right[2 - i][0];
            for (int i = 0; i < 3; i++) right[i][0] = temp[i];

            front = roll(front);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[2][i];

            for (int i = 0; i < 3; i++) up[2][i] = right[i][0];
            for (int i = 0; i < 3; i++) right[2 - i][0] = down[0][i];
            for (int i = 0; i < 3; i++) down[0][i] = left[i][2];
            for (int i = 0; i < 3; i++) left[2 - i][2] = temp[i];

            front = rollReverse(front);
        }
    }

    private static void rotate_B(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[0][i];

            for (int i = 0; i < 3; i++) up[0][i] = right[i][2];
            for (int i = 0; i < 3; i++) right[2 - i][2] = down[2][i];
            for (int i = 0; i < 3; i++) down[2][i] = left[i][0];
            for (int i = 0; i < 3; i++) left[2 - i][0] = temp[i];

            back = roll(back);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[0][i];

            for (int i = 0; i < 3; i++) up[0][i] = left[2 - i][0];
            for (int i = 0; i < 3; i++) left[i][0] = down[2][i];
            for (int i = 0; i < 3; i++) down[2][i] = right[2 - i][2];
            for (int i = 0; i < 3; i++) right[i][2] = temp[i];

            back = rollReverse(back);
        }
    }

    private static void rotate_L(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[i][0];

            for (int i = 0; i < 3; i++) up[i][0] = back[2 - i][2];
            for (int i = 0; i < 3; i++) back[i][2] = down[2 - i][0];
            for (int i = 0; i < 3; i++) down[i][0] = front[i][0];
            for (int i = 0; i < 3; i++) front[i][0] = temp[i];

            left = roll(left);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[i][0];

            for (int i = 0; i < 3; i++) up[i][0] = front[i][0];
            for (int i = 0; i < 3; i++) front[i][0] = down[i][0];
            for (int i = 0; i < 3; i++) down[2 - i][0] = back[i][2];
            for (int i = 0; i < 3; i++) back[2 - i][2] = temp[i];

            left = rollReverse(left);
        }
    }

    private static void rotate_R(char dir) {
        if (dir == '+') {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[i][2];

            for (int i = 0; i < 3; i++) up[i][2] = front[i][2];
            for (int i = 0; i < 3; i++) front[i][2] = down[i][2];
            for (int i = 0; i < 3; i++) down[i][2] = back[2 - i][0];
            for (int i = 0; i < 3; i++) back[i][0] = temp[2 - i];

            right = roll(right);
        } else {
            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) temp[i] = up[i][2];

            for (int i = 0; i < 3; i++) up[i][2] = back[2 - i][0];
            for (int i = 0; i < 3; i++) back[i][0] = down[2 - i][2];
            for (int i = 0; i < 3; i++) down[i][2] = front[i][2];
            for (int i = 0; i < 3; i++) front[i][2] = temp[i];

            right = rollReverse(right);
        }
    }


    private static char[][] roll(char[][] lst) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[j][2 - i] = lst[i][j];
            }
        }
        return temp;
    }

    private static char[][] rollReverse(char[][] lst) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[2 - j][i] = lst[i][j];
            }
        }
        return temp;
    }

}