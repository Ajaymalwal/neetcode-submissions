class Solution {
    public int rob(int[] nums) {
        if(nums.length  == 1) return nums[0];
        int rob1 = 0, rob2 = 0;

        for(int i=0; i <= nums.length-2; i++){
            int temp = Math.max(nums[i]+rob1,rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int max1 = Math.max(rob1,rob2);

        rob1 = 0; rob2 =0;
        for(int i=nums.length-1; i >= 1; i--){
            int temp = Math.max(nums[i]+rob1,rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int max2 = Math.max(rob1,rob2);

        return Math.max(max1,max2);
    }
}