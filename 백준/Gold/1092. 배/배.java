import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> crane, box;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int answer = 0;
        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
        } else {
            while (!box.isEmpty()) {
                for (int i = 0; i < crane.size(); i++) {
                    for (int j = 0; j < box.size(); j++) {
                        if (crane.get(i) >= box.get(j)) {
                            box.remove(j);
                            break;
                        }
                    }
                }
                answer++;
            }
            System.out.println(answer);
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Collections.reverseOrder());
        crane.sort(Collections.reverseOrder());
    }
}
