class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> resultMap = new HashMap<>();
        
        for(String s : strs){
            int[] dp = new int[26];
            for(char c:s.toCharArray()){
                dp[c-'a']++;
            }
            StringBuilder keyString = new StringBuilder();
            for(int i : dp){
                keyString.append("#").append(i);               
            }
            String key = keyString.toString();
            resultMap.computeIfAbsent(key,k->new ArrayList<>()).add(s);
            
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> iL: resultMap.values() ){
            result.add(iL);
        }
        return result;
         
    }
}
