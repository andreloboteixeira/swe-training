import java.util.*;
public class Solution{
    public static void main(String[] args){

        if(Solution.maxProfit(new int[]{7,1,5,3,6,4}) == 5){
            System.out.println("Ex1 correct");
        }

        if(Solution.maxProfit(new int[]{7,6,4,3,1}) == 0){
            System.out.println("Ex2 correct");
        }

    }

    // t: O(n), s: O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minValBuy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            int curr = prices[i];
            minValBuy = Integer.min(minValBuy, curr);
            maxProfit = Integer.max(maxProfit, curr - minValBuy);
        }

        return maxProfit;
    }
}
