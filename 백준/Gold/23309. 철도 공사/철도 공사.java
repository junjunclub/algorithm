import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static class Station{
        public int[] preNodes;
        public int[] postNodes;

        Station() {
            preNodes = new int[1000001];
            postNodes = new int[1000001];
        }
        public void add(int target, int node) {

            if(target == -1) {
                preNodes[node] = postNodes[node] = node;
                return;
            }

            preNodes[node] = target;
            postNodes[node] = postNodes[target];
            preNodes[postNodes[target]] = node;
            postNodes[target] = node;
        }

        public void delete(int targetNode) {
            postNodes[preNodes[targetNode]] = postNodes[targetNode];
            preNodes[postNodes[targetNode]] = preNodes[targetNode];
        }

        void print(int num) {
            sb.append(num).append("\n");
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Station station = new Station();
        st = new StringTokenizer(br.readLine());

        int target = -1;

        for(int i = 0; i < n; i ++) {
            int node = Integer.parseInt(st.nextToken());
            station.add(target, node);
            target = node;
        }

        for(int w = 0; w < m; w++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            int targetNode = Integer.parseInt(st.nextToken());
            int newNode = 0;
            if(st.hasMoreTokens()) {
                newNode = Integer.parseInt(st.nextToken());
            }

            switch (type) {
                case "BN":
                    station.print(station.postNodes[targetNode]);
                    station.add(targetNode, newNode);
                    break;
                case "BP":
                    station.print(station.preNodes[targetNode]);
                    station.add(station.preNodes[targetNode], newNode);
                    break;
                case "CN":
                    station.print(station.postNodes[targetNode]);
                    station.delete(station.postNodes[targetNode]);
                    break;
                case "CP":
                    station.print(station.preNodes[targetNode]);
                    station.delete(station.preNodes[targetNode]);
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}