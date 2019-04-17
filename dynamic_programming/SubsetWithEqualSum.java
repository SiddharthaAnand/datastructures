// URL: https://leetcode.com/problems/partition-equal-subset-sum/
class SubsetWithEqualSum {
    public boolean canPartition(int[] nums, int length, int sum) {
        boolean[][] possible = new boolean[sum+1][nums.length+1];
        for (int i = 0; i <= length; i++)
            possible[0][i] = true;
        for (int j = 1; j <= sum; j++)
            possible[j][0] = false;
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= length; j++) {
                if (i >= nums[j-1])
                    possible[i][j] = possible[i][j-1] || possible[i-nums[j-1]][j-1];
            }
        }
        return possible[sum][length];
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 0) {
            return canPartition(nums, nums.length, sum/2);
        }
        return false;
    }
}