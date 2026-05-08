class Solution {
    private List<String> rs = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return rs;
        String[] arr = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
        };
        backtrack(0,arr,digits,new StringBuilder());
        return rs;
    }
    void backtrack(int idx,String[] arr,String digits,StringBuilder sb){
        
        if(sb.length() == digits.length()) {
            rs.add(sb.toString());
            return;
        }
        int ch = digits.charAt(idx) - '0';
        for(int i=0; i < arr[ch].length(); i++){
            sb.append(arr[ch].charAt(i));
            backtrack(idx+1,arr,digits,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}