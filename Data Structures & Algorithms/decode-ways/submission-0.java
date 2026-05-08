class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        memo = new Integer[s.length()];
        return dfs(0,s);
    }
    int dfs(int i,String s){
        if(i == s.length()) return 1;

        if(s.charAt(i) == '0') return 0;
        if(memo[i] != null) return memo[i];

        int ways = dfs(i+1,s);
        if(i+1 < s.length()){
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num >= 10 && num <= 26){
                ways += dfs(i+2,s);
            }
        }
        return memo[i] = ways;
    }
}