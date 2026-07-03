class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = help(0, coins, amount, dp);

        return ans >= (int)1e9 ? -1 : ans;
    }

    int help(int ind, int[] coins, int tar, int[][] dp) {

        // Base case: only one coin left
        if (ind == coins.length - 1) {
            if (tar % coins[ind] == 0)
                return tar / coins[ind];
            return (int)1e9;
        }

        if (dp[ind][tar] != -1)
            return dp[ind][tar];

        // Don't take current coin
        int notTake = help(ind + 1, coins, tar, dp);

        // Take current coin
        int take = (int)1e9;
        if (coins[ind] <= tar) {
            take = 1 + help(ind, coins, tar - coins[ind], dp);
        }

        return dp[ind][tar] = Math.min(take, notTake);
    }
}