package greedy;

import javax.swing.*;

// 122
public class BestTimeBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i<prices.length; i++){
            if (prices[i] - prices[i-1] >0){
                sum+= prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
