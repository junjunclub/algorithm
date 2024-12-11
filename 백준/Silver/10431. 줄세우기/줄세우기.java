import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            int cnt = 0;
            
            for (int j = 0; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 이진 탐색으로 삽입 위치 찾기
                int pos = binarySearch(list, num);

                // 삽입 위치 이후의 원소 개수만큼 inversions 발생
                cnt += list.size() - pos;

                // 해당 위치에 숫자 삽입
                list.add(pos, num);
            }
            sb.append(n).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    // 이진 탐색으로 삽입 위치 찾기
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // 삽입 위치
    }
}
