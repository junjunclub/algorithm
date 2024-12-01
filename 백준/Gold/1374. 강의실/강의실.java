import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int no, start, end;
        public Lecture (int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        // 정렬 재정의
        @Override
        public int compareTo(Lecture l) {
            if (this.start == l.start) {
                return this.end - l.end;
            } else {
                return this.start - l.start;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();

        // 입력
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(no, start, end));
        }
        // 정렬
        Collections.sort(list);

        // 강의의 끝나는 시간이 담긴 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxV = 1;

        for (int i = 0; i < t; i++) {
            // 끝나는시간이 강의 시작시간보다 작거나 같을 경우 빼준다.(관련 없는 강의)
            while (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            // 강의 넣고 maxV값 갱신
            pq.offer(list.get(i).end);
            maxV = Math.max(maxV, pq.size());
        }

        System.out.println(maxV);
    }
}
