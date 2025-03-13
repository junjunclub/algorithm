import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] list;
    static boolean[] isRobot;
    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 벨트 돌리기
         * 2. 로봇 옮기기 (다음 벨트의 내구도가 남아있다면)
         * 2-1. 내구도가 없다면 1로!!
         * 3. 큐의 첫번째에 로봇 올리기
         * 4. 내구도가 0인 갯수 확인하기
         */
    }

    private static void solve() {
        int cnt = 1;
        while (true) {
            runningBelt();
            moveRobot();
            if (list[0] > 0) {
                putRobot();
            }
            if (!valid()) break;
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean valid() {
        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0) {
                temp++;
            }
        }
        return temp < k;
    }

    private static void putRobot() {
        list[0]--;
        isRobot[0] = true;
    }

    private static void moveRobot() {
        // 로봇은 처음에 올리고, 마지막에 내린다.
        for (int i = n - 1; i > 0; i--) {
            // 다음 벨트에 로봇이 없고, 지금 벨트에 로봇이 있고, 내구도가 남아있다면
            if (!isRobot[i] && isRobot[i-1] && list[i] > 0) {
                isRobot[i] = true;
                isRobot[i-1] = false;
                list[i]--;
            }
        }

        // n번째 로봇 내려주기
        if (isRobot[n-1]) {
            isRobot[n-1] = false;
        }
    }

    private static void runningBelt() {
        int lastV = list[list.length-1];

        for (int i = list.length-1; i > 0; i--) {
            list[i] = list[i-1];
            isRobot[i] = isRobot[i-1];
        }
        list[0] = lastV;
        isRobot[0] = false;
        isRobot[n-1] = false;
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new int[2*n];
        isRobot = new boolean[2*n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
        }
    }
}