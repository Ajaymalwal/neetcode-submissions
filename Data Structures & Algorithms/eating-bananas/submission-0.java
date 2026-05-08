class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r =Arrays.stream(piles).max().getAsInt();
        int l =1;
        int k_min = r;
        while(l <= r){
          int mid = l+(r-l)/2;
          int hours = 0;

            for(int pile : piles){
               hours +=(int) Math.ceil((double)pile/mid);
            }
            if(hours <= h){
                
                r = mid - 1;
            }
            else l = mid+1;
        }
        return l;
    }
}
