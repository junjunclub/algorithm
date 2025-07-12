import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] result;
    static PriorityQueue<Node1379> pq;
    static PriorityQueue<Room1379> pq2;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve() {
        while(!pq.isEmpty()){
            Node1379 cur  = pq.poll();

            if(pq2.isEmpty()){
                pq2.add(new Room1379(1,cur.e));
                result[cur.num] = 1;
            }else{
                if(pq2.peek().e <= cur.s){
                    result[cur.num] = pq2.peek().num;
                    pq2.poll();
                    pq2.add(new Room1379(result[cur.num],cur.e));
                }else{
                    result[cur.num] = pq2.size() + 1;
                    pq2.add(new Room1379(result[cur.num],cur.e));
                }
            }
        }

        sb.append(pq2.size()+"\n");

        for(int i=1;i<=n;i++){
            sb.append(result[i]+"\n");
        }

        System.out.print(sb);
    }

    private static void init() throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        result = new int[n+1];
        pq = new PriorityQueue<>(
                (x,y) -> {
                    if(x.s == y.s)
                        return x.e - y.e;

                    return x.s - y.s;
                }
        );

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.add(new Node1379(num,s,e));
        }

        pq2 = new PriorityQueue<>(
                (x,y) -> x.e - y.e
        );
    }
}
class Room1379{
    int num;
    int e;

    Room1379(int num,int e){
        this.num  = num;
        this.e = e;
    }
}
class Node1379{
    int num;
    int s;
    int e;

    Node1379(int num,int s,int e){
        this.num = num;
        this.s = s;
        this.e = e;
    }
}