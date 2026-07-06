class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for (int x : nums)
            total += x;

        if (Math.abs(target) > total)
            return 0;

        if ((target + total) % 2 != 0)
            return 0;

        int sum = (target + total) / 2;

        int[][] dp = new int[nums.length][sum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return help(nums.length - 1, sum, nums, dp);
    }

    int help(int ind, int sum, int[] nums, int[][] dp) {

        if (ind == 0) {

            if (sum == 0 && nums[0] == 0)
                return 2;

            if (sum == 0 || sum == nums[0])
                return 1;

            return 0;
        }

        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        int notTake = help(ind - 1, sum, nums, dp);

        int take = 0;

        if (nums[ind] <= sum)
            take = help(ind - 1, sum - nums[ind], nums, dp);

        return dp[ind][sum] = take + notTake;
    }
}