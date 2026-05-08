class Solution {
    class TrieNode{
        TrieNode[] childern;
        boolean isWord;
        TrieNode(){
            childern = new TrieNode[26];
            isWord = false;
            } 
        }


    void createTrie(String word,TrieNode root){
        TrieNode curr = root;
       for(int i=0; i<word.length(); i++){
        int index  = word.charAt(i) - 'a';
        if(curr.childern[index] == null){
            curr.childern[index] = new TrieNode();
        }
        curr = curr.childern[index];
       }
       curr.isWord = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for( String word : wordDict){
            createTrie(word,root);
        }
         
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=0; i<n; i++){
            if(!dp[i]) continue;
            TrieNode curr = root;
            for(int j =i; j<n; j++){
                int index = s.charAt(j) - 'a';
                if(curr.childern[index] == null){
                    break;
                }
                curr = curr.childern[index];
                if(curr.isWord){
                    dp[j+1] = true;
                }
            }
        }
        return dp[n];

    }
}