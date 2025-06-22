import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map;
    static TreeSet<Problem21939> treeSet;

    static int N, P;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        treeSet = new TreeSet<>();

        map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int probNum = Integer.parseInt(st.nextToken());
            int probDif = Integer.parseInt(st.nextToken());

            Problem21939 prob = new Problem21939(probNum, probDif);

            treeSet.add(prob);
            map.put(probNum, probDif);
        }

        P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int probNum = Integer.parseInt(st.nextToken());
                int probDif = Integer.parseInt(st.nextToken());
                Problem21939 prob = new Problem21939(probNum, probDif);

                add(prob);
            } else if (command.equals("recommend")) {
                int order = Integer.parseInt(st.nextToken());

                recommend(order);
            } else if (command.equals("solved")) {
                int probNum = Integer.parseInt(st.nextToken());

                solved(probNum);
            }
        }
    }

    private static void add(Problem21939 prob) {
        treeSet.add(prob);
        map.put(prob.num, prob.dif);
    }

    private static void solved(int probNum) {
        int num = probNum;
        int dif = map.get(num);

        treeSet.remove(new Problem21939(num, dif));
        map.remove(probNum);
    }

    private static void recommend(int order) {
        if (order == 1) {
            System.out.println(treeSet.first().num);
        } else {
            System.out.println(treeSet.last().num);
        }
    }
}

class Problem21939 implements Comparable<Problem21939>{
    int num, dif;
    public Problem21939 (int num, int dif) {
        this.num = num;
        this.dif = dif;
    }
    @Override
    public int compareTo (Problem21939 p) {
        if (this.dif == p.dif) {
            return Integer.compare(p.num, this.num);
        }
        return Integer.compare(p.dif, this.dif);
    }
}
