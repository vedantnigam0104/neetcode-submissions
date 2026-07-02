class Solution {

    public int rob(int[] cost) {

        if (cost.length == 1)
            return cost[0];

        int[] dp1 = new int[cost.length];
        int[] dp2 = new int[cost.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
                help(0, cost, dp1, cost.length - 2),
                help(1, cost, dp2, cost.length - 1)
        );
    }

    int help(int ind, int[] cost, int[] dp, int end) {

        if (ind > end)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int rob = cost[ind] + help(ind + 2, cost, dp, end);

        int notrob = help(ind + 1, cost, dp, end);

        return dp[ind] = Math.max(rob, notrob);
    }
}