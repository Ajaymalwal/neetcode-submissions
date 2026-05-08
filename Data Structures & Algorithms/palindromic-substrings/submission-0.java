class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        int res = 0;
        for(int i=0; i< s.length(); i++){
            int count = 0;
            int even = expand(s,i,i+1,count);
            int odd = expand(s,i,i,count);
            res += even + odd;
        }
        return res;
    }
    int expand(String s,int l,int r,int res){
        while(l >= 0 && r <s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            res++;
        }
        return res;
    }
}
