class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);

        return help(0, target, nums, dp);
    }

    boolean help(int ind, int target, int[] nums, int[][] dp) {

        if (target == 0)
            return true;

        if (ind == nums.length)
            return false;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean take = false;

        if (nums[ind] <= target)
            take = help(ind + 1, target - nums[ind], nums, dp);

        boolean notTake = help(ind + 1, target, nums, dp);

        dp[ind][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }
}