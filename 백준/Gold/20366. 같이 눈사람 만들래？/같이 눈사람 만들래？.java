import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] list;
    static int minV;
    static List<SnowMan> snowMEN = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new int[n];
        minV = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * snowman 클래스 만들고, 그걸 list에 넣어주기
         * height 기준으로 정렬
         */

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                snowMEN.add(new SnowMan(i, j, list[i]+list[j]));
            }
        }

        Collections.sort(snowMEN);

        for (int i = 0; i < snowMEN.size() - 1; i++) {
            SnowMan s1 = snowMEN.get(i);
            SnowMan s2 = snowMEN.get(i + 1);
            int temp = Math.abs(s1.height - s2.height);
            if (s1.headIdx != s2.headIdx && s1.headIdx != s2.bodyIdx && s1.bodyIdx != s2.headIdx && s1.bodyIdx != s2.bodyIdx && temp < minV) {
                minV = temp;
            }
        }
        System.out.println(minV);
    }
}
class SnowMan implements Comparable<SnowMan>{
    int headIdx, bodyIdx, height;
    public SnowMan (int head, int body, int height) {
        this.headIdx = head;
        this.bodyIdx = body;
        this.height = height;
    }

    @Override
    public int compareTo(SnowMan s) {
        return this.height - s.height;
    }
}