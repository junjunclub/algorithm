import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] elec;
    static List<Line> lines;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        elec = new int[n+1];
        lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines.add(new Line(a, b));
        }

        /**
         * 1. Line의 start 기준으로 정렬
         * 2. e를 비교하면서 최대로 많이 증가하는 수랑 n의 차이를 구한다.
         */

        Collections.sort(lines);
        elec[0] = 1;
        int answer = 1;
        for (int i = 1; i < n; i++) {
            elec[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lines.get(i).e > lines.get(j).e) {
                    elec[i] = Math.max(elec[i], elec[j] + 1);
                }
            }
            answer = Math.max(answer, elec[i]);
        }
        System.out.println(n-answer);
    }
}

class Line implements Comparable<Line> {
    int s, e;
    public Line (int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo (Line l) {
        return this.s - l.s;
    }
}