class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> in = new HashSet<>();
        for(int num : nums){
            if(in.contains(num)) return true;
            in.add(num);
        }
        return false;
      
    }
}