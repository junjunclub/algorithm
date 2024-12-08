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

        Collections.sort(list);
        list.get(0).rank = 1;

        int idx = 0;

        for (int i = 1; i < list.size(); i++) {
            Country prevCountry = list.get(i - 1);
            Country nowCountry = list.get(i);

            nowCountry.rank = nowCountry.compareTo(prevCountry) == 0
                    ? prevCountry.rank
                    : i + 1;

            if (nowCountry.id == m) {
                idx = i;
            }
        }
        System.out.println(list.get(idx).rank);
    }
}

class Country implements Comparable<Country> {
    int id,gold,silver,bronze, rank;
    public Country(int id, int gold, int silver, int bronze, int rank) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = rank;
    }

    @Override
    public int compareTo(Country c) {
        if (this.gold == c.gold) {
            if (this.silver == c.silver) {
                return c.bronze - this.bronze;
            } else {
                return c.silver - this.silver;
            }
        } else {
            return c.gold - this.gold;
        }
    }
}
