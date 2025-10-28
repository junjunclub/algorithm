import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int answer = 0; //가장 많은 상금을 받은 사람의 상금을 저장할 변수
        int num = Integer.parseInt(br.readLine()); //참여하는 사람의 수

        String[] strings; //주사위를 던진 4개의 눈이 저장될 배열

        for(int i = 0; i < num; i++){
            strings = br.readLine().split(" ");
            
            HashMap<Integer, Integer> counts = new HashMap<>(); //key = 주사위의 눈, value = 해당 주사위의 눈이 나온 갯수
            int count = 0; //주사위의 눈이 나온 갯수를 세기 위한 변수
            for (int j = 1; j <= 6; j++){
                for (String s : strings){
                    if (j == Integer.parseInt(s)){ //현재 주사위의 눈과 던져진 눈이 같을 경우 count++
                        count++;
                    }
                }
                counts.put(j, count);
                count = 0;
            }

            // System.out.println(counts);
            
            int diceNum = 0;
            int DoubleTwoNum = 0; 
            int maxPrice = 0;
            int price = 0;

            Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
            Iterator<Map.Entry<Integer, Integer>> itr = entrySet.iterator();
            Integer twoDouble[] = new Integer[2]; //같은 눈이 2개씩 1쌍 혹은 2쌍 나올 경우 이 배열에 담는다
            while(itr.hasNext()){
                Map.Entry<Integer, Integer> eachEntry = itr.next();
                // System.out.println("value값 : " + eachEntry.getValue());
                if (eachEntry.getValue() == 4){
                    diceNum = eachEntry.getKey();
                    price = 50000 + diceNum * 5000;
                } else if (eachEntry.getValue() == 3){
                    diceNum = eachEntry.getKey();
                    price = 10000 + diceNum * 1000;
                } else if (eachEntry.getValue() == 2){
                    twoDouble[DoubleTwoNum] = eachEntry.getKey();
                    
                    if (DoubleTwoNum == 0) { //같은 눈이 2개씩 1쌍일때
                        price = 1000 + eachEntry.getKey() * 100;
                    } else {                //같은 눈이 2개씩 2쌍일때
                        price = 2000 + twoDouble[0] * 500 + twoDouble[1] * 500;
                    }

                    DoubleTwoNum++;
                } else if (eachEntry.getValue() == 1){
                    diceNum = eachEntry.getKey();
                    price = diceNum * 100;
                }

                if (price > maxPrice){
                    maxPrice = price;
                }
            }

            if (maxPrice > answer){
                answer = maxPrice;
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}