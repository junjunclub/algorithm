import java.io.*;
import java.util.*;

class Solution {
    static int[] discount = {10, 20, 30, 40};
    static class Emoticon {
        int price, percent;
        public Emoticon (int price, int percent) {
            this.price = price;
            this.percent = percent;
        }
    }
    
    static int[][] gUsers;
    
    static int totalCnt = 0;
    static int totalPrice = 0;
    
    static Emoticon[] arr;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        gUsers = users;
        
        arr = new Emoticon[emoticons.length];
        
        for (int i = 0; i < emoticons.length; i++) {
            arr[i] = new Emoticon(emoticons[i], discount[0]);
        }
        
        perm(0, new int[arr.length]);
        int[] answer = {totalCnt, totalPrice};
        
        return answer;
    }
    
    public static void perm(int depth, int[] discounts) {
        if (depth == discounts.length) {
            int cnt = 0;
            int price = 0;
            for (int i = 0; i < gUsers.length; i++) {
                int temp = 0;
                for (int j = 0; j < discounts.length; j++) {
                    if (gUsers[i][0] <= discounts[j]) {
                        int p = (arr[j].price * (100 - discounts[j])) / 100;
                        temp += p;
                    }
                }
                
                if (temp >= gUsers[i][1]) {
                    cnt++;
                    continue;
                } else {
                    price += temp;
                }
            }
            
            if (cnt > totalCnt) {
                totalCnt = cnt;
                totalPrice = price;
            } else if (cnt == totalCnt && (price > totalPrice)) {
                totalPrice = price;
            }

            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discounts[depth] = discount[i];
            perm(depth + 1, discounts);
        }
    }
}