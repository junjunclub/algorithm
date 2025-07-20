import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, destination, fuel;
    static Queue<Station> stations;
    static Queue<Integer> canRefuel;
    static class Station {
        int loc, oil;
        public Station (int loc, int oil) {
            this.loc = loc;
            this.oil = oil;
        }
//        @Override
//        public int compareTo (Station s) {
//            if (s.loc == this.loc) {
//                return Integer.compare(s.oil, this.oil);
//            }
//            return Integer.compare(this.loc, s.loc);
//        }
    }

    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        int answer = 0;
        while (fuel < destination) {
            while (!stations.isEmpty() && stations.peek().loc <= fuel) {
                canRefuel.add(stations.poll().oil);
            }

            if (canRefuel.isEmpty()) {
                answer = -1;
                break;
            }

            fuel += canRefuel.poll();
            answer++;
        }
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stations = new PriorityQueue<>(Comparator.comparingInt(s -> s.loc));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int oil = Integer.parseInt(st.nextToken());
            Station station = new Station(loc, oil);
            stations.add(station);
        }
        st = new StringTokenizer(br.readLine());
        destination = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        canRefuel = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
