import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> plusList;
    static List<Integer> minusList;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        int idx = 0;
        int sumV = 0;

        while (idx < plusList.size()) {
            if (idx + 1 < plusList.size() && plusList.get(idx) != 1 && plusList.get(idx+1) != 1) {
                sumV += plusList.get(idx++) * plusList.get(idx++);
            } else {
                sumV += plusList.get(idx++);
            }
        }

        idx = 0;

        while (idx < minusList.size()) {
            if (idx + 1 < minusList.size()) {
                sumV += minusList.get(idx++) * minusList.get(idx++);
            } else {
                sumV += minusList.get(idx++);
            }
        }

        System.out.println(sumV);

    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        plusList = new ArrayList<>();
        minusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                plusList.add(num);
            } else {
                minusList.add(num);
            }
        }

        plusList.sort(Collections.reverseOrder());
        Collections.sort(minusList);
    }
}
