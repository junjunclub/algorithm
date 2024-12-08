import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Country> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Country(id, gold, silver, bronze, 0));
        }

        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                if (c1.gold == c2.gold) {
                    if (c1.silver == c2.silver) {
                        return c2.bronze - c1.bronze;
                    }
                    return c2.silver - c1.silver;
                }
                return c2.gold - c1.gold;
            }
        });

        list.get(0).rank = 1;
        
        int idx = 0;
        
        for (int i = 1; i < n; i++) {
            if (list.get(i).gold != list.get(i-1).gold || list.get(i).silver != list.get(i-1).silver || list.get(i).bronze != list.get(i-1).bronze) {
                list.get(i).rank = list.get(i-1).rank + 1;
            }
            if (list.get(i).id == m) {
                idx = i;
            }
        }

        System.out.println(list.get(idx).rank);
    }
}

class Country {
    int id,gold,silver,bronze, rank;
    public Country(int id, int gold, int silver, int bronze, int rank) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = rank;
    }
}
