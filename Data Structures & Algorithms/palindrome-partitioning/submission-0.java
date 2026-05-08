class Solution {
     private List<List<String>> rs = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, new ArrayList<>(), s);
        return rs;
    }
    void backtrack(int start, List<String> list, String s){
        if(start == s.length()) {
            rs.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                backtrack(i + 1, list, s);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}