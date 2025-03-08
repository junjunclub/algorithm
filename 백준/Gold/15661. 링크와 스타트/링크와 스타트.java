import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static List<Integer> list1, list2;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        init();
        solve();

        /**
         * 1. 두 팀으로 나눈다. (한 팀에 적어도 한 명은 존재해야함)
         * 2. 0인 팀, 1인 팀으로 나누고 값 갱신
         */

        System.out.println(answer);
    }

    private static void solve() {
        bitMask();
    }

    private static void bitMask() {
        for (int i = 1; i < (1 << n) - 1; i++) {
            for (int j = 0; j < n; j++) {
                // 0이면 1팀
                if ((i & (1 << j)) == 0) {
                    list1.add(j);
                // 1이면 2팀
                } else {
                    list2.add(j);
                }
            }
            calculatePoint();
            list1.clear();
            list2.clear();
        }
    }

    private static void calculatePoint() {
        int size1 = list1.size();
        int size2 = list2.size();

        int temp = 0;

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size1; j++) {
                int num1 = list1.get(i);
                int num2 = list1.get(j);
                temp += arr[num1][num2];
            }
        }

        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size2; j++) {
                int num1 = list2.get(i);
                int num2 = list2.get(j);
                temp -= arr[num1][num2];
            }
        }

        answer = Math.min(Math.abs(temp), answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
    }
}
