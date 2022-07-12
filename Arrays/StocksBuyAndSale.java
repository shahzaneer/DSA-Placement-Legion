//! Question
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
class StocksBuyAndSale {

    //! Brute Force Approach (the most simplest Approach according to the logic but not the best approach)
    // static public int maxProfit(int[] prices) {
    //     int maxProfit = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         for (int j = i + 1; j < prices.length; j++) {
    //             int profit = prices[j] - prices[i];
    //             if (maxProfit < profit) {
    //                 maxProfit = profit;
    //             }
    //         }
    //     }

    //     return maxProfit;

    // }

    // ! Optimized Approach

    static public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPurchase = 9999;
        for (int i = 0; i < prices.length; i++) {
            if (minPurchase > prices[i]) {
                minPurchase = prices[i];
            } else if (prices[i] - minPurchase > maxProfit) {
                maxProfit = prices[i] - minPurchase;
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        // int prices[] = { 7, 1, 5, 3, 6, 4 };

        int prices[] = { 2, 4, 1 }; // aik ko khareedh kr 4 ko bechna possible nhi hai stocks ko

        System.out.println(maxProfit(prices));

    }
}
