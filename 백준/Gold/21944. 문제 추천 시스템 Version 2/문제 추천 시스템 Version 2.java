import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    // G : 알고리즘 분류, L : 문제 난이도, P : 문제 번호
    static int N, M;
    static TreeSet<Problem21944>[] list;
    static TreeSet<Problem21944> allList;
    // 문제의 상태를 확인할 수 있는 map
    static Map<Integer, Problem2> map;
    public static void main(String[] args) throws Exception{
        init();
        /**
         * 1. TreeSet[]을 활용한다.
         * 2. Map<문제번호, 알고리즘 분류>의 자료구조를 통해 상태를 확인할 수 있도록 한다. 풀거나, 삭제할 경우에는 -1로 갱신
         */
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        list = new TreeSet[101];

        for (int i = 1; i <= 100; i++) {
            list[i] = new TreeSet<>();
        }

        allList = new TreeSet<>();

        // 전체 리스트와 알고리즘 분류로 구분하는 트리셋에 문제 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            Problem21944 p = new Problem21944(P, L);
            add(P, L, G);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if (input.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                recommend(G, x);
            } else if (input.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                recommend2(x);
            } else if (input.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                recommend3(x, L);
            } else if (input.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                add(P, L, G);
            } else if (input.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }
    }

    private static void add(int P, int L, int G) {
        // 문제 넣기
        Problem21944 p = new Problem21944(P, L);
        Problem2 p2 = new Problem2(L, G);
        list[G].add(p);
        allList.add(p);
        map.put(P, p2);
    }

    private static void solved(int p) {
        Problem2 p2 = map.get(p);
        int l = p2.L;
        int g = p2.G;
        Problem21944 prob = new Problem21944(p, l);
        list[g].remove(prob);
        allList.remove(prob);
        map.remove(p2);
    }

    private static void recommend(int g, int x) {
        if (x == 1) {
            System.out.println(list[g].last().P);
        } else if (x == -1) {
            System.out.println(list[g].first().P);
        }
    }

    private static void recommend2(int x) {
        if (x == 1) {
            System.out.println(allList.last().P);
        } else if (x == -1) {
            System.out.println(allList.first().P);
        }
    }

    private static void recommend3(int x, int l) {
        if (x == 1) {
            Problem21944 prob = allList.higher(new Problem21944(-1, l));
            if (prob == null) {
                System.out.println(-1);
            } else {
                System.out.println(prob.P);
            }
        } else {
            Problem21944 prob = allList.lower(new Problem21944(-1, l));
            if (prob == null) {
                System.out.println(-1);
            } else {
                System.out.println(prob.P);
            }
        }
    }
}

class Problem21944 implements Comparable<Problem21944> {
    int P, L;
    public Problem21944 (int P, int L) {
        this.P = P;
        this.L = L;
    }
    @Override
    public int compareTo (Problem21944 p) {
        if (p.L == this.L) {
            return Integer.compare(this.P, p.P);
        }
        return Integer.compare(this.L, p.L);
    }
}

class Problem2 {
    int L, G;
    public Problem2 (int L, int G) {
        this.L = L;
        this.G = G;
    }
}