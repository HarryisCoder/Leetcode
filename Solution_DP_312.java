

public class Solution_DP_312 {
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i+1] = nums[i];
        }
        int[][] opt = new int[n+2][n+2];
        
        for(int i = 0; i < n+2; i++){
            for(int j = 0; j < n+2; j++){
                if(j == i+1){opt[i][j] = 0;}
                else{
                    int temp = 0;
                    for(int k = i+1; k < j; k++){
                        temp = Math.max(opt[i][k] + opt[k][j] + newNums[i] * newNums[k] * newNums[j], temp);
                    }
                }
            }
        }
        int left = 0;
        int right = n + 1;
        return opt[left][right];
    }
}