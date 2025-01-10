import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));

            // 물건이 하나일 때
            if(list.get(i) == C) {
                System.out.println(1);
                return;
            }
        }

        Collections.sort(list);

        int s = 0, e = N-1, weight;
        while(s < e) {
            weight = list.get(s) + list.get(e);
            if(weight > C) {
                e--;
            }
            else if(weight == C) {
                System.out.println(1);
                return;
            }
            else {
                for (int mid = s + 1; mid < e; mid++) {
                    if (weight + list.get(mid) == C) {
                        System.out.println(1);
                        return;
                    }
                }
                s++;
            }
        }
        System.out.println(0);
    }
}